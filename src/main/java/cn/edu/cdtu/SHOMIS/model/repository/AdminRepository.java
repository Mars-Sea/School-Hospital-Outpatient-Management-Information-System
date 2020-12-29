package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;
import org.springframework.data.repository.CrudRepository;

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

}
