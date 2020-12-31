package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;
import cn.edu.cdtu.SHOMIS.model.entity.DrugDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mars_sea
 */
public interface DrugRepository extends CrudRepository<DrugDO,Integer> {

	@Transactional
	void removeByMno(String mno);

	@Query(value = "SELECT * from drugs WHERE mno LIKE ?1 OR mname LIKE ?2", nativeQuery = true)
	ArrayList<DrugDO> findAllBySearch(String mno, String mname);
}
