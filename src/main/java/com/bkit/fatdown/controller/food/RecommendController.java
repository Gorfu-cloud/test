package com.bkit.fatdown.controller.food;

import java.util.ArrayList;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.food.FoodRecordInfoDTO;
import com.bkit.fatdown.dto.food.RecommendFoodDTO;
import com.bkit.fatdown.dto.food.RecommendFoodInfoDTO;
import com.bkit.fatdown.dto.food.RecommendTypeDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.service.*;
import com.bkit.fatdown.utils.DataTransferUtils;
import com.bkit.fatdown.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @file: FoodController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物相关控制器
 * @date: Created in 8/7/19  4:07 PM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/food", tags = "菜式推荐模块")
@RestController
@RequestMapping("/food")
public class RecommendController {

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Resource
    private IDietFoodService foodService;

    @Resource
    private IFoodRecommendService recommendService;

    @Resource
    private IFoodRecommendRecordService recommendRecordService;

    @Resource
    private IFoodRecommendTypeService recommendTypeService;

    private static final int DATA_NOT_EXIST = 0;

    private static final Logger logger = LoggerFactory.getLogger(RecommendController.class);

    @ApiOperation("指定类型,获取推荐菜式")
    @CrossOrigin
    @RequestMapping(value = "/foodRecommends/{foodType}", method = RequestMethod.GET)
    public CommonResultDTO listFoodRecommend(@PathVariable Integer foodType) {
        if (foodType == null || recommendTypeService.countType(foodType) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("foodType参数错误");
        }

        List<TbFoodRecommend> recommendList = recommendService.listFoodRecommend(foodType);

        if (recommendList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("查找失败");
        }

        return CommonResultDTO.success(recommendList);
    }

    @ApiOperation("分页：指定类型,获取推荐菜式")
    @CrossOrigin
    @RequestMapping(value = "/foodRecommends/{foodType}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listFoodRecommendByPage(@PathVariable Integer foodType, @PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        if (foodType == null || recommendTypeService.countType(foodType) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("foodType参数错误");
        }

        List<TbFoodRecommend> recommendList = recommendService.listFoodRecommend(foodType, pageNum, pageSize);

        if (recommendList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("查找失败");
        }

