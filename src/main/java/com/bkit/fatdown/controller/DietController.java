package com.bkit.fatdown.controller;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.dto.*;
import com.bkit.fatdown.dto.diet.*;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.service.*;
import com.bkit.fatdown.utils.DataTransferUtils;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.RecogniseUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

/**
 * @file: DietController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食模块控制器
 * @date: Created in 7/12/19  10:50 PM
 * @modified:
 * @version: 1.0
 */

@RestController
@RequestMapping("/diet")
public class DietController {
    @Resource
    private IPictureService pictureService;

    @Resource
    private IFoodBasicService foodBasicService;

    @Resource
    private IDietFoodService foodService;

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Resource
    private IDietReportService reportService;

    @Resource
    private IFoodRecommendService recommendService;

    @Resource
    private IFoodRecommendRecordService foodRecommendRecordService;

    @Resource
    private IDietRecordService dietRecordService;

    private static final int DATA_NOT_EXIST = 0;
    private static final int DATA_EXIST = 1;

    /**
     * 三餐记录数3
     * 报告类型：
     * 0,早餐，1，午餐，2，晚餐，3,加餐，
     * 4，每天，5,每周，6，每月
     */
    private static final int DAILY_REPORT_TOTAL = 3;
    private static final int WEEKLY_REPORT_MIN_TOTAL = 15;
    private static final int MOUTH_REPORT_MIN_TOTAL = 65;
    private static final int BREAKFAST_TYPE = 0;
    private static final int LUNCH_TYPE = 1;
    private static final int DINNER_TYPE = 2;
    private static final int DAILY_TYPE = 4;

    /**
     * 推荐菜式类型上下限
     */
    private static final int FOOD_TYPE_UPPER = 8;
    private static final int FOOD_TYPE_LOWER = 1;

    @ApiOperation("获取用餐信息，菜式名，重量（type：0早餐，1午餐，2晚餐）")
    @CrossOrigin
    @RequestMapping(value = "/listFoodInfo", method = RequestMethod.GET)
    public CommonResultDTO<List<FoodInfoDTO>> listFoodInfo(@RequestParam Integer uid, @RequestParam String date,
                                                           @RequestParam Integer type) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        List<FoodInfoDTO> recordList = foodService.listFoodInfoDTO(uid, inputDate, type);
        if (recordList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("记录不存在");
        }
        return CommonResultDTO.success(recordList);
    }

    @ApiOperation("查看早餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getBreakfastReport", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getBreakfastReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid/date无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, BREAKFAST_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, BREAKFAST_TYPE, uid);
            if (report == null) {
                return CommonResultDTO.failed("记录为空");
            }
            return CommonResultDTO.success(DataTransferUtils.transferDietMealReport(report));
        }

        // 数据不存在时
        if (pictureService.countRecord(DateUtils.getBreakfastStartTime(inputDate),
                DateUtils.getBreakfastEndTime(inputDate), uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, BREAKFAST_TYPE));
    }

    @ApiOperation("查看午餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getLunchReport", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getLunchReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid无效");
        }
        Date inputDate = DateUtils.string2Date(date);

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, LUNCH_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, LUNCH_TYPE, uid);
            if (report == null) {
                return CommonResultDTO.failed("记录为空");
            }
            return CommonResultDTO.success(DataTransferUtils.transferDietMealReport(report));
        }

        // 数据不存在时
        if (pictureService.countRecord(DateUtils.getLunchStartTime(inputDate), DateUtils.getLunchEndTime(inputDate), uid)
                == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, LUNCH_TYPE));
    }

    @ApiOperation("查看晚餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getDinnerReport", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getDinnerReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, DINNER_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, DINNER_TYPE, uid);
            if (report == null) {
                return CommonResultDTO.failed("记录为空");
            }
            return CommonResultDTO.success(DataTransferUtils.transferDietMealReport(report));
        }

        // 数据不存在时
        if (pictureService.countRecord(DateUtils.getDinnerStartTime(inputDate), DateUtils.getDinnerEndTime(inputDate), uid)
                == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, DINNER_TYPE));
    }

    @ApiOperation("查看每天饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getDailyReport", method = RequestMethod.GET)
    public CommonResultDTO<DietDailyReport> getDailyReportByUid(@RequestParam Integer uid, @RequestParam String date) {

        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid/date为空无效");
        }
        Date inputDate = DateUtils.string2Date(date);

        if (dietRecordService.countDietRecord(inputDate, uid) < DAILY_REPORT_TOTAL) {
            return CommonResultDTO.failed("数据不足,无法进行评价");
        }

        if (reportService.countDietDailyReport(inputDate, uid) >= DATA_EXIST) {
            TbDietDailyReport report = reportService.getDietDailyReport(inputDate, uid);
            if (report == null) {
                return CommonResultDTO.failed("记录为空");
            }
            return CommonResultDTO.success(DataTransferUtils.transferDailyReport(report));
        }

        // 生成每日饮食报告
        DietDailyReport dailyReport = reportService.generateDailyReport(inputDate, uid, DAILY_TYPE);

        if (dailyReport == null) {
            return CommonResultDTO.failed("数据为空");
        }

        return CommonResultDTO.success(dailyReport);
    }

    @ApiOperation("查看三餐饮食报告，通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/listDailyReport", method = RequestMethod.GET)
    public CommonResultDTO<List<DietMealReport>> listDailyReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        DietMealReport breakfast, lunch, dinner;
        Date inputDate = DateUtils.string2Date(date);
        List<DietMealReport> reportList = new ArrayList<>(DAILY_REPORT_TOTAL);

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, BREAKFAST_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, BREAKFAST_TYPE, uid);
            breakfast = DataTransferUtils.transferDietMealReport(report);
        } else {
            breakfast = reportService.generateMealReport(inputDate, uid, BREAKFAST_TYPE);
        }

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, LUNCH_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, LUNCH_TYPE, uid);
            lunch = DataTransferUtils.transferDietMealReport(report);
        } else {
            lunch = reportService.generateMealReport(inputDate, uid, LUNCH_TYPE);
        }

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, DINNER_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, DINNER_TYPE, uid);
            dinner = DataTransferUtils.transferDietMealReport(report);
        } else {
            dinner = reportService.generateMealReport(inputDate, uid, DINNER_TYPE);
        }

        reportList.add(breakfast);
        reportList.add(lunch);
        reportList.add(dinner);

        return CommonResultDTO.success(reportList);
    }

    @ApiOperation("查看每周饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getWeeklyReport", method = RequestMethod.GET)
    public CommonResultDTO<DietWeeklyReport> getWeeklyReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

