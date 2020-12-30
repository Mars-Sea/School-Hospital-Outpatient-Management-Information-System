package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.StudentDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

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

	ArrayList<StudentDO> findAllBySnameLikeOrSnoLike(String sname, Integer sno);

	@Query(value = "SELECT * from students WHERE sno LIKE ?1 OR sname LIKE ?2", nativeQuery = true)
	ArrayList<StudentDO> findallBySearch(String sname, String sno);

	@Transactional
	void removeBySno(Integer sno);
}
