package com.qdm.model.po;

import com.qdm.support.mongo.base.AbstractBaseInfo;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/3/22 18:03
 * @desc
 */
@Entity(value = "t_user", noClassnameStored = true)
@Document(collection = "t_user")//spring mongo
public class User extends AbstractBaseInfo {

    private Integer userId;

    private String username;

    private String classId;

    private long birthday;

    private long createTime;

    private List<Integer> like;

    private String news;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public List<Integer> getLike() {
        return like;
    }

    public void setLike(List<Integer> like) {
        this.like = like;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
