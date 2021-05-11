package com.example.sharding.dao;

import com.example.sharding.entry.BillItemModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BillItemMapper {
    int insertSelective(BillItemModel record);

    BillItemModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BillItemModel record);

}