package com.shopping.dto;

import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 * ClassName:  OrderListReqDto
 * Description:
 * date:  2019/7/15 0015  16:29
 *
 * @author wuqiang
 * @version 1.0
 */
public class OrderListReqDto implements Serializable {

    // 每页显示多少条
    @NotNull(errorCode = "1001",message = "每页显示多少条不能为空")
    @Min(value = 10,errorCode = "1001",message = "每页最少显示10条")
    private Long pageSize;

    // 页数
    @NotNull(errorCode = "1001",message = "页数不能为空")
    @Min(value = 1,errorCode = "1001",message = "页数从1起始")
    private Long pageNumber;

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "OrderListReqDto{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
