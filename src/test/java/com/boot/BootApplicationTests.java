package com.boot;

import com.boot.Mapper.UserMapper;
import com.boot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class BootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("username", "15653391491");
        params.put("password", "lucty772");
        try {
            userMapper.addUser(params);
        }catch (DuplicateKeyException e){
            e.printStackTrace();
            System.out.println("用户已存在");
        }
    }

}
