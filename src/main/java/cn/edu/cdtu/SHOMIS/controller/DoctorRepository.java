package cn.edu.cdtu.SHOMIS.controller;

import cn.edu.cdtu.SHOMIS.model.DoctorDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mars_sea
 */
public interface DoctorRepository extends CrudRepository<DoctorDO,Integer> {
}
