package cn.edu.cdtu.SHOMIS.service.impl;

import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;
import cn.edu.cdtu.SHOMIS.model.repository.DoctorRepository;
import cn.edu.cdtu.SHOMIS.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author mars_sea
 */
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	protected DoctorRepository doctorRepository;
	@Override
	public ArrayList<DoctorDO> findAllDoctor() {
		Iterable<DoctorDO> doctors = doctorRepository.findAll();
		ArrayList<DoctorDO> doctorList = new ArrayList<>();
		for (DoctorDO d: doctors) {
			doctorList.add(new DoctorDO(d.getDno(),d.getDname(),d.getDage(),d.getDsex(),d.getDpwd(),d.getjMalibox()));
		}
		return doctorList;
	}

	@Override
	@Transactional
	public Integer updatePsw(String psw, Integer dno) {
		Integer integer = doctorRepository.updatePsw(psw, dno);
		return integer;
	}

	@Override
	public DoctorDO findByDnoAndDpwd(Integer dno, String dpwd) {
		DoctorDO byDnoAndDpwd = doctorRepository.findByDnoAndDpwd(dno, dpwd);
		return byDnoAndDpwd;
	}
}
