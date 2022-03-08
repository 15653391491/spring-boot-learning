package com.boot;

import com.boot.Mapper.UserMapper;
import com.boot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class BootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        HashMap<String, Object> params = new HashMap<>();
        List<User> users = userMapper.getUsers(params);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