//        // 少于15次报告，无法生成数据
//        if (reportService.countDietMealReport(inputDate, uid) < WEEKLY_REPORT_MIN_TOTAL) {
//            return CommonResultDTO.failed("用餐数据少于15餐，无法生成有效数据");
//        }

        // 存在报告记录，直接返回记录

        // 生成每周报告记录
        DietWeeklyReport report = reportService.generateWeeklyReport(inputDate, uid);
        // 如果报告为空，返回错误
        if (report == null) {
            return CommonResultDTO.failed("报告为空！");
        }

        return CommonResultDTO.success(report);
    }

    @ApiOperation("查看每月饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getMonthlyReport", method = RequestMethod.GET)
    public CommonResultDTO<DietMonthReport> getMonthlyReportByUid(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

//        // 少于65次报告，无法生成数据
//        if (reportService.countDietMealReport(inputDate, uid) < MOUTH_REPORT_MIN_TOTAL) {
//            return CommonResultDTO.failed("用餐数据少于65餐，无法生成有效数据");
//        }

        // 存在报告记录，直接返回记录

        // 生成每月报告记录

        // 如果报告为空，返回错误

        return CommonResultDTO.success(new DietMonthReport());
    }

    @ApiOperation("通过菜式Id，计算所含元素总量")
    @CrossOrigin
    @RequestMapping(value = "/getFoodElementTotal", method = RequestMethod.GET)
    public CommonResultDTO getFoodElementTotalById(@RequestParam Integer foodId) {
        if (foodBasicService.countFoodBasic(foodId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id错误");
        }
        return CommonResultDTO.success(foodService.getDietRecord(foodId));
    }

    @ApiOperation("上传饮食图片,保存饮食记录，uid，foodName(识别不出时，必填），gram（重量，识别不出时，必填）")
    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @Transactional
    public CommonResultDTO upload(@RequestParam("picture") MultipartFile picture, @RequestParam Integer uid,
                                  @RequestParam String foodName, Double gram) {
        Map<String, Object> result = pictureService.upload(picture, uid, new Date());

        if (result.containsKey("msg")) {
            return CommonResultDTO.validateFailed("上传文件为空");
        }

        // 判断上传是否成功，url：图片路径，flag=0上传失败
        if (result.containsKey("url") && result.containsKey("flag")) {
            int id;
            TbFoodRecord foodRecord;
            int flag = Integer.parseInt(result.get("flag").toString());
            String imgUrl = result.get("url").toString();

            // 上传图片失败
            if (flag == 0) {
                return CommonResultDTO.failed("上传图片失败");
            }

            // 查找食物基础信息是否存在？
            List<TbFoodBasic> foodList = foodBasicService.listByName(foodName);
            // 菜式不在数据库中,插入新菜式记录,flag= 0 -> 已有菜式，flag= 1 -> 新菜式
            if (foodList.size() == DATA_NOT_EXIST) {
                TbFoodBasic newFoodBasic = new TbFoodBasic();
                newFoodBasic.setFoodName(foodName);
                newFoodBasic.setQuantity(gram);
                newFoodBasic.setType("未知");
                newFoodBasic.setFlag(1);

                // 创建记录并返回创建id，id = -1 -> 插入失败
                id = foodBasicService.insertReturnId(newFoodBasic);
                if (id == -1) {
                    return CommonResultDTO.failed("创建菜式记录失败");
                }

                // 插入饮食记录
                foodRecord = new TbFoodRecord();
                foodRecord.setFoodId(id);
                foodRecord.setUserId(uid);
                foodRecord.setFoodQuantity(gram);
                foodRecord.setImgUrl(imgUrl);

                if (foodService.insert(foodRecord)) {
                    return CommonResultDTO.success();
                }
                return CommonResultDTO.failed("创建饮食记录失败");
            }

            // 插入饮食记录
            TbFoodBasic foodBasicBasic = foodList.get(0);
            foodRecord = new TbFoodRecord();
            foodRecord.setFoodId(foodBasicBasic.getId());
            foodRecord.setUserId(uid);
            foodRecord.setFoodQuantity(gram);
            foodRecord.setImgUrl(imgUrl);

            if (foodService.insert(foodRecord)) {
                return CommonResultDTO.success();
            }
            return CommonResultDTO.failed("创建饮食记录失败");
        }
        return CommonResultDTO.validateFailed("参数错误");
    }

    @ApiOperation("拍照获取识别食物结果")
    @CrossOrigin
    @RequestMapping(value = "/recognise", method = RequestMethod.POST)
    public CommonResultDTO recognise(@RequestParam MultipartFile file) {
        // 解析识别返回结果数组
        JSONObject jsonObject = RecogniseUtils.recognise(file);
        if (jsonObject.getJSONArray("data").size() == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("无法识别或识别结果为空");
        }

        return CommonResultDTO.success(jsonObject.getJSONArray("data"));
    }

    @ApiOperation("获取当天早餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listBreakfast/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listBreakfast(@PathVariable Integer uid, @PathVariable String date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getBreakfastStartTime(DateUtils.string2Date(date)),
                DateUtils.getBreakfastEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("早餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天午餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listLunch/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listLunch(@PathVariable Integer uid, @PathVariable String date) {

        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getLunchStartTime(DateUtils.string2Date(date)),
                DateUtils.getLunchEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("午餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天晚餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listDinner/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listDinner(@PathVariable Integer uid, @PathVariable String date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getDinnerStartTime(DateUtils.string2Date(date)),
                DateUtils.getDinnerEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("晚餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天三餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listDietPicture/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listDietPicture(@PathVariable Integer uid, @PathVariable String date) {

        HashMap<String, Object> listMap = pictureService.listByDate(uid, DateUtils.string2Date(date));
        if (listMap.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("该日期下没有记录");
        }
        return CommonResultDTO.success(listMap);
    }

    @ApiOperation("获取推荐菜式:1,蛋白质，2,碳水化合物，3,脂肪，4,纤维,5,豆类，6,坚果，7，优质蛋白质,8，动物性脂肪")
    @CrossOrigin
    @RequestMapping(value = "/listFoodRecommend", method = RequestMethod.GET)
    public CommonResultDTO listFoodRecommend(@RequestParam Integer foodType) {
        if (foodType == null || foodType > FOOD_TYPE_UPPER || foodType < FOOD_TYPE_LOWER) {
            return CommonResultDTO.validateFailed("foodType参数错误");
        }

        List<TbFoodRecommend> recommendList = recommendService.listFoodRecommend(foodType);

        if (recommendList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("查找失败");
        }

        return CommonResultDTO.success(recommendList);
    }

    @ApiOperation("创建推荐菜式选择记录")
    @CrossOrigin
    @RequestMapping(value = "/addFoodRecommendRecord", method = RequestMethod.GET)
    public CommonResultDTO addFoodRecommendRecord(@RequestParam int uid, @RequestParam int foodId,
                                                  @RequestParam String date, @RequestParam int foodType) {
        if (date == null || basicInfoService.countById(uid) == DATA_NOT_EXIST
                || recommendService.countFoodRecommend(foodId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid/recommendId 错误");
        }

        Date inputDate = DateUtils.string2Date(date);

        TbFoodRecommendRecord recommendRecord = new TbFoodRecommendRecord();
        recommendRecord.setFoodRecommendId(foodId);
        recommendRecord.setUserId(uid);
        recommendRecord.setFoodType(foodType);
        recommendRecord.setGmtCreate(inputDate);

        // 更新记录，不存在时，创建新记录
        if (foodRecommendRecordService.updateOnlyRecord(recommendRecord)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("获取推荐菜式选择记录")
    @CrossOrigin
    @RequestMapping(value = "/listFoodRecommendRecord", method = RequestMethod.GET)
    public CommonResultDTO<List<TbFoodRecommendRecord>> listFoodRecommendRecord(@RequestParam int uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid/date参数错误");
        }

        Date inputDate = DateUtils.string2Date(date);

        List<TbFoodRecommendRecord> recordList = foodRecommendRecordService.listFoodRecommendRecord(uid, inputDate);

        if (recordList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("记录不存在");
        }

        return CommonResultDTO.success(recordList);
    }
}
