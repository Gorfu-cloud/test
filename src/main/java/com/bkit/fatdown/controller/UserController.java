package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.RestResult;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.service.IUserBasicInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @FileName: UserController
 * @Author: YuJian
 * @Description: 用户相关功能控制器
 * @Date: Created in 2019/7/9 17:24
 * @Modified:
 * @Version: 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserBasicInfoService userBasicInfoService;

    @CrossOrigin
    @RequestMapping(value = "/login/{openid}", method = RequestMethod.GET)
    public RestResult loginUser(@PathVariable String openid, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json;charset=UTF-8");

        String callback = request.getParameter("callback");
        System.out.println(openid);

        if (userBasicInfoService.checkUser(openid)) {
            return new RestResult(200, "true");
        } else {
            return new RestResult(400, "false");
        }
    }

}
