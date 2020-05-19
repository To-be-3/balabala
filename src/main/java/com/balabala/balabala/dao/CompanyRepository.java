package com.balabala.balabala.dao;

import com.balabala.balabala.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("companyRepository")
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c where account like ?1 or companyName like ?1 or phone like ?1 or email like ?1")
    public Page<Company> findByKeyword(String keyword, Pageable pageable);

    @Query("update Company c set c.password=?1 where c.companyId=?2")
    public void modifyPassword(String password,Integer id);

    //通过账号查询用户信息，获取唯一用户
    @Query("select c from Company c where account=?1")
    public Optional<Company> findByAccount(String account);
}
