package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.DrugDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author mars_sea
 */
public interface DrugRepository extends CrudRepository<DrugDO,Integer> {


}
