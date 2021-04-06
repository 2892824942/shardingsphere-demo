package com.example.sharding.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.sharding.entry.BillItemModel;
import com.example.sharding.dao.BillItemMapper;
@Service
public class BillItemService{

    @Resource
    private BillItemMapper billItemMapper;

    
    public int insertSelective(BillItemModel record) {
        return billItemMapper.insertSelective(record);
    }

    
    public BillItemModel selectByPrimaryKey(Long id) {
        return billItemMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(BillItemModel record) {
        return billItemMapper.updateByPrimaryKeySelective(record);
    }

}
