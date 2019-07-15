package com.shopping.dto;

import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

public class GetLowerUserReqDto implements Serializable {

    @NotNull(message = "用户ID不能为空", errorCode = "1001")
    private Long userId;

    @NotNull(message = "当前页数不能为空", errorCode = "1001")
    private Long pageNumber;

    @NotNull(message = "每页显示条数不能为空", errorCode = "1001")
    private Long pageSize;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "GetLowerUserReqDto{" +
                "userId=" + userId +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
