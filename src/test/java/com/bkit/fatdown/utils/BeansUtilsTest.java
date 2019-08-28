package com.bkit.fatdown.utils;

import com.bkit.fatdown.dto.food.ElementBasicDTO;
import com.bkit.fatdown.dto.food.ElementRelationDTO;
import com.bkit.fatdown.entity.TbElementBasic;
import com.bkit.fatdown.service.IElementBasicService;
import com.bkit.fatdown.service.IFoodElementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BeansUtilsTest {

    @Resource
    private IElementBasicService elementBasicService;

    @Test
    public void copy2Bean2() {
        TbElementBasic elementBasic = elementBasicService.getElementBasic(1);
        System.out.println(elementBasic.toString());
        ElementBasicDTO basicDTO = new ElementBasicDTO();
        System.out.println(basicDTO.toString());
        BeanUtils.copyProperties(elementBasic, basicDTO);
        System.out.println(basicDTO.toString());
    }
}