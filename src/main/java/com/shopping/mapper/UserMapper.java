package com.shopping.mapper;

import com.shopping.entity.UserBean;
import com.shopping.vo.GetLowerUserRespDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId
     * @return
     */
    public UserBean selectUserById(@Param("id") Long userId);

    /**
     * 新增用户
     *
     * @param userBean
     * @return
     */
    public int insertUser(UserBean userBean);


    public UserBean selectUserByTelephone(@Param("telephone") String telephone);

    /**
     * 添加用户余额
     *
     * @param userId
     * @param money
     * @return
     */
    public int addUserBalance(@Param("userId") Long userId, @Param("money") Double money);


    /**
     * 分页获取下级用户
     *
     * @param userId
     * @param startIndex
     * @param endIndex
     * @return
     */
    public List<GetLowerUserRespDto> getLowerUserList(@Param("userId") Long userId, @Param("startIndex") Long startIndex, @Param("endIndex") Long endIndex);
}
