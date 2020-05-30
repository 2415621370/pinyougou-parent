package com.pinyougou.user.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/30 9:43
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //角色的结合
        List<GrantedAuthority> list =  new ArrayList();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(username,"",list);
    }
}
