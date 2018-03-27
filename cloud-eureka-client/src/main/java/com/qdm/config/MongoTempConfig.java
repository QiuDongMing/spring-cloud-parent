package com.qdm.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @author qiudm
 * @date 2018/3/27 9:20
 * @desc 关于mongoTemple的初始化
 */
@Configuration
public class MongoTempConfig {


    @Value("${spring.datasource.mongo.url}")
    private String mongoUri;

    @Value("${spring.datasource.mongo.database}")
    private String dbName;

    @Bean(name="mongoTemplate")
    public MongoTemplate diseaseMongoTemplate() throws Exception {
        MappingMongoConverter converter = new MappingMongoConverter(
                new DefaultDbRefResolver(mongodbFactory()),
                new MongoMappingContext());

        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return new MongoTemplate(mongodbFactory(), converter);
    }

    @Bean
    public MongoDbFactory mongodbFactory() throws Exception {
        MongoClientURI mongoClientUri = new MongoClientURI(mongoUri);
        return new SimpleMongoDbFactory(new MongoClient(mongoClientUri), dbName);
    }


}
