package com.wz.springboot.controller;

import com.wz.springboot.entity.AppUser;
import com.wz.springboot.util.MongoUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @ApiOperation(value = "mongo insert user")
    @PostMapping(value = "/insert")
    public Object insertUser(@RequestBody @Validated AppUser appUser) {
        return MongoUtil.insertObjInMongo(appUser, "user");
    }


}
