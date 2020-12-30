package cn.edu.cdtu.SHOMIS.service.impl;

import cn.edu.cdtu.SHOMIS.model.entity.Today;
import cn.edu.cdtu.SHOMIS.model.repository.AdminRepository;
import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;
import cn.edu.cdtu.SHOMIS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

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

	@Override
	public ArrayList<Today> toDay(Date date) {
		ArrayList<String> list = adminRepository.today(date);
		ArrayList<Today> todays = new ArrayList<>();

		for (String s : list) {
			String[] strings = s.split(",");
			Today today = new Today(strings[3], strings[2], strings[1],strings[4], strings[0]);
			todays.add(today);
		}
		return todays;
	}
}
