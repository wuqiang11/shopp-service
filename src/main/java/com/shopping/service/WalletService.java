package com.shopping.service;

import com.shopping.constants.BaseRespConstants;
import com.shopping.dto.UserWalletReqDto;
import com.shopping.entity.SuccessTip;
import com.shopping.entity.Tip;
import com.shopping.entity.TransactionRecordBean;
import com.shopping.mapper.TransactionRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WalletService {

    @Resource
    private TransactionRecordMapper transactionRecordMapper;

    public Tip getUserWalletDetail(UserWalletReqDto reqDto) {
        List<TransactionRecordBean> list = transactionRecordMapper.selectTransactionRecordList(reqDto.getUserId());
        return new SuccessTip(BaseRespConstants.NEW_SUCCESS.getMsg(),list);
    }
}
