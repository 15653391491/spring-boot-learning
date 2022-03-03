package com.boot.controller;

import com.boot.Mapper.AccountMapper;
import com.boot.pojo.Account;
import com.boot.tool.Pagenatior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountMapper accountMapper;

    @GetMapping("/getAccounts")
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
        Pagenatior pagenatior = new Pagenatior(Collections.singletonList(accounts),limit);
        List<Object> ret =  pagenatior.page(page);
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
}
