package com.megallmx.security.service;

import com.megallmx.security.common.ResponseResult;
import com.megallmx.security.entity.User;

public interface LoginServcie {

    /**
     * 登录
     * @param user
     * @return
     */
    ResponseResult login(User user);

    /**
     * 登出
     * @return
     */
    ResponseResult logout();
}
