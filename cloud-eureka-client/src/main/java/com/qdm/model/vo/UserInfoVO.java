package com.qdm.model.vo;

import java.util.Date;

/**
 * @author qiudm
 * @date 2018/3/22 18:04
 * @desc
 */
public class UserInfoVO {

    private Integer userId;

    private String username;

    private Date birthday;

    private Date createTime;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
