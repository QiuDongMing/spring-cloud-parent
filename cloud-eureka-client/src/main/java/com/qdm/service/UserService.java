package com.qdm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qdm.controller.param.UserInfoListParam;
import com.qdm.mapper.UserMapper;
import com.qdm.model.po.User;
import com.qdm.model.vo.PageVo;
import com.qdm.model.vo.UserInfoVO;
import com.qdm.support.mongo.MongoDao;
import com.qdm.utils.BeanUtil;
import com.qdm.utils.redis.RedisLock;
import com.qdm.utils.redis.RedisParameterLocked;
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

    @Autowired
    private MongoDao mongoDao;

    public UserInfoVO queryUserInfo(int userId) {
        User user = mongoDao.getByPK(User.class, userId+"");
        //User user = userMapper.queryByUserId(userId);
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

    //限定20s内只能添加一个，非业务场景，仅测试
    @Transactional
    @RedisLock(key = "add_user", expireTime = 20, msg = "只能添加一次")
    public User addUser(User user, @RedisParameterLocked String name) {
        user.setCreateTime(System.currentTimeMillis());
        userMapper.insert(user);
        mongoDao.insertOrUpdate(user);
        return user;
    }

    //master add code

    //master add code2
    //branch_1 add

}
