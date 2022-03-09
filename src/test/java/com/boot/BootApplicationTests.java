package com.boot;

import com.boot.Mapper.UserMapper;
import com.boot.Mapper.UserRoleMapper;
import com.boot.pojo.User;
import com.boot.pojo.UserRole;
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
        HashMap<String, Object> hashMap = new HashMap<>();
        List<User> users = userMapper.getUsers(hashMap);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
