package com.balabala.balabala.service;

import com.balabala.balabala.dao.UserRepository;
import com.balabala.balabala.domain.User;
import com.balabala.balabala.domain.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Integer uid) {
        userRepository.deleteById(uid);
    }

    @Transactional
    @Override
    public void deletes(List<User> users) {
        for(User u:users){
            delete(u);
        }
    }

    @Override
    public User checkUser(UserLogin userLogin) {
        User user=null;
        Optional<User> optionalUser=userRepository.findByAccount(userLogin.getAccount());
        if (optionalUser.isPresent()) {//判断Optional中是否包含目标对象
            user=optionalUser.get();
            if(user.getPassword().equals(userLogin.getPassword())){
                return user;
            }
        }
        return null;
    }
}
