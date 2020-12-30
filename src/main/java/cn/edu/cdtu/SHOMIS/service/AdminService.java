package cn.edu.cdtu.SHOMIS.service;

import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;
import cn.edu.cdtu.SHOMIS.model.entity.Today;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author mars_sea
 */
public interface AdminService {

	/**
	 * 通过管理员账号和密码进行登录认证
	 * @param ano 管理员账号
	 * @param apwd 管理员密码
	 * @return 返回管理员信息类
	 */
	 AdminDO adminLoginByAnoAndApwd(Integer ano, String apwd);

	 ArrayList<Today> toDay(Date date);
}
