package com.qdm.model.vo;

import com.qdm.model.po.User;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * @author qiudm
 * @date 2018/4/19 18:11
 * @desc
 */
@Entity
public class UserResultVO {

    @Id
    private String username;

    private Long birthday;

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }
}
