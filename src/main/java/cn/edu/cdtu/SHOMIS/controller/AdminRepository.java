package cn.edu.cdtu.SHOMIS.controller;

import cn.edu.cdtu.SHOMIS.model.AdminDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mars_sea
 */
public interface AdminRepository extends CrudRepository<AdminDO,Integer> {
}
