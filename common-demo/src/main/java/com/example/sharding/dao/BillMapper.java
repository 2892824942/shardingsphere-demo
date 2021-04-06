package com.example.sharding.dao;

import com.example.sharding.entry.BillDTO;
import com.example.sharding.entry.BillModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BillModel record);

    int insertOrUpdate(BillModel record);

    int insertOrUpdateSelective(BillModel record);

    int insertSelective(BillModel record);

    BillModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BillModel record);

    int updateBatchSelective(List<BillModel> list);

    int batchInsert(@Param("list") List<BillModel> list);

    List<BillModel> selectPage(@Param("bill") BillModel bill, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<BillModel> selectPageByPageHelper(BillModel billModel);

    Long countBySelective(BillModel record);


    Map<String, Object> selectOfSumFunction();

    Map<String, Object> selectOfGroupBy();

    List<BillModel> selectOfUnionAll();

    List<Map<String, Object>> selectOfJoin();

    int updateSubDbAndTbColumn(@Param("sourceId") Long sourceId, @Param("changeId") Long changeId);

    BillDTO getIncludeKeyword(Long id);
}