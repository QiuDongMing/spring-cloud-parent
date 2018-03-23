package com.qdm.controller;

import com.qdm.controller.param.UserInfoListParam;
import com.qdm.model.po.User;
import com.qdm.model.vo.PageVo;
import com.qdm.model.vo.UserInfoVO;
import com.qdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiudm
 * @date 2018/3/22 18:00
 * @desc
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userInfo/{userId}")
    public UserInfoVO userInfo(@PathVariable int userId) {
        UserInfoVO userInfo = userService.queryUserInfo(userId);
        return userInfo;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public UserInfoVO update(User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageVo<UserInfoVO> userInfoList(@RequestBody UserInfoListParam userInfoListParam) {
        return userService.queryUserInfoList(userInfoListParam);
    }

}
