package com.shopping.controller;

import com.shopping.dto.GetUserInfoReqDto;
import com.shopping.entity.Tip;
import com.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     * @param reqDto
     * @return
     */
    @RequestMapping("/api/user/getUserInfo")
    @ResponseBody
    public Tip getUserInfo(@Valid GetUserInfoReqDto reqDto)
    {
        return userService.getUserInfo(reqDto);
    }
}
