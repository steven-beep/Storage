package com.al_tair.storage;

import com.al_tair.storage.mapper.UserMapper;
import com.al_tair.storage.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StorageApplicationTests {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void testUserMybatis() {
        User user = new User();
        user.setUsername("用户名1");
        user.setPassword("密码1");
        user.setTelephone("手机号1");
        userMapper.insertUser(user);
        System.out.println("数据库字段查询结果显示");
        List<User> list = userMapper.selectUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testUserMybatis_plus() {
        User user = new User();
        user.setUsername("stev");
        user.setPassword("456");
        user.setTelephone("456");
        userMapper.insert(user);
        List<User> list = userMapper.selectList(null);
        System.out.println("数据库字段查询结果显示");
        list.forEach(System.out::println);
    }
}
