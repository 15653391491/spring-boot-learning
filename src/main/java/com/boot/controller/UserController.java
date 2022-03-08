package com.boot.controller;

import com.boot.Mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;

@Api(description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation("增加用户")
    @PostMapping("/addUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "mobile", value = "联系方式", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", paramType = "form")
    })
    public HashMap<String, Object> addUser(HttpServletRequest req) {
//        --- 接收 ---
        HashMap<String, Object> params = new HashMap<>();
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            params.put(name, req.getParameter(name));
        }
//        --- 处理 ---
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now = simpleDateFormat.format(date);
        params.put("createTime", now);
        try {
            userMapper.addUser(params);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            HashMap<String, Object> errResult = new HashMap<>();
            errResult.put("code", 0);
            errResult.put("message", "用户名已存在");
            return errResult;
        }
//        --- 返回 ---
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 1);
        result.put("message", "success");
        return result;
    }
}
