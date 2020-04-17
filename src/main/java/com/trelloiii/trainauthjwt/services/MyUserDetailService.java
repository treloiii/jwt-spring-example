package com.trelloiii.trainauthjwt.services;

import com.trelloiii.trainauthjwt.entities.Users;
import com.trelloiii.trainauthjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user=userRepository.findByLogin(s);
        if(user==null)
            throw new UsernameNotFoundException("user not found");

        List<SimpleGrantedAuthority> authorities;
        switch (user.getRole()){
            case 2:
                authorities=Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),new SimpleGrantedAuthority("ROLE_MODERATOR"));
                break;
            case 3:
                authorities=Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),
                                                      new SimpleGrantedAuthority("ROLE_MODERATOR"),
                                                      new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
            default:
                authorities=Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
                break;
        }
        return new User(user.getLogin(),user.getPassword(),authorities);
    }
}
