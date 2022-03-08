package com.boot.Mapper;

import com.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public void addUser(@Param("user") HashMap<String, Object> user);

    public void delUser(@Param("id") int id);

    List<User> getUsers(@Param("user") HashMap<String, Object> user);

    public void updateUser(@Param("user") HashMap<String, Object> user);

}
