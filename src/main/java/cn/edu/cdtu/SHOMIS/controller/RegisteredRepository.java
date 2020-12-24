package cn.edu.cdtu.SHOMIS.controller;

import cn.edu.cdtu.SHOMIS.model.RegisteredDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mars_sea
 */
public interface RegisteredRepository extends CrudRepository<RegisteredDO,Integer> {
}
