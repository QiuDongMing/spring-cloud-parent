package com.qdm.test.demo;

import com.alibaba.fastjson.JSON;
import com.qdm.utils.BeanUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qiudm
 * @date 2018/3/28 14:59
 * @desc
 */
public class BeanUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtilTest.class);

    @Test
    public void studentToStudentVO() {
        Student student = new Student(1001, "zhangsan", 100);
        StudentVo studentVo = BeanUtil.copy(student, StudentVo.class);
        logger.error("studentVo={}", JSON.toJSONString(studentVo));
    }

    @Test
    public void studentToStudentMoreVo() {
        Student student = new Student(1001, "zhangsan", 100);
        StudentMoreVo studentMoreVo = BeanUtil.copy(student, StudentMoreVo.class);
        logger.error("studentMoreVo={}", JSON.toJSONString(studentMoreVo));
    }



}
