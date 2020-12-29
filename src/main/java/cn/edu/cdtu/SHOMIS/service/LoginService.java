package cn.edu.cdtu.SHOMIS.service;

import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;

/**
 * @author mars_sea
 */
public interface LoginService {
	/**
	 * 通过管理员账号和密码进行登录认证
	 * @param number 账号
	 * @param password 密码
	 * @return 返回管理员信息类
	 */
	String  loginByNumberAndPassword(Integer number, String password);
}
