package cn.edu.cdtu.SHOMIS.service.impl;

import cn.edu.cdtu.SHOMIS.model.entity.RegisteredDO;
import cn.edu.cdtu.SHOMIS.model.repository.RegisteredRepository;
import cn.edu.cdtu.SHOMIS.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisteredServiceImpl implements RegistrationService {
    @Autowired
    protected RegisteredRepository registeredRepository;


    @Override
    public List<RegisteredDO> findBystudents(Integer dno) {
        List<RegisteredDO> bystudents = registeredRepository.findBystudents(2020001);

        return bystudents;
    }

    @Override
    public List<RegisteredDO> findAllByDoctor_DnoOrderBySequence(Integer dno) {
        List<RegisteredDO> bystudents = registeredRepository.findAllByDoctor_DnoOrderBySequence(2020001);

        return bystudents;
    }



    @Override
    public RegisteredDO findAllByStudentSno(Integer sno) {
        RegisteredDO allByStudentSno = registeredRepository.findAllByStudentSno(sno);

        return allByStudentSno;

    }


    @Override
    @Transactional
    public Integer updateBysno(Integer sequence, Integer sno) {
        Integer integer = registeredRepository.updateBysno(sequence, sno);
        return integer;
    }

    @Override
    @Transactional
    public Integer updateSee(String prescription, Float price, Integer sno) {
        Integer integer = registeredRepository.updateSee(prescription, price, sno);
        return integer;
    }
}
