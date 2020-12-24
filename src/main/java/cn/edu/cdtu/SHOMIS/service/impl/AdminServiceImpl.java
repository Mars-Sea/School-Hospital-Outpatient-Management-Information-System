package cn.edu.cdtu.SHOMIS.service.impl;

import cn.edu.cdtu.SHOMIS.model.repository.AdminRepository;
import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;
import cn.edu.cdtu.SHOMIS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author mars_sea
 */
public class AdminServiceImpl implements AdminService {

	@Autowired
	protected AdminRepository adminRepository;

	@Override
	public void adminLoginByAnoAndApwd(String ano, String apwd) {
		AdminDO admin = adminRepository.findByAnoAndApwd(ano, apwd);
	}
}
