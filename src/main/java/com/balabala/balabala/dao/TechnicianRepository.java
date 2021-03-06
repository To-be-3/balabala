package com.balabala.balabala.dao;

import com.balabala.balabala.domain.Technician;
import com.balabala.balabala.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("technicianRepository")
public interface TechnicianRepository extends JpaRepository<Technician,Integer> {
    @Query("select u from Technician u where account like ?1 or username like ?1 or phone like ?1 or email like ?1")
    public Page<Technician> findByKeyword(String keyword, Pageable pageable);

    @Query("update Technician u set u.password=?1 where u.userId=?2")
    public void modifyPassword(String password,Integer id);

    //通过账号查询用户信息，获取唯一用户
    @Query("select u from Technician u where account=?1")
    public Optional<Technician> findByAccount(String account);
}
