package com.bkit.fatdown.controller;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.diet.FoodInfoDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.service.*;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.RecogniseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @file: FoodController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物相关控制器
 * @date: Created in 8/7/19  4:07 PM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/food", tags = "食物推荐、饮食图库接口")
@RestController
@RequestMapping("/food")
public class FoodController {

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Resource
    private IDietFoodService foodService;

    @Resource
    private IFoodRecommendService recommendService;

    @Resource
    private IFoodRecommendRecordService recommendRecordService;

    @Resource
    private IFoodBasicService foodBasicService;

    @Resource
    private IPictureService pictureService;

    @Resource
    private IFoodRecommendTypeService recommendTypeService;

    private static final int DATA_NOT_EXIST = 0;

    @ApiOperation("获取指定类型推荐菜式")
    @CrossOrigin
    @RequestMapping(value = "/listFoodRecommend", method = RequestMethod.GET)
    public CommonResultDTO listFoodRecommend(@RequestParam Integer foodType) {
        if (foodType == null || recommendTypeService.countType(foodType) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("foodType参数错误");
        }

        List<TbFoodRecommend> recommendList = recommendService.listFoodRecommend(foodType);

        if (recommendList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("查找失败");
        }

        return CommonResultDTO.success(recommendList);
    }

    @ApiOperation("添加食物推荐信息")
    @CrossOrigin
    @RequestMapping(value = "/addFoodRecommend", method = RequestMethod.POST)
    public CommonResultDTO addFoodRecommend(@RequestParam String foodName, @RequestParam Integer foodType) {
        if (foodName.isEmpty() || recommendTypeService.countType(foodType) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("foodName/foodType无效");
        }

        TbFoodRecommend recommend = new TbFoodRecommend();
        recommend.setFoodName(foodName);
        recommend.setFoodType(foodType);

        if (recommendService.insert(recommend)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed("添加食物推荐失败");
    }

    @ApiOperation("删除食物推荐信息")
    @CrossOrigin
    @RequestMapping(value = "/deleteFoodRecommend", method = RequestMethod.DELETE)
    public CommonResultDTO deleteFoodRecommend(@RequestParam Integer id) {
        if (id == null || recommendService.countFoodRecommend(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id无效");
        }

        if (recommendService.delete(id)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed("删除食物推荐失败");
    }

    @ApiOperation("更新食物推荐信息")
    @CrossOrigin
    @RequestMapping(value = "/updateFoodRecommend", method = RequestMethod.POST)
    public CommonResultDTO updateFoodRecommend(@RequestParam Integer id, @RequestParam String foodName, @RequestParam Integer foodType) {
        if (foodName.isEmpty() || recommendTypeService.countType(foodType) == DATA_NOT_EXIST
                || id == null || recommendService.countFoodRecommend(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id/foodName/foodType无效");
        }

        TbFoodRecommend recommend = new TbFoodRecommend();
        recommend.setFoodName(foodName);
        recommend.setFoodType(foodType);
        recommend.setId(id);

        if (recommendService.update(recommend)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed("更新食物推荐失败");
    }

    @ApiOperation("获取食物推荐信息")
    @CrossOrigin
    @RequestMapping(value = "/getFoodRecommend", method = RequestMethod.GET)
    public CommonResultDTO getFoodRecommend(@RequestParam Integer id) {
        if (id == null || recommendService.countFoodRecommend(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id无效");
        }

        TbFoodRecommend foodRecommend = recommendService.getFoodRecommend(id);

        if (foodRecommend == null) {
            return CommonResultDTO.failed("获取食物推荐信息失败");
        }

        return CommonResultDTO.success(foodRecommend);
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
        if (recommendRecordService.updateOnlyRecord(recommendRecord)) {
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

        List<TbFoodRecommendRecord> recordList = recommendRecordService.listFoodRecommendRecord(uid, inputDate);

        if (recordList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("记录不存在");
        }

        return CommonResultDTO.success(recordList);
    }

    @ApiOperation("获取所有推荐菜式类型")
    @CrossOrigin
    @RequestMapping(value = "listAllRecommendType", method = RequestMethod.GET)
    public CommonResultDTO<List<TbFoodRecommendType>> listAllRecommendType() {
        List<TbFoodRecommendType> typeList = recommendTypeService.listAllType();
        if (typeList.size() == 0) {
            return CommonResultDTO.failed("暂无数据");
        }
        return CommonResultDTO.success(typeList);
    }

    @ApiOperation("查找推荐菜式类型信息")
    @CrossOrigin
    @RequestMapping(value = "/getRecommendTypeInfo", method = RequestMethod.GET)
    public CommonResultDTO<TbFoodRecommendType> getRecommendTypeInfo(@RequestParam int id) {
        if (recommendTypeService.countType(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("类型不存在");
        }
        TbFoodRecommendType typeInfo = recommendTypeService.getTypeInfo(id);

        if (typeInfo == null) {
            return CommonResultDTO.failed("类型查找失败");
        }
        return CommonResultDTO.success(typeInfo);
    }

    @ApiOperation("删除推荐菜式类型信息")
    @CrossOrigin
    @RequestMapping(value = "/deleteRecommendType", method = RequestMethod.DELETE)
    public CommonResultDTO deleteRecommendType(@RequestParam int id) {
        if (recommendTypeService.countType(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("类型不存在");
        }

        if (recommendTypeService.delete(id)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed("类型删除失败");
    }

    @ApiOperation("添加推荐菜式类型信息")
    @CrossOrigin
    @RequestMapping(value = "/addRecommendType", method = RequestMethod.POST)
    public CommonResultDTO addRecommendType(@RequestParam String typeName) {
        if (typeName.isEmpty()) {
            return CommonResultDTO.validateFailed("菜式类型名称不能为空");
        }

        TbFoodRecommendType recommendType = new TbFoodRecommendType();
        recommendType.setTypeName(typeName);

        if (recommendTypeService.insert(recommendType)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed("类型添加失败");
    }

    @ApiOperation("更新推荐菜式类型信息")
    @CrossOrigin
    @RequestMapping(value = "/updateRecommendType", method = RequestMethod.POST)
    public CommonResultDTO updateRecommendType(@RequestParam String typeName, @RequestParam Integer id) {
        if (typeName.isEmpty() || id == null) {
            return CommonResultDTO.validateFailed("菜式类型名称或id不能为空");
        }

        TbFoodRecommendType recommendType = new TbFoodRecommendType();
        recommendType.setTypeName(typeName);
        recommendType.setId(id);

        if (recommendTypeService.update(recommendType)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed("类型更新失败");
    }

    @ApiOperation("计算菜式成分总和")
    @CrossOrigin
    @RequestMapping(value = "/getFoodElementTotal", method = RequestMethod.GET)
    public CommonResultDTO getFoodElementTotalById(@RequestParam Integer foodId) {
        if (foodBasicService.countFoodBasic(foodId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id错误");
        }
        return CommonResultDTO.success(foodService.getDietRecord(foodId));
    }

    @ApiOperation("获取用餐菜式信息")
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

    @ApiOperation("上传图片并保存菜式信息")
    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @Transactional
    public CommonResultDTO upload(@RequestParam("picture") MultipartFile picture, @RequestParam Integer uid,
                                  @RequestParam String foodName, @RequestParam Double gram) {
        Map<String, Object> result = pictureService.upload(picture, uid, new Date());

        String empty = "msg";
        String urlOfString = "url";
        String flagOfExist = "flag";

        if (result.containsKey(empty)) {
            return CommonResultDTO.validateFailed("上传文件为空");
        }

        // 判断上传是否成功，url：图片路径，flag=0上传失败
        if (result.containsKey(urlOfString) && result.containsKey(flagOfExist)) {
            int id;
            TbFoodRecord foodRecord;
            int flag = Integer.parseInt(result.get(flagOfExist).toString());
            String imgUrl = result.get(flagOfExist).toString();

            // 上传图片失败
            if (flag == DATA_NOT_EXIST) {
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
                // 菜式不存在
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
        String foodData = "data";
        // 解析识别返回结果数组
        JSONObject jsonObject = RecogniseUtils.recognise(file);
        if (jsonObject.getJSONArray(foodData).size() == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("无法识别或识别结果为空");
        }

        return CommonResultDTO.success(jsonObject.getJSONArray(foodData));
    }

    @ApiOperation("获取早餐饮食图库")
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

    @ApiOperation("获取午餐饮食图库")
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

    @ApiOperation("获取晚餐饮食图库")
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

    @ApiOperation("获取早、午、晚餐饮食图库")
    @CrossOrigin
    @RequestMapping(value = "/listDietPicture/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listDietPicture(@PathVariable Integer uid, @PathVariable String date) {

        HashMap<String, Object> listMap = pictureService.listByDate(uid, DateUtils.string2Date(date));
        if (listMap.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("该日期下没有记录");
        }
        return CommonResultDTO.success(listMap);
    }
}
