package com.hutech.Nguyentansang.services;

import com.hutech.Nguyentansang.entity.Role;
import com.hutech.Nguyentansang.entity.User;
import com.hutech.Nguyentansang.repository.IRoleRepository;
import com.hutech.Nguyentansang.repository.IUserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    public void save(User user) {
        userRepository.save(user);
        Long userId= userRepository.getUserIdByUsername(user.getUsername());
        Long roleId=roleRepository.getRoleIdByName("USER");
        if(roleId !=0 && userId != 0){
            userRepository.addRoleToUser(userId,roleId);
        }
    }

}
