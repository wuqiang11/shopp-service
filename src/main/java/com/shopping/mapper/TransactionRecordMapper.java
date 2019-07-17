package com.shopping.mapper;

import com.shopping.entity.TransactionRecordBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionRecordMapper {

    /**
     * 保存交易记录
     * @param transactionRecordBean
     * @return
     */
    public int inserTransactionRecord(TransactionRecordBean transactionRecordBean);

    /**
     * 查询交易记录
     * @param userId
     * @return
     */
    public List<TransactionRecordBean> selectTransactionRecordList(@Param("userId") Long userId);
}
