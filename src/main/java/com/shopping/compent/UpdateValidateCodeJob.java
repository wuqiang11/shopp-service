package com.shopping.compent;

import com.shopping.mapper.UserValidateMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 
 * @author: wuqiang
 * @date: 2019/7/15 0015 15:36
 * @param:
 * @return:
 */
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
