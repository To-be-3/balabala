package com.balabala.balabala.service;

import com.balabala.balabala.dao.CompanyRepository;
import com.balabala.balabala.domain.Company;
import com.balabala.balabala.domain.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class CompanyService implements BaseService<Company, UserLogin> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void save(Company company) throws Exception {
        companyRepository.save(company);
    }

    @Override
    public Page<Company> findAll(String keyword, Pageable pageable) {
        return companyRepository.findByKeyword(keyword,pageable);
    }

    @Override
    public Company findById(Integer id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public void deleteById(Integer id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void deletes(List<Company> companies) {
        for (Company c : companies){
            delete(c);
        }
    }

    @Override
    public Company checkUser(UserLogin userLogin) {
        Company company=null;
        Optional<Company> optionalCompany=companyRepository.findByAccount(userLogin.getAccount());
        if(optionalCompany.isPresent()){
            company=optionalCompany.get();
            if(company.getPassword().equals(userLogin.getPassword()))
                return  company;
        }
        return null;
    }
}
