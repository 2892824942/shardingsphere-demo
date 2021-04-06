package com.example.sharding.controller;

import com.example.sharding.entry.BillDTO;
import com.example.sharding.entry.BillItemModel;
import com.example.sharding.entry.BillModel;
import com.example.sharding.service.BillService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * auth:suyouliang
 */
@RestController
@RequestMapping("sharding/")
@Validated
public class TestController {
    @Autowired
    private BillService billService;

    //----------------------基础测试----------------------//

    @PostMapping("insertSelective")
    public int insertSelective(BillModel record) {
        return billService.insertSelective(record);
    }

    @PostMapping("batchInsert")
    public int batchInsert(@RequestBody List<BillModel> list) {
        return billService.batchInsert(list);
    }

    /**
     * 使用sharding分库分表时如果更新了分库分表字段：
     * Can not update sharding key, logic table: [bill],
     *
     * @param record
     * @return
     */
    @PostMapping("updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(BillModel record) {
        return billService.updateByPrimaryKeySelective(record);
    }

    /**
     * 批量更新测试
     * <p>
     * 分库分表时不支持，底层使用了case when
     * 4.x.x不支持case when语法
     *
     * @param
     * @return
     */
    @PostMapping("updateBatchSelective")
    public int updateBatchSelective(@RequestBody List<BillModel> list) {
        return billService.updateBatchSelective(list);
    }

    /**
     * 删除测试
     *
     * @param id
     * @return
     */
    @PostMapping("deleteByPrimaryKey")
    public int deleteByPrimaryKey(Long id) {
        return billService.deleteByPrimaryKey(id);
    }

    /**
     * 查询测试
     *
     * @param id
     * @return
     */
    @GetMapping("selectByPrimaryKey")
    public BillModel selectByPrimaryKey(Long id) {
        return billService.selectByPrimaryKey(id);
    }

    /**
     * 手动分页测试
     *
     * @param billModel
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("selectPage")
    public PageInfo<BillModel> selectPage(BillModel billModel, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "2") Integer pageSize) {
        return billService.selectPage(billModel, pageNum, pageSize);
    }

    /**
     * pageHelper分页测试
     *
     * @param billModel
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("selectPageByPageHelper")
    public PageInfo<BillModel> selectPageByPageHelper(BillModel billModel, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "2") Integer pageSize) {
        return billService.selectPageByPageHelper(billModel, pageNum, pageSize);
    }

    /**
     * 聚合函数及去重
     * 不可以同时使用普通聚合函数和DISTINCT聚合函数
     * 如：SELECT SUM(DISTINCT col1), SUM(col1) FROM tbl_name
     * 语句去除distinct可以成功
     *
     * @return
     */
    @GetMapping("selectOfSumFunction")
    public Map<String, Object> selectOfSumFunction() {
        return billService.selectOfSumFunction();
    }


    /**
     * 聚合排序
     * <p>
     * 不支持having，去除having可正常执行
     *
     * @return
     */
    @GetMapping("selectOfGroupBy")
    public Map<String, Object> selectOfGroupBy() {
        return billService.selectOfGroupBy();
    }

    /**
     * UNION ALL
     * <p>
     * 分库分表时不支持UNION（ALL）
     *
     * @return
     */
    @GetMapping("selectOfUnionAll")
    public List<BillModel> selectOfUnionAll() {
        return billService.selectOfUnionAll();
    }

    /**
     * 跨库关联 join
     *
     * @return
     */
    @GetMapping("selectOfJoin")
    public List<Map<String, Object>> selectOfJoin() {
        return billService.selectOfJoin();
    }

    /**
     * insert on duplicate key update
     * 4.1.1版本有bug，报参数错误: No value specified for parameter 5
     * Actual SQL: master :::
     * <p>
     * insert into bill ( id,bill_name,bill_amount,create_time )
     * values
     * (?, ?, ?, ?)
     * on duplicate key update
     * id = ?, bill_name = ?, bill_amount = ?,create_time = ?
     * <p>
     * ::: [20, bill-insert-on-duplicate-key-6, 10000, 2020-12-27 13:13:00.0]
     * <p>
     * 解析后的sql
     * insert into bill ( id,bill_name,bill_amount,create_time )
     * values
     * ( ?, ?,?,? )
     * on duplicate key update
     * id = ?,bill_name = ?,bill_amount = ?,create_time = ?
     * <p>
     * <p>
     * 分表后：不可修改分库分表逻辑字段
     * <p>
     * 分库分表后（对应sharding-sub-db-tb）：join对应的表（bill_item）没有做分库，由于[db0,db1]<->[bill_0,bill_1]有四种组合情况
     * ，而对应的bill_item会插到db0，还是db1是不固定的（随机的还是有算法暂不知道）
     * 导致如果bill进入了db0，很有可能bill_item进入db1，就会导致join的结果为空，但是不会报错
     * 但是分库分表的表A，join一个没有库分表的表B，是存在这种情况的，比如B为字典表，数据量固定，增量不大。
     * <p>
     * 这种情况下，可以让B在多个db中主从同步，从而方便A在各个DB join查询。
     *
     * @return
     */
    @PostMapping("insertOnDuplicateKeyUpdate")
    public int insertOnDuplicateKeyUpdate(BillModel record) {
        return billService.insertOnDuplicateKeyUpdate(record);
    }
    //----------------------基础测试----------------------//


    //----------------------其他测试----------------------//

    /**
     * 更新分库分表字段
     * <p>
     * 使用sharding分库分表时：Can not update sharding key, logic table: [bill],
     *
     * @return
     */
    @PostMapping("updateSubDbAndTbColumn")
    public int updateSubDbAndTbColumn(Long sourceId, Long changeId) {
        return billService.updateSubDbAndTbColumn(sourceId, changeId);
    }


    /**
     * 基础事务
     * 说明：直接在方法里制造异常是无法证明分布式事务的问题的，制造异常，本地代码直接报错，事务在本地不会提交
     * 真正测试应该是在代码运行过程正确，提交过程失败
     *
     * 让数据冲突（无法成功,mysql会拦住）：
     * 设置bill或者billItem的id=A 此时A在数据库不存在
     * debug到最后一行，让数据库预处理通过，此时更改某个数据的id为A，放开debug
     * 事实上，修改的表在执行完insert语句等待提交时，数据库会给表上表级锁，你根本无法修改数据，表也无法删除。
     *
     * 可以使用两个不同mysql实例的两个表，debug到最后一行，让数据库预处理通过，停到其中一个mysql service，验证错误（其他的方法自行探究）
     * 由于现有的环境，使用的billItem表与bill在同一个mysql实例，暂时不做此测试
     *
     *
     *
     * 分库情况下，不同的两个库的两个表：一个提交成功，一个提交失败，数据提交成功，此时将不满足事务原子性（A）：要么全部成功，要么全部失败
     *
     * //TODO 事务专题调研
     *
     * @return
     */
    @PostMapping("transaction")
    public int transactionTest(BillModel billModel, BillItemModel itemModel) {
        return billService.transactionTest(billModel, itemModel);
    }

    /**
     * 关键字
     * 使用sharding时：
     * 4.1.1版本有bug:no viable alternative at input 'text'
     *
     * @return
     */
    @GetMapping("keyword")
    public BillDTO transactionTest(Long id) {
        return billService.getIncludeKeyword(id);
    }

}
