package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author mars_sea
 */
public interface AdminRepository extends CrudRepository<AdminDO,Integer> {

	/**
	 * 按照管理员账号和密码查找
	 * 遵循spring data jpa 命名标准
	 *
	 * @param ano 管理员账号
	 * @param apwd 管理员密码
	 * @return 管理员实体类
	 */
	AdminDO findByAnoAndApwd(Integer ano, String apwd);

	@Query(value = "select r.id,r.app_time,d.dname,s.sname,s.sno from registers r,doctors d,students s WHERE r.doctor_dno = d.dno AND r.student_sno=s.sno And r.app_time = ?1",nativeQuery = true)
	ArrayList<String> today(Date date);

	@Query(value = "select app_time,COUNT(app_time) FROM registers GROUP BY app_time ORDER BY app_time;",nativeQuery = true)
	ArrayList<String> statistics();

	@Query(value = "select s.sname,s.sno,COUNT(s.sno) as c from registers r,students s WHERE r.student_sno=s.sno GROUP BY s.sno ORDER BY c Desc LIMIT 10", nativeQuery = true)
	ArrayList<String> topStudent();

	@Query(value = "select d.dname,d.dno,COUNT(d.dno) as c from registers r,doctors d WHERE r.doctor_dno=d.dno GROUP BY d.dno ORDER BY c Desc LIMIT 10", nativeQuery = true)
	ArrayList<String> topDoctor();
}
