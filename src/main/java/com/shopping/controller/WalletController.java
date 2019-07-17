package com.shopping.controller;

import com.shopping.dto.UserWalletReqDto;
import com.shopping.entity.Tip;
import com.shopping.service.WalletService;
import com.shopping.util.OvalValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WalletController  {

    @Resource
    private WalletService walletService;

    @RequestMapping("/api/wallet/walletDetail")
    public Tip getUserWalletDetail(UserWalletReqDto reqDto)
    {
        OvalValidationUtils.validate(reqDto);
        return  walletService.getUserWalletDetail(reqDto);
    }
}
