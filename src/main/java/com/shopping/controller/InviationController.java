package com.shopping.controller;

import com.shopping.dto.GetLowerUserReqDto;
import com.shopping.dto.GetShareLinkReqDto;
import com.shopping.dto.InviationRegReqDto;
import com.shopping.entity.Tip;
import com.shopping.service.UserService;
import com.shopping.util.OvalValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 邀请用户注册controller
 */
@RestController
public class InviationController {

    @Autowired
    private UserService userService;


    /**
     * 邀请好友接口
     *
     * @param reqDto
     * @return
     */
    @RequestMapping("/api/inviate/inviateUserReg")
    @ResponseBody
    public Tip inviateUserRegister(InviationRegReqDto reqDto) {
        OvalValidationUtils.validate(reqDto);
        return userService.inviateUserReg(reqDto);
    }

    /**
     * 获取分享链接
     *
     * @param reqDto
     * @return
     */
    @RequestMapping("/api/inviate/getShareLink")
    @ResponseBody
    public Tip getShareLink(GetShareLinkReqDto reqDto) {
        OvalValidationUtils.validate(reqDto);
        return userService.getShareLink(reqDto);
    }

    /**
     * 获取下级用户
     *
     * @param reqDto
     * @return
     */
    @RequestMapping("/api/inviate/getLowerUser")
    @ResponseBody
    public Tip getLowerUser(GetLowerUserReqDto reqDto) {
        OvalValidationUtils.validate(reqDto);
        return userService.getLowerUser(reqDto);
    }
}
