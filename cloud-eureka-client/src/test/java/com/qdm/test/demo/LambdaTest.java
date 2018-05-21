package com.qdm.test.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author qiudm
 * @date 2018/5/18 10:29
 * @desc
 */
public class LambdaTest {

    private static final Logger logger = LoggerFactory.getLogger(LambdaTest.class);

    private List<Student> students = null;


    @Before
    public void initStudents() {
        students = new ArrayList<Student>() {
            {
                add(new Student(1001, "zhangsan1", 76));
                add(new Student(1002, "zhangsan2", 78));
                add(new Student(1003, "zhangsan3", 75));
                add(new Student(1004, "zhangsan4", 85));
                add(new Student(1005, "zhangsan5", 86));
                add(new Student(1006, "zhangsan6", 66));
                add(new Student(1007, "zhangsan7", 77));
            }
        };

    }


    @Test
    public void toMapTest() {
        Map<Integer, String> collect = students.stream().collect(Collectors.toMap(Student::getId, Student::getName, (o1, o2) -> o1));

        for (Map.Entry<Integer, String> m : collect.entrySet()) {
            logger.error("map:{}", JSON.toJSON(m));
        }

    }




}
