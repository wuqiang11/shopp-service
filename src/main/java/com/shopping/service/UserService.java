package com.shopping.service;

import com.shopping.constants.BaseRespConstants;
import com.shopping.constants.DictionaryConstants;
import com.shopping.constants.GlobalConstants;
import com.shopping.dto.GetLowerUserReqDto;
import com.shopping.dto.GetShareLinkReqDto;
import com.shopping.dto.GetUserInfoReqDto;
import com.shopping.dto.InviationRegReqDto;
import com.shopping.entity.*;
import com.shopping.exception.BussinessException;
import com.shopping.mapper.DictionaryMapper;
import com.shopping.mapper.TransactionRecordMapper;
import com.shopping.mapper.UserMapper;
import com.shopping.mapper.UserValidateMapper;
import com.shopping.vo.GetLowerUserRespDto;
import com.shopping.vo.GetShareLinkRespVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService extends BaseService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserValidateMapper userValidateMapper;

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Resource
    private TransactionRecordMapper transactionRecordMapper;

    /**
     * 用户邀请接口
     *
     * @param reqDto
     * @return
     */
    @Transactional
    public Tip inviateUserReg(InviationRegReqDto reqDto) {
        // 判断邀请用户是否存在
        UserBean userBean = userMapper.selectUserById(reqDto.getInviateUserId());
        if (null == userBean) {
            return new ErrorTip(BaseRespConstants.INVIATE_USER_NULL.getCode(), BaseRespConstants.INVIATE_USER_NULL.getMsg());
        }
        // 判断当前验证码是否存在是否已经失效
        UserValidateCodeBean userValidateCodeBean = userValidateMapper.selectUserValidate(reqDto.getPhone(), reqDto.getCode());
        if (null == userValidateCodeBean) {
            return new ErrorTip(BaseRespConstants.VALIDATE_CODE_NULL.getCode(), BaseRespConstants.VALIDATE_CODE_NULL.getMsg()
            );
        }
        int updateResult = userValidateMapper.updateUserValidateStatus(reqDto.getPhone(), reqDto.getCode());
        if (updateResult <= 0) {
            throw new BussinessException("验证码已经失效");
        }
        // 新增用户
        UserBean insertUser = new UserBean();
        insertUser.setSuperiorUserId(reqDto.getInviateUserId());
        insertUser.setUserName(reqDto.getPhone());
        insertUser.setNickName(reqDto.getPhone());
        insertUser.setRealName(reqDto.getPhone());
        insertUser.setTelephone(reqDto.getPhone());
        insertUser.setPassword("123456");
        int inserResult = userMapper.insertUser(insertUser);
        if (inserResult <= 0) {
            throw new BussinessException("保存用户信息失败");
        }
        // 更新用户余额
        String dictValue = dictionaryMapper.selectDictValueByKey(DictionaryConstants.inviateRebateMoney);
        int addBalance = userMapper.addUserBalance(reqDto.getInviateUserId(), Double.valueOf(dictValue));
        if (addBalance <= 0) {
            throw new BussinessException("增加用户余额失败");
        }
        // 根据手机号查询用户信息
        UserBean user = userMapper.selectUserByTelephone(reqDto.getPhone());
        UserBean inviateUser = userMapper.selectUserById(reqDto.getInviateUserId());
        // 插入交易记录
        TransactionRecordBean transactionRecordBean = new TransactionRecordBean();
        transactionRecordBean.setUserId(reqDto.getInviateUserId());
        transactionRecordBean.setLowerUser(user.getId());
        transactionRecordBean.setTransactionType(GlobalConstants.transactionType_20);
        transactionRecordBean.setIncomeType(GlobalConstants.incomeType_10);
        transactionRecordBean.setTtransactionMoney(Double.valueOf(dictValue));
        transactionRecordBean.setTransactionBalance(inviateUser.getUserBalance());
        transactionRecordBean.setPayStatus(GlobalConstants.payStatus_20);
        int transResult = transactionRecordMapper.inserTransactionRecord(transactionRecordBean);
        if (transResult <= 0) {
            throw new BussinessException("插入交易记录失败");
        }
        return new SuccessTip();
    }

    /**
     * 获取分享链接
     *
     * @param reqDto
     * @return
     */
    public Tip getShareLink(GetShareLinkReqDto reqDto) {

        UserBean userBean = userMapper.selectUserById(reqDto.getUserId());
        if (null == userBean) {
            return new ErrorTip(BaseRespConstants.INVIATE_USER_NULL.getCode(), BaseRespConstants.INVIATE_USER_NULL.getMsg());
        }

        String shareUrl = dictionaryMapper.selectDictValueByKey(DictionaryConstants.shareLinkUrl);

        String shareRule = dictionaryMapper.selectDictValueByKey(DictionaryConstants.getShareLinkRule);

        GetShareLinkRespVo respVo = new GetShareLinkRespVo();
        respVo.setAvatar(userBean.getAvatar());
        respVo.setUserId(reqDto.getUserId());
        respVo.setShareLinkUrl(shareUrl);
        respVo.setShareLinkRule(shareRule);

        return new SuccessTip(BaseRespConstants.NEW_SUCCESS.getMsg(), respVo);
    }

    public Tip getLowerUser(GetLowerUserReqDto reqDto) {
        Long startIndex = (reqDto.getPageNumber() - 1) * reqDto.getPageSize();
        Long endIndex = reqDto.getPageSize();
        List<GetLowerUserRespDto> list = userMapper.getLowerUserList(reqDto.getUserId(), startIndex, endIndex);
        return new SuccessTip(BaseRespConstants.NEW_SUCCESS.getMsg(), list);
    }


    public Tip getUserInfo(GetUserInfoReqDto reqDto)
    {
        UserBean userBean = userMapper.selectUserById(reqDto.getUserId());
        return new SuccessTip(BaseRespConstants.NEW_SUCCESS.getMsg(),userBean);
    }
}
