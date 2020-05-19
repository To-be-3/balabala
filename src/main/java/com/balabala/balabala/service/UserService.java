package com.balabala.balabala.service;

import com.balabala.balabala.dao.UserRepository;
import com.balabala.balabala.domain.User;
import com.balabala.balabala.domain.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class UserService implements BaseService<User, UserLogin>{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) throws Exception {
        userRepository.save(user);
    }

    @Override
    public Page<User> findAll(String keyword, Pageable pageable) {
        return userRepository.findByKeyword(keyword,pageable);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deletes(List<User> users) {
        for (User u : users){
            delete(u);
        }
    }

    @Override
    public User checkUser(UserLogin userLogin) {
        User user=null;
        Optional<User> optionalUser=userRepository.findByAccount(userLogin.getAccount());
        if(optionalUser.isPresent()){
            user=optionalUser.get();
            if(user.getPassword().equals(userLogin.getPassword()))
                return  user;
        }
        return null;
    }
}
