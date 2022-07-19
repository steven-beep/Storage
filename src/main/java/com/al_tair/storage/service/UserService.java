package com.al_tair.storage.service;

import com.al_tair.storage.common.RestResult;
import com.al_tair.storage.model.User;

/**
 * @author Al_tair
 * @date 2022/7/18-15:26
 */
public interface UserService {
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
}
