package com.boot.Mapper;

import com.boot.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    List<Account> getAccounts(@Param("user") HashMap<String, Object> user);

    void addAccount(@Param("user") HashMap<String, Object> user);

    void delAccount(@Param("id") int id);

    void updateAccount(@Param("user") HashMap<String,Object> user);
}
