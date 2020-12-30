package cn.edu.cdtu.SHOMIS.web;


import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;
import cn.edu.cdtu.SHOMIS.model.entity.Today;
import cn.edu.cdtu.SHOMIS.model.repository.AdminRepository;
import cn.edu.cdtu.SHOMIS.service.AdminService;
import cn.edu.cdtu.SHOMIS.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author mars_sea
 */
@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/admin")
	public ModelAndView index() {
		ArrayList<DoctorDO> doctors = doctorService.findAllDoctor();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Today> todays = adminService.toDay(date);
		ModelAndView modelAndView = new ModelAndView("/admin");
		modelAndView.addObject("doctors", doctors);
		modelAndView.addObject("todays", todays);
		return modelAndView;
	}

}
