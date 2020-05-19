package com.balabala.balabala.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T,S>{
    public void save(T t) throws Exception;
    public Page<T> findAll(String keyword, Pageable pageable);
    public T findById(Integer id);
    public void delete(T t);
    public void deleteById(Integer id);
    public void deletes(List<T> ts);
    public T checkUser(S s);
}
