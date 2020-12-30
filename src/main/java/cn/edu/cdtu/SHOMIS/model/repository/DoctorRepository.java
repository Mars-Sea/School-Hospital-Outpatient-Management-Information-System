package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;
import cn.edu.cdtu.SHOMIS.model.entity.StudentDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * @author mars_sea
 */
public interface DoctorRepository extends CrudRepository<DoctorDO,Integer> {

	/**
	 * 按照医生账号和密码查找
	 * 遵循spring data jpa 命名标准
	 *
	 * @param dno 医生账号
	 * @param dpwd 医生密码
	 * @return 医生实体类
	 */
	DoctorDO findByDnoAndDpwd(Integer dno, String dpwd);

	@Query(value = "SELECT * from doctors WHERE dno LIKE ?1 OR dname LIKE ?2", nativeQuery = true)
	ArrayList<DoctorDO> findAllBySearch(String dno, String dname);
}
