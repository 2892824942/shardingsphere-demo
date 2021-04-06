package com.example.sharding.entry;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class BillItemModel {
    /**
    * 主键
    */
    private Long id;

    /**
    * 关联账单id
    */
    private Long billId;

    /**
    * 子账单名称
    */
    private String billItemName;

    /**
    * 账单金额
    */
    private Integer billItemAmount;

    /**
    * 创建时间
    */
    @JsonFormat(pattern="YYYY-MM-dd HH:mm")
    @DateTimeFormat(pattern="YYYY-MM-dd HH:mm")
    private Date createTime;

    /**
    * 是否删除 0:未删除 1:已删除
    */
    private Integer isDelete;
}