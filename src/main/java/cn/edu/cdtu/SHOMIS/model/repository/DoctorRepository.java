package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;
import org.springframework.data.repository.CrudRepository;

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
}
