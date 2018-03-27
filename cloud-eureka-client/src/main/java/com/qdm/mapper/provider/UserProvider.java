package com.qdm.mapper.provider;

import com.qdm.model.po.User;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import java.util.Objects;



/**
 * @author qiudm
 * @date 2018/3/22 19:29
 * @desc
 */
public class UserProvider {

    public String updateUser(User user) {
        SQL sql = new SQL();
        sql.UPDATE("user");

        if(StringUtils.isNotBlank(user.getUsername())) {
            sql.SET(" username=#{username, jdbcType=VARCHAR}");
        }

        if(Objects.nonNull(user.getBirthday())) {
            sql.SET(" username=#{username, jdbcType=DATE}");
        }
        sql.WHERE("userId=#{userId, jdbcType=INTEGER}");

        return sql.toString();
    }



}
