package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class BootApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        Object pc = Person.class;
        Connection connection = dataSource.getConnection();
        Person person = new Person();
        int i = 1;
        System.out.println(Person.class);
        connection.close();
    }

}
