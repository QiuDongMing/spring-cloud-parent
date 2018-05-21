package com.qdm.test.mongo;

import com.alibaba.fastjson.JSON;
import com.qdm.model.po.Table1;
import com.qdm.model.po.Table2;
import com.qdm.test.BaseTest;
import org.junit.Test;
import org.mongodb.morphia.AdvancedDatastore;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author qiudm
 * @date 2018/4/26 15:59
 * @desc
 */
public class TableQueryTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Resource(name = "dsForRw")
    private AdvancedDatastore dsForRw;

    @Test
    public void insertTest() {
        for (int i = 0; i < 30; i++) {
            int random = new Random().nextInt(4) + 1;
            try {
                Thread.sleep(random * 1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (random % 2 == 0) {
                 Table1 table1 = new Table1();
                 table1.setName("1tab:" + i);
                 table1.setCreateTime(System.currentTimeMillis());
                 dsForRw.insert(table1);
            } else {
                Table2 table2 = new Table2();
                table2.setName("2tab:" + i);
                table2.setCreateTime(System.currentTimeMillis());
                dsForRw.insert(table2);
            }
        }
    }


    @Test
    public void queryTest() {

        Integer pageSize = 3;
        Integer pageIndex = 0;

        List<Table1> table1List1 = queryTab1(pageIndex, pageSize);
        List<Table2> table2List2 = queryTab2(pageIndex, pageSize);

        logger.error("table1List1:{}", JSON.toJSONString(table1List1));
        logger.error("table2List2:{}", JSON.toJSONString(table2List2));


    }


























    private List<Table1> queryTab1(Integer pageIndex, Integer pageSize) {
        Query<Table1> query = dsForRw.createQuery(Table1.class);
        query.offset(pageIndex * pageSize).limit(pageSize);
        query.order("createTime");
        return query.asList();
    }


    private List<Table2> queryTab2(Integer pageIndex, Integer pageSize) {
        Query<Table2> query = dsForRw.createQuery(Table2.class);
        query.order("createTime");
        query.offset(pageIndex * pageSize).limit(pageSize);
        return query.asList();
    }









}
