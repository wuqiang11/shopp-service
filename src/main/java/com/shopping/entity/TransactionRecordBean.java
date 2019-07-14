package com.shopping.entity;

import java.io.Serializable;

public class TransactionRecordBean implements Serializable {

    private Long id;

    private Long userId;

    private Long productId;

    private Long lowerUser;

    private Long transactionType;

    private Long payType;

    private Long incomeType;

    private Double ttransactionMoney;

    private String transactionTime;

    private Double transactionBalance;

    private Long payStatus;

    private String thirdTransactionRecord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getLowerUser() {
        return lowerUser;
    }

    public void setLowerUser(Long lowerUser) {
        this.lowerUser = lowerUser;
    }

    public Long getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Long transactionType) {
        this.transactionType = transactionType;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public Long getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(Long incomeType) {
        this.incomeType = incomeType;
    }

    public Double getTtransactionMoney() {
        return ttransactionMoney;
    }

    public void setTtransactionMoney(Double ttransactionMoney) {
        this.ttransactionMoney = ttransactionMoney;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Double getTransactionBalance() {
        return transactionBalance;
    }

    public void setTransactionBalance(Double transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    public Long getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Long payStatus) {
        this.payStatus = payStatus;
    }

    public String getThirdTransactionRecord() {
        return thirdTransactionRecord;
    }

    public void setThirdTransactionRecord(String thirdTransactionRecord) {
        this.thirdTransactionRecord = thirdTransactionRecord;
    }

    @Override
    public String toString() {
        return "TransactionRecordBean{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", lowerUser=" + lowerUser +
                ", transactionType=" + transactionType +
                ", payType=" + payType +
                ", incomeType=" + incomeType +
                ", ttransactionMoney=" + ttransactionMoney +
                ", transactionTime='" + transactionTime + '\'' +
                ", transactionBalance=" + transactionBalance +
                ", payStatus=" + payStatus +
                ", thirdTransactionRecord='" + thirdTransactionRecord + '\'' +
                '}';
    }
}