        return CommonResultDTO.success(CommonPageDTO.restPage(recommendList));
    }

    @ApiOperation("分页：查找指定名称、类型推荐菜式（名称可不传，所有类型：0）")
    @CrossOrigin
    @RequestMapping(value = "/foodRecommend/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listFoodRecommendLikeName(@RequestParam(required = false) String foodName, @RequestParam Integer foodType,
                                                                                      @PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        logger.info("search: foodName:{} ,foodType:{}, pageNum:{}, pageSize:{}", foodName, foodType, pageNum, pageSize);
        if (foodType == null || pageSize == null || pageNum == null) {
            return CommonResultDTO.validateFailed("foodType、pageSize、pageNum参数为空");
        }

        List<TbFoodRecommend> recommendList;

        // 查找所有食物推荐信息
        if (foodType == 0 && foodName == null) {
            recommendList = recommendService.listFoodRecommend(pageNum, pageSize);
        } else {
            recommendList = recommendService.listFoodRecommend(foodName, foodType, pageNum, pageSize);
        }

        if (recommendList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("查找失败");
        }

        return CommonResultDTO.success(CommonPageDTO.restPage(recommendList));
    }

    @ApiOperation("添加推荐菜式")
    @CrossOrigin
    @RequestMapping(value = "/foodRecommend", method = RequestMethod.POST)
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

    @ApiOperation("删除推荐菜式")
    @CrossOrigin
    @RequestMapping(value = "/foodRecommend/{id}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteFoodRecommend(@PathVariable Integer id) {
        if (id == null || recommendService.countFoodRecommend(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id无效");
        }

        if (recommendService.delete(id)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed("删除食物推荐失败");
    }

    @ApiOperation("更新推荐菜式")
    @CrossOrigin
    @RequestMapping(value = "/foodRecommend/{id}", method = RequestMethod.PUT)
    public CommonResultDTO updateFoodRecommend(@PathVariable Integer id, @RequestParam String foodName, @RequestParam Integer foodType) {
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

    @ApiOperation("获取推荐菜式")
    @CrossOrigin
    @RequestMapping(value = "/foodRecommend/{id}", method = RequestMethod.GET)
    public CommonResultDTO getFoodRecommend(@PathVariable Integer id) {
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
    @RequestMapping(value = "/recommendRecord/{uid}", method = RequestMethod.GET)
    public CommonResultDTO addFoodRecommendRecord(@PathVariable int uid, @RequestParam Integer foodId,
                                                  @RequestParam String date, @RequestParam Integer foodType) {
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
    @RequestMapping(value = "/recommendRecords", method = RequestMethod.GET)
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
    @RequestMapping(value = "/recommendTypes", method = RequestMethod.GET)
    public CommonResultDTO<List<TbFoodRecommendType>> listAllRecommendType() {
        List<TbFoodRecommendType> typeList = recommendTypeService.listAllType();
        if (typeList.size() == 0) {
            return CommonResultDTO.failed("暂无数据");
        }
        return CommonResultDTO.success(typeList);
    }

    @ApiOperation("分页：获取所有推荐菜式类型")
    @CrossOrigin
    @RequestMapping(value = "/recommendTypes/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO<CommonPageDTO> listAllRecommendTypeByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        List<TbFoodRecommendType> typeList = recommendTypeService.listAllType(pageNum, pageSize);
        return CommonResultDTO.success(CommonPageDTO.restPage(typeList));
    }

    @ApiOperation("分页：查找推荐菜式类型")
    @CrossOrigin
    @RequestMapping(value = "recommendType/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listRecommendTypeByPage(@RequestParam(required = false) String typeName,
                                                   @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        List<TbFoodRecommendType> typeList = recommendTypeService.listType(typeName, pageNum, pageSize);
        return CommonResultDTO.success(CommonPageDTO.restPage(typeList));
    }


    @ApiOperation("查找推荐菜式类型信息")
    @CrossOrigin
    @RequestMapping(value = "/recommendType/{id}", method = RequestMethod.GET)
    public CommonResultDTO<TbFoodRecommendType> getRecommendTypeInfo(@PathVariable int id) {
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
    @RequestMapping(value = "/recommendType/{id}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteRecommendType(@PathVariable int id) {
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
    @RequestMapping(value = "/recommendType", method = RequestMethod.POST)
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
    @RequestMapping(value = "/recommendType/{id}", method = RequestMethod.PUT)
    public CommonResultDTO updateRecommendType(@RequestParam String typeName, @PathVariable Integer id) {
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


    @ApiOperation("获取用餐菜式信息")
    @CrossOrigin
    @RequestMapping(value = "/foodInfo/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<List<FoodRecordInfoDTO>> listFoodInfo(@PathVariable Integer uid, @RequestParam String date,
                                                                 @RequestParam Integer type) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        List<FoodRecordInfoDTO> recordList = foodService.listFoodInfoDTO(uid, inputDate, type);
        if (recordList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("记录不存在");
        }
        return CommonResultDTO.success(recordList);
    }

    @ApiOperation("获取菜式推荐情况")
    @CrossOrigin
    @RequestMapping(value = "/recommendTypes/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<List<RecommendTypeDTO>> listRecommendType(@PathVariable Integer uid, @RequestParam String date,
                                                                     @RequestParam Integer type) {

        List<RecommendTypeDTO> recommendTypeDTOList = new ArrayList<>();

        RecommendTypeDTO recommendTypeDTO1 = new RecommendTypeDTO();
        recommendTypeDTO1.setId(1);
        recommendTypeDTO1.setStatus(0);
        recommendTypeDTO1.setTypeName("蛋白质");
        recommendTypeDTOList.add(recommendTypeDTO1);

        RecommendTypeDTO recommendTypeDTO2 = new RecommendTypeDTO();
        recommendTypeDTO2.setId(2);
        recommendTypeDTO2.setStatus(0);
        recommendTypeDTO2.setTypeName("主食");
        recommendTypeDTOList.add(recommendTypeDTO2);

        RecommendTypeDTO recommendTypeDTO3 = new RecommendTypeDTO();
        recommendTypeDTO3.setId(3);
        recommendTypeDTO3.setStatus(0);
        recommendTypeDTO3.setTypeName("脂肪");
        recommendTypeDTOList.add(recommendTypeDTO3);

        List<RecommendFoodInfoDTO> foodInfoDTOS1 = new ArrayList<>();
        List<RecommendFoodInfoDTO> foodInfoDTOS2 = new ArrayList<>();
        List<RecommendFoodInfoDTO> foodInfoDTOS3 = new ArrayList<>();

        List<TbFoodRecommend> recommendList1 = recommendService.listFoodRecommend(1);
        for (TbFoodRecommend recommend : recommendList1) {
            foodInfoDTOS1.add(DataTransferUtils.transferRecommendFoodInfo(recommend));
        }

        List<TbFoodRecommend> recommendList2 = recommendService.listFoodRecommend(2);
        for (TbFoodRecommend recommend : recommendList2) {
            foodInfoDTOS2.add(DataTransferUtils.transferRecommendFoodInfo(recommend));
        }

        List<TbFoodRecommend> recommendList3 = recommendService.listFoodRecommend(3);
        for (TbFoodRecommend recommend : recommendList3) {
            foodInfoDTOS3.add(DataTransferUtils.transferRecommendFoodInfo(recommend));
        }

        recommendTypeDTO1.setFoodList(foodInfoDTOS1);
        recommendTypeDTO2.setFoodList(foodInfoDTOS2);
        recommendTypeDTO3.setFoodList(foodInfoDTOS3);

        return CommonResultDTO.success(recommendTypeDTOList);
    }
}
