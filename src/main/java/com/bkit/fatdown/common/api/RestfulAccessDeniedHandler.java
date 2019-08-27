package com.bkit.fatdown.common.api;

import cn.hutool.json.JSONUtil;
import com.bkit.fatdown.dto.CommonResultDTO;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @file: RestfulAccessDeniedHandler
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:  当访问接口没有权限时，自定义的返回结果
 * @date: Created in 2019/8/27  10:13
 * @modified:
 * @version: 1.0
 */

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResultDTO.forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}