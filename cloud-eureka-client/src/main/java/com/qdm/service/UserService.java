package com.qdm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qdm.controller.param.UserInfoListParam;
import com.qdm.mapper.UserMapper;
import com.qdm.model.po.User;
import com.qdm.model.vo.PageVo;
import com.qdm.model.vo.UserInfoVO;
import com.qdm.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/3/22 18:32
 * @desc
 */
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public UserInfoVO queryUserInfo(int userId) {
        User user = userMapper.queryByUserId(userId);
        UserInfoVO userInfo = BeanUtil.copy(user, UserInfoVO.class);

        return userInfo;
    }

    @Transactional
    public UserInfoVO updateUser(User user) {
        userMapper.update(user);
        user = userMapper.queryByUserId(user.getUserId());
        UserInfoVO userInfo = BeanUtil.copy(user, UserInfoVO.class);

        return userInfo;
    }


    public PageVo<UserInfoVO> queryUserInfoList(UserInfoListParam userInfoListParam) {
        PageHelper.startPage(userInfoListParam.getPageNum(), userInfoListParam.getPageSize());
        List<UserInfoVO> data = userMapper.queryUserInfoList(userInfoListParam);

        Page<UserInfoVO> userInfoVOPage = Objects.isNull(data) ? new Page<UserInfoVO>() : (Page<UserInfoVO>) data;
        PageVo<UserInfoVO> userInfoVOPageVo = new PageVo<UserInfoVO>(userInfoListParam.getPageNum(), userInfoVOPage.getPageSize(), userInfoVOPage.getTotal());
        userInfoVOPageVo.setPageData(data);

        return userInfoVOPageVo;
    }

}
