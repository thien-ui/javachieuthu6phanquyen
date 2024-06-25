package com.hutech.Nguyentansang.services;

import com.hutech.Nguyentansang.repository.IUserRepository;
import com.hutech.Nguyentansang.entity.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import com.hutech.Nguyentansang.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetail(user,userRepository);
    }
}
