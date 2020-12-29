package cn.edu.cdtu.SHOMIS.service.impl;

import cn.edu.cdtu.SHOMIS.model.entity.StudentDO;
import cn.edu.cdtu.SHOMIS.model.repository.AdminRepository;
import cn.edu.cdtu.SHOMIS.model.repository.DoctorRepository;
import cn.edu.cdtu.SHOMIS.model.repository.StudentRepository;
import cn.edu.cdtu.SHOMIS.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author mars_sea
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	protected AdminRepository adminRepository;
	@Autowired
	protected StudentRepository studentRepository;
	@Autowired
	protected DoctorRepository doctorRepository;

	@Override
	public String loginByNumberAndPassword(Integer number, String password) {
		try {
			if (studentRepository.findBySnoAndSpwd(number, password) != null ){
				return "学生";
			}else if (doctorRepository.findByDnoAndDpwd(number,password) != null){
				return "医生";
			}else if (adminRepository.findByAnoAndApwd(number,password) != null){
				return "管理员";
			}else {
				return "用户不存在，或者用户名或密码错误！";
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return "用户不存在，或者用户名或密码错误！";

	}
}
