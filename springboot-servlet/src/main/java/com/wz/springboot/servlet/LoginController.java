package com.wz.springboot.servlet;



import com.wz.springboot.config.JWTUtil;
import com.wz.springboot.domain.Response;
import com.wz.springboot.domain.SystemProperties;
import com.wz.springboot.domain.User;
import com.wz.springboot.exception.SystemException;
import com.wz.springboot.util.MD5Util;
import com.wz.springboot.util.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MrBird
 */
@RestController
@Validated
public class LoginController {


    @PostMapping("/login")
    public Response login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password, HttpServletRequest request) throws Exception {
        username = StringUtils.lowerCase(username);
        password = MD5Util.encrypt(username, password);

        final String errorMessage = "用户名或密码错误";
        User user = SystemUtils.getUser(username);

        if (user == null)
            throw new SystemException(errorMessage);
        if (!StringUtils.equals(user.getPassword(), password))
            throw new SystemException(errorMessage);

        // 生成 Token
        String token = JWTUtil.sign(username, password);

        Map<String, Object> userInfo = this.generateUserInfo(token, user);
        return new Response().message("认证成功").data(userInfo);
    }

    /**
     * 生成前端需要的用户信息，包括：
     * 1. token
     * 2. user
     *
     * @param token token
     * @param user  用户信息
     * @return UserInfo
     */
    private Map<String, Object> generateUserInfo(String token, User user) {
        String username = user.getUsername();
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("token", token);

        user.setPassword("it's a secret");
        userInfo.put("user", user);
        return userInfo;
    }
}
