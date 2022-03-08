package com.boot.controller;

import com.boot.Mapper.AccountMapper;
import com.boot.pojo.Account;
import com.boot.tool.Pagenatior;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

@Api(description = "账号管理")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountMapper accountMapper;

    @ApiOperation("获取账号列表")
    @GetMapping("/getAccounts")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "Integer", defaultValue = "1", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "Integer", defaultValue = "10", paramType = "query"),
            @ApiImplicitParam(name = "account", value = "账号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "platform", value = "平台", dataType = "String", paramType = "query")
    })
    public HashMap<String, Object> getAccounts(HttpServletRequest req) {
//        --- 接收 ---
        int page = Integer.parseInt(req.getParameter("page"));
        int limit = Integer.parseInt(req.getParameter("limit"));
        HashMap<String, Object> params = new HashMap<>();
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            params.put(name, req.getParameter(name));
        }
//        --- 处理 ---
        List<Account> accounts = accountMapper.getAccounts(params);
        HashMap<String, Object> con = new HashMap<>();
        Pagenatior pagenatior = new Pagenatior(Collections.singletonList(accounts), limit);
        List<Object> ret = pagenatior.page(page);
        con.put("data", ret);
        con.put("count", accounts.size());
        con.put("page", page);
        con.put("limit", limit);
//        --- 返回 ---
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 1);
        result.put("data", con);
        result.put("message", "success");
        return result;
    }

    @ApiOperation("增加账号")
    @PostMapping("/addAccounts")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "password1", value = "密码1", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "password2", value = "密码2", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "platform", value = "平台", dataType = "String", paramType = "form"),
    })
    public HashMap<String, Object> addAccounts(HttpServletRequest req) {
//        --- 接收 ---
        HashMap<String, Object> params = new HashMap<>();
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            params.put(name, req.getParameter(name));
        }
//        --- 验证 ---
        if (!params.containsKey("account")) {
            HashMap<String, Object> errResult = new HashMap<>();
            errResult.put("code", 0);
            errResult.put("message", "请输入账号");
            return errResult;
        }
//        --- 处理 ---
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now = simpleDateFormat.format(date);
        params.put("createTime", now);
        accountMapper.addAccount(params);
//        --- 返回 ---
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 1);
        result.put("message", "success");
        return result;
    }

    @ApiOperation("删除账号")
    @PostMapping("/delAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "账号id", dataType = "Interger", paramType = "form")
    })
    public HashMap<String, Object> delAccount(int id) {
//        --- 处理 ---
        accountMapper.delAccount(id);
//        --- 返回 ---
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 1);
        result.put("message", "success");
        return result;
    }

    @ApiOperation("修改账号")
    @PostMapping("/updateAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "账号id", dataType = "Interger", paramType = "form"),
            @ApiImplicitParam(name = "password1", value = "密码1", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "password2", value = "密码2", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "platform", value = "平台", dataType = "String", paramType = "form")
    })
    public HashMap<String, Object> updateAccount(HttpServletRequest req) {
//        --- 接收 ---
        HashMap<String, Object> params = new HashMap<>();
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            params.put(name, req.getParameter(name));
        }
//        --- 验证 ---
        if (!params.containsKey("id")) {
            HashMap<String, Object> errResult = new HashMap<>();
            errResult.put("code", 0);
            errResult.put("message", "请输入修改账号的id");
            return errResult;
        }
//        --- 处理 ---
        accountMapper.updateAccount(params);
//        --- 返回 ---
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 1);
        result.put("message", "success");
        return result;
    }
}
