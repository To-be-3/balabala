package com.balabala.balabala.service;

import com.balabala.balabala.dao.UserRepository;
import com.balabala.balabala.domain.User;
import com.balabala.balabala.domain.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> findAll(String keyword, Pageable pageable) {
        return userRepository.findByKeyword(keyword,pageable);
    }

    @Override
    public User findById(Integer uid) {
        return userRepository.findById(uid).get();
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Integer uid) {

    }

    @Override
    public void deletes(List<User> users) {

    }

    @Override
    public User checkUser(UserLogin userLogin) {
        return null;
    }
}
