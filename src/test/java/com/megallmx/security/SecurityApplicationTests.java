package com.megallmx.security;

import com.megallmx.security.entity.User;
import com.megallmx.security.mapper.UserMapper;
import com.megallmx.security.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class SecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试MybatisPlus是否正常
     */
    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    /**
     * 自定义加密方式测试
     */
    @Test
    public void passwordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);
    }

    /**
     * 获取token
     */
    @Test
    public void token() {
        String jwt = JwtUtil.createJWT("megallmx");
        System.out.println(jwt);
    }

    /**
     * 解析Jwt
     * @throws Exception
     */
    @Test
    public void ParseJwt() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyOTI3OGI4NDAxOGE0MmEyYmNkMDcwNTEzNTU3YmI5ZCIsInN1YiI6IjEiLCJpc3MiOiJtZWdhbGxteCIsImlhdCI6MTY5MTAzMTE4MywiZXhwIjoxNjkxMDM0NzgzfQ.2wwcrpywsCwjGi2bGQQxddj6Ac75dm51xdVV_AgIXPA";
        Claims claims = JwtUtil.parseJWT(token);
        System.out.println(claims);
    }

}
