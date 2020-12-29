package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.StudentDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mars_sea
 */
public interface StudentRepository extends CrudRepository<StudentDO, Long> {

	/**
	 * 按照医生账号和密码查找
	 * 遵循spring data jpa 命名标准
	 *
	 * @param sno 医生账号
	 * @param spwd 医生密码
	 * @return 医生实体类
	 */
	StudentDO findBySnoAndSpwd(Integer sno, String spwd);
}
