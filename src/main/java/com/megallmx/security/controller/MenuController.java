package com.megallmx.security.controller;

import com.megallmx.security.common.ResponseResult;
import com.megallmx.security.mapper.MenuMapper;
import com.megallmx.security.service.impl.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/menu")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult getMenu(){
        LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> menuList = menuMapper.selectPermsByUserId(loginUser.getUser().getId());
        return new ResponseResult(200,"获取菜单成功", menuList);
    }
}
