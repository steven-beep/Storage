package com.al_tair.storage.controller;

import com.al_tair.storage.common.RestResult;
import com.al_tair.storage.dto.LoginVO;
import com.al_tair.storage.dto.RegisterDTO;
import com.al_tair.storage.model.User;
import com.al_tair.storage.service.UserService;
import com.al_tair.storage.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Al_tair
 * @date 2022/7/18-14:18
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private JwtUtil jwtUtil;

    /**
     * 注册模块
     * @param registerDTO 传入参数模型
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public RestResult<String> register(@RequestBody RegisterDTO registerDTO) {
        RestResult<String> restResult = null;
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setTelephone(registerDTO.getTelephone());
        user.setPassword(registerDTO.getPassword());

        restResult = userService.registerUser(user);
        return restResult;
    }

    @GetMapping(value = "/login")
    @ResponseBody
    public RestResult<LoginVO> userLogin(String telephone, String password) {
        RestResult<LoginVO> restResult = new RestResult<LoginVO>();
        LoginVO loginVO = new LoginVO();
        User user = new User();
        user.setTelephone(telephone);
        user.setPassword(password);
        RestResult<User> loginResult = userService.login(user);

        if (!loginResult.getSuccess()) {
            return RestResult.fail().message("登录失败！");
        }

        loginVO.setUsername(loginResult.getData().getUsername());
        String jwt = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jwt = jwtUtil.createJWT(objectMapper.writeValueAsString(loginResult.getData()));
        } catch (Exception e) {
            return RestResult.fail().message("登录失败！");
        }
        loginVO.setToken(jwt);
        return RestResult.success().data(loginVO);
    }

    @GetMapping("/checkuserlogininfo")
    @ResponseBody
    public RestResult<User> checkToken(String token) { // @RequestHeader("token")
        RestResult<User> restResult = new RestResult<User>();
        User tokenUserInfo = null;
        try {
            Claims c = jwtUtil.parseJWT(token);
            String subject = c.getSubject();
            ObjectMapper objectMapper = new ObjectMapper();
            tokenUserInfo = objectMapper.readValue(subject, User.class);

        } catch (Exception e) {
            log.error("解码异常");
            return RestResult.fail().message("认证失败");
        }

        if (tokenUserInfo != null) {
            return RestResult.success().data(tokenUserInfo);
        } else {
            return RestResult.fail().message("用户暂未登录");
        }
    }

    /**
     * 成功响应测试
     */
    @GetMapping(value="/test1")
    @ResponseBody
    public RestResult test1(){
        return RestResult.success();
    }

    /**
     * 失败响应测试
     */
    @GetMapping(value="/test2")
    @ResponseBody
    public RestResult test2(){
        return RestResult.fail();
    }

    /**
     * 空指针异常响应测试
     */
    @GetMapping(value="/test3")
    @ResponseBody
    public RestResult test3(){
        String s = null;
        int i = s.length();
        return RestResult.success();
    }

    /**
     * 空指针异常响应测试
     */
    @GetMapping(value="/test4")
    @ResponseBody
    public RestResult test4(){
        int[] num = new int[2];
        num[2] = 2;
        return RestResult.success();
    }
}
