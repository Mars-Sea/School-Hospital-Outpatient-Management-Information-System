package cn.edu.cdtu.SHOMIS.controller;

import cn.edu.cdtu.SHOMIS.model.DrugDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mars_sea
 */
public interface DrugRepository extends CrudRepository<DrugDO,Integer> {
}
