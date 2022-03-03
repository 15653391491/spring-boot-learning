package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/getAccounts")
    public HashMap<String, Object> getAccounts() {
        String sql = "select * from tb_account";
        List<Map<String, Object>> accounts = jdbcTemplate.queryForList(sql);
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 1);
        result.put("data", accounts);
        result.put("message", "success");
        return result;
    }
}
