package com.al_tair.storage.mapper;

import com.al_tair.storage.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Al_tair
 * @date 2022/7/18-13:23
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 插入用户数据
     * @param user 用户信息
     */
    void insertUser(User user);

    /**
     * 查询用户
     * @return 用户列表
     */
    List<User> selectUser();
}
