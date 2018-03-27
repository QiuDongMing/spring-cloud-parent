package com.qdm.mapper;

import com.qdm.controller.param.UserInfoListParam;
import com.qdm.mapper.provider.UserProvider;
import com.qdm.model.po.User;
import com.qdm.model.vo.UserInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/3/22 18:12
 * @desc
 */
@Mapper
public interface UserMapper {

    @Select(value = {"SELECT userId,username,birthday,createTime FROM t_user WHERE userId=#{userId}"})
    User queryByUserId(@Param("userId") int userId);

    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    void update(User user);

    @Select(value = {"SELECT userId,username,birthday,createTime FROM t_user"})
    List<UserInfoVO> queryUserInfoList(UserInfoListParam userInfoListParam);

    @Insert(value = {"INSERT INTO t_user(username,birthday,createTime) VALUES(#{username, jdbcType=VARCHAR}, #{birthday, jdbcType=INTEGER}, #{createTime, jdbcType=INTEGER})"})
    @Options(useGeneratedKeys=true, keyProperty="userId", keyColumn="userId")
    int insert(User user);

}
