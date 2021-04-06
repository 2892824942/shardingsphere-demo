package com.example.sharding.service;

import com.example.sharding.dao.BillItemMapper;
import com.example.sharding.dao.BillMapper;
import com.example.sharding.entry.BillDTO;
import com.example.sharding.entry.BillItemModel;
import com.example.sharding.entry.BillModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BillService {

    @Autowired
    private BillMapper billMapper;
    @Autowired
    private BillItemMapper billItemMapper;


    public int insertSelective(BillModel record) {
        return billMapper.insertSelective(record);
    }

    public int deleteByPrimaryKey(Long id) {
        return billMapper.deleteByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(BillModel record) {
        return billMapper.updateByPrimaryKeySelective(record);
    }

    public BillModel selectByPrimaryKey(Long id) {
        return billMapper.selectByPrimaryKey(id);
    }

    public int updateBatchSelective(List<BillModel> list) {
        return billMapper.updateBatchSelective(list);
    }

    public int batchInsert(List<BillModel> list) {
        return billMapper.batchInsert(list);
    }

    public PageInfo<BillModel> selectPage(BillModel billModel, Integer pageNum, Integer pageSize) {
        Long size = billMapper.countBySelective(billModel);
        List<BillModel> billModels = billMapper.selectPage(billModel, (pageNum - 1) * pageNum, pageSize);
        PageInfo<BillModel> pageInfo = new PageInfo<>(billModels);
        pageInfo.setTotal(size);
        return pageInfo;
    }

    public PageInfo<BillModel> selectPageByPageHelper(BillModel billModel, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> billMapper.selectPageByPageHelper(billModel));
    }

    public Map<String,Object> selectOfSumFunction() {
        return billMapper.selectOfSumFunction();
    }

    public Map<String, Object> selectOfGroupBy() {
        return billMapper.selectOfGroupBy();
    }

    public List<BillModel> selectOfUnionAll() {
        return billMapper.selectOfUnionAll();
    }

    public List<Map<String, Object>> selectOfJoin() {
        return billMapper.selectOfJoin();

    }

    public int updateSubDbAndTbColumn(Long sourceId, Long changeId) {
        return billMapper.updateSubDbAndTbColumn(sourceId,changeId);
    }

    public int insertOnDuplicateKeyUpdate(BillModel record) {
        return billMapper.insertOrUpdateSelective(record);
    }
    @Transactional
    public int transactionTest(BillModel billModel, BillItemModel itemModel) {
        billMapper.insert(billModel);
        itemModel.setBillId(billModel.getId());
        billItemMapper.insertSelective(itemModel);

        return 1;
    }

    public BillDTO getIncludeKeyword(Long id) {
        return billMapper.getIncludeKeyword(id);
    }
}



