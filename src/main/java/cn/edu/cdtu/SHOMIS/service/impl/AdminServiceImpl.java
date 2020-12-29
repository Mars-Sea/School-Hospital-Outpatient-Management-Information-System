package cn.edu.cdtu.SHOMIS.service.impl;

import cn.edu.cdtu.SHOMIS.model.repository.AdminRepository;
import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;
import cn.edu.cdtu.SHOMIS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mars_sea
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	protected AdminRepository adminRepository;

	@Override
	public AdminDO adminLoginByAnoAndApwd(Integer ano, String apwd) {

		return adminRepository.findByAnoAndApwd(ano, apwd);
	}
}
