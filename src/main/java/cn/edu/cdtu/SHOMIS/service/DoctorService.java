package cn.edu.cdtu.SHOMIS.service;

import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;

import java.util.ArrayList;

/**
 * @author mars_sea
 */
public interface DoctorService {
	/**
	 * 通过管理员账号和密码进行登录认证
	 * @return 全部医生信息
	 */
	ArrayList<DoctorDO> findAllDoctor();
}
