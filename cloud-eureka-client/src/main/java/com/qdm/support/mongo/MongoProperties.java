package com.qdm.support.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qiudm
 * @date 2018/3/26 11:20
 * @desc
 */
@Component
public class MongoProperties {

    @Value("${mongo.uri}")
    private String uri;

    @Value("${mongo.dbName}")
    private String dbName;

    public String getUri() {
        return uri == null ? "" : uri.trim();
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDbName() {
        return dbName == null ? "" : dbName.trim();
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
