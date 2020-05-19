package com.balabala.balabala.service;

import com.balabala.balabala.dao.TechnicianRepository;
import com.balabala.balabala.domain.Technician;
import com.balabala.balabala.domain.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class TechnicianService implements BaseService<Technician, UserLogin> {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Override
    public void save(Technician technician) throws Exception {
        technicianRepository.save(technician);
    }

    @Override
    public Page<Technician> findAll(String keyword, Pageable pageable) {
        return technicianRepository.findByKeyword(keyword,pageable);
    }

    @Override
    public Technician findById(Integer id) {
        return technicianRepository.findById(id).get();
    }

    @Override
    public void delete(Technician technician) {
        technicianRepository.delete(technician);
    }

    @Override
    public void deleteById(Integer id) {
        technicianRepository.deleteById(id);
    }

    @Override
    public void deletes(List<Technician> technicians) {
        for (Technician t : technicians){
            delete(t);
        }
    }

    @Override
    public Technician checkUser(UserLogin userLogin) {
        Technician technician=null;
        Optional<Technician> optionalTechnician= technicianRepository.findByAccount(userLogin.getAccount());
        if(optionalTechnician.isPresent()){
            technician=optionalTechnician.get();
            if(technician.getPassword().equals(userLogin.getPassword()))
                return technician;
        }
        return null;
    }
}
