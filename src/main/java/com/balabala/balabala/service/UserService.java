package com.balabala.balabala.service;

import com.balabala.balabala.domain.User;
import com.balabala.balabala.domain.UserLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public void save(User user) throws Exception;
    public Page<User> findAll(String keyword, Pageable pageable);
    public User findById(Integer uid);
    public void delete(User user);
    public void deleteById(Integer uid);
    public void deletes(List<User> users);
    public User checkUser(UserLogin userLogin);
}
