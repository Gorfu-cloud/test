package com.bkit.fatdown.controller;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.common.api.CommonResult;
import com.bkit.fatdown.dto.RestResult;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.utils.WxappUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @file: UserController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户相关控制器
 * @date: Created in 7/10/19  8:53 AM
 * @modified:
 * @version: 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserBasicInfoService userBasicInfoService;

    @CrossOrigin
    @RequestMapping(value = "/login/{openid}", method = RequestMethod.GET)
    public RestResult loginUser(@PathVariable String openid) {
        System.out.println(openid);

        if (userBasicInfoService.countByOpenid(openid) > 0) {
            return new RestResult(200, "true");
        } else {
            return new RestResult(400, "false");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/register/{openid}", method = RequestMethod.GET)
    public RestResult registerUser(@PathVariable String openid) {

        return new RestResult();
    }

    @CrossOrigin
    @RequestMapping(value = "/getOpenid/{code}", method = RequestMethod.GET)
    public CommonResult getOpenid(@PathVariable String code) {
        if (code == null || code.length() == 0) {
            return CommonResult.failed("code错误");
        }

        JSONObject jsonObject = JSONObject.parseObject(WxappUtil.getSessionKeyOropenid(code));
        System.out.println(jsonObject.toJSONString());

        String openid = (String) jsonObject.get("openid");
        String sessionKey = jsonObject.get("session_key").toString();
        Map map = new HashMap(2);
        map.put("openid", openid);
        map.put("sessionKey", sessionKey);
        return CommonResult.success(map);
    }
}
