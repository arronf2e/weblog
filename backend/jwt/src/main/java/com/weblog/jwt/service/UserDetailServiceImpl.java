package com.weblog.jwt.service;

import com.weblog.common.domain.dos.UserDO;
import com.weblog.common.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userMapper.findByUsername(username);

        if (Objects.isNull(userDO)) {
            throw new UsernameNotFoundException("该用户不存在");
        }

        return User.withUsername(userDO.getUsername())
                .password(userDO.getPassword())
                .authorities("admin")
                .build();
    }
}
