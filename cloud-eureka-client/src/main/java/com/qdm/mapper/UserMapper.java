package com.qdm.mapper;

import com.qdm.controller.param.UserInfoListParam;
import com.qdm.mapper.provider.UserProvider;
import com.qdm.model.po.User;
import com.qdm.model.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/3/22 18:12
 * @desc
 */
@Mapper
public interface UserMapper {

    @Select(value = {"SELECT userId,username,birthday,createTime FROM user WHERE userId=#{userId}"})
    User queryByUserId(@Param("userId") int userId);

    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    void update(User user);

    @Select(value = {"SELECT userId,username,birthday,createTime FROM user"})
    List<UserInfoVO> queryUserInfoList(UserInfoListParam userInfoListParam);
}
