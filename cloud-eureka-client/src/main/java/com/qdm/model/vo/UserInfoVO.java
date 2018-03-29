package com.qdm.model.vo;


/**
 * @author qiudm
 * @date 2018/3/22 18:04
 * @desc
 */
public class UserInfoVO {

    private Integer userId;

    private String username;

    private long birthday;

    private long createTime;

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
}
