package com.al_tair.storage.service;

import com.al_tair.storage.common.RestResult;
import com.al_tair.storage.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Al_tair
 * @date 2022/7/18-15:26
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     * @param user 用户信息
     * @return
     */
     RestResult<String> registerUser(User user);

    /**
     * 登录用户名
     * @param user 用户信息
     * @return
     */
      RestResult<User> login(User user);

    /**
     * 通过 token 获取到用户信息
     * @param token 验证用户登录
     * @return
     */
      User getUserByToken(String token);
}
