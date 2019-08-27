package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbDietPicture;
import com.bkit.fatdown.entity.TbDietPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDietPictureMapper {
    long countByExample(TbDietPictureExample example);

    int deleteByExample(TbDietPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDietPicture record);

    int insertSelective(TbDietPicture record);

    List<TbDietPicture> selectByExample(TbDietPictureExample example);

    TbDietPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDietPicture record, @Param("example") TbDietPictureExample example);

    int updateByExample(@Param("record") TbDietPicture record, @Param("example") TbDietPictureExample example);

    int updateByPrimaryKeySelective(TbDietPicture record);

    int updateByPrimaryKey(TbDietPicture record);
}