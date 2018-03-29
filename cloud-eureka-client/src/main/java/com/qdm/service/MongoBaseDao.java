package com.qdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author qiudm
 * @date 2018/3/26 19:27
 * @desc
 */
@Component
public class MongoBaseDao {

    @Autowired
    protected MongoTemplate mongoTemplate;


    //分支修改文件

}
