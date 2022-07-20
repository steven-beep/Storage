package com.al_tair.storage.controller;

import com.al_tair.storage.common.RestResult;
import com.al_tair.storage.vo.LoginVO;
import com.al_tair.storage.dto.RegisterDTO;
import com.al_tair.storage.model.User;
import com.al_tair.storage.service.UserService;
import com.al_tair.storage.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "user", description = "该接口为用户接口，主要做用户登录，注册和校验token")
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
    @Operation(summary = "用户注册", description = "注册账号", tags = {"user"})
    public RestResult<String> register(@RequestBody RegisterDTO registerDTO) {
        RestResult<String> restResult = null;
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setTelephone(registerDTO.getTelephone());
        user.setPassword(registerDTO.getPassword());

        restResult = userService.registerUser(user);
        return restResult;
    }

    /**
     * 登录模块
     * @param telephone 电话
     * @param password 密码
     * @return
     */
    @GetMapping(value = "/login")
    @ResponseBody
    @Operation(summary = "用户登录", description = "用户登录认证后才能进入系统", tags = {"user"})
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

    /**
     * 验证token
     * @param token
     * @return
     */
    @GetMapping("/checkuserlogininfo")
    @ResponseBody
    @Operation(summary = "检查用户登录信息", description = "验证token的有效性", tags = {"user"})
    public RestResult<User> checkToken(@RequestHeader("token") String token) {
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
}
