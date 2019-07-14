package com.shopping.mapper;

import com.shopping.entity.TransactionRecordBean;

public interface TransactionRecordMapper {

    /**
     * 保存交易记录
     * @param transactionRecordBean
     * @return
     */
    public int inserTransactionRecord(TransactionRecordBean transactionRecordBean);
}
