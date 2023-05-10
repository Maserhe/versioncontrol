package com.xencio.versionrecord.service.impl;

import com.xencio.versionrecord.entity.JwtUser;
import com.xencio.versionrecord.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by echisan on 2018/6/23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Value("${login.username}")
    private String username;


    @Value("${login.password}")
    private String password;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole("ADMIN");
        return new JwtUser(user);
    }

}
