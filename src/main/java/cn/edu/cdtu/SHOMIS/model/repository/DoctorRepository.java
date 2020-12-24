package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mars_sea
 */
public interface DoctorRepository extends CrudRepository<DoctorDO,Integer> {
}
