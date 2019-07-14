package com.shopping.mapper;

import com.shopping.entity.UserValidateCodeBean;
import org.apache.ibatis.annotations.Param;

public interface UserValidateMapper {

    /**
     * 查询用户验证码
     * @param phone
     * @param validateCode
     * @return
     */
    public UserValidateCodeBean selectUserValidate(@Param("phone") String phone, @Param("validateCode") String validateCode);

    /**
     * 状态修改为已用状态
     * @param phone
     * @param validateCode
     * @return
     */
    public int updateUserValidateStatus(@Param("phone") String phone, @Param("validateCode") String validateCode);


    public int updateStatusTask();

}
