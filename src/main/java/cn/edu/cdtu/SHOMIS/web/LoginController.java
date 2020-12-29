package cn.edu.cdtu.SHOMIS.web;

import cn.edu.cdtu.SHOMIS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;

/**
 * @author mars_sea
 */
@RestController
public class LoginController {

	@Autowired
	private AdminService adminService;

	@PermitAll
	@GetMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("/login");
	}
}
