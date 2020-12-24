package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.StudentDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mars_sea
 */
public interface StudentRepository extends CrudRepository<StudentDO, Integer> {
}
