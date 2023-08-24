package com.home.JWTuserlogin.model.service;

import com.home.JWTuserlogin.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepository.findByUsername(username).isPresent())return userRepository.findByUsername(username).get();
        throw new UsernameNotFoundException("username is invalid");
    }
}
