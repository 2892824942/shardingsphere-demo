package com.example.sharding.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class BillEncryptModel implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 账单名称
     */
    private String billName;

    /**
     * 账单金额
     */
    private Integer billAmount;

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