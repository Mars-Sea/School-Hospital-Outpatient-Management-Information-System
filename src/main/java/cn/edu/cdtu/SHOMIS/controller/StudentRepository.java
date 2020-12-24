package cn.edu.cdtu.SHOMIS.controller;

import cn.edu.cdtu.SHOMIS.model.StudentDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mars_sea
 */
public interface StudentRepository extends CrudRepository<StudentDO, Integer> {
}
