package com.qdm.model.po;

import com.qdm.support.mongo.base.AbstractBaseInfo;
import org.mongodb.morphia.annotations.Entity;

/**
 * @author qiudm
 * @date 2018/4/26 16:01
 * @desc
 */
@Entity(value = "t_tab1", noClassnameStored = true)
public class Table1 extends AbstractBaseInfo {

    private String name = "tab1";

    private long createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
