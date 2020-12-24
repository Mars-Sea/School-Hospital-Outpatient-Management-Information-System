package cn.edu.cdtu.SHOMIS.service;

import org.springframework.ui.Model;

/**
 * @author mars_sea
 */
public interface AdminService {

	/**
	 * 通过管理员账号和密码进行登录认证
	 * @param ano 管理员账号
	 * @param apwd 管理员密码
	 */
	public void adminLoginByAnoAndApwd(String ano,String apwd);
}
