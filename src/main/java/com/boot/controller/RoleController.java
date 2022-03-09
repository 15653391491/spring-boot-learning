package com.boot.controller;

import com.boot.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(description = "角色")
@RestController
@RequestMapping("/role")
public class RoleController {

    @ApiOperation("获取角色")
    @GetMapping("/getRoles")
    public Result<Object> getRole(HttpServletRequest req) {
        Result<Object> result = new Result<>();
        result.setCode(1);
        result.setMessage("success");
        return result;
    }
}
