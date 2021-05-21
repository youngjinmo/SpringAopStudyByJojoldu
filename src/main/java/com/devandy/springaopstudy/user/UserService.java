package com.devandy.springaopstudy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends UserPerformance{

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        long start = System.currentTimeMillis();
        List<User> users = userRepository.findAll();
        long end = System.currentTimeMillis();

        System.out.println("수행 시간 : "+(end-start));
        return users;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
