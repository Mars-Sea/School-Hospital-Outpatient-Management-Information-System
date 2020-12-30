package cn.edu.cdtu.SHOMIS.service;

import cn.edu.cdtu.SHOMIS.model.entity.RegisteredDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RegistrationService {
    //    查询所有订单

   List<RegisteredDO> findBystudents(Integer dno);

    List<RegisteredDO> findAllByDoctor_DnoOrderBySequence(Integer dno);

    List<RegisteredDO> findAllByStudentSno(Integer sno);
}
