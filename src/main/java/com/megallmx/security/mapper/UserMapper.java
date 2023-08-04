package com.megallmx.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.megallmx.security.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
