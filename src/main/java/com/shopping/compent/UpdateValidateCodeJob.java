package com.shopping.compent;

import com.shopping.mapper.UserValidateMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UpdateValidateCodeJob {

    @Resource
    private UserValidateMapper userValidateMapper;

    @Scheduled(cron = "*/1 * * * * ?")
    public void updateValidateCode()
    {
        userValidateMapper.updateStatusTask();
    }
}
