package cn.edu.cdtu.SHOMIS.web;


import cn.edu.cdtu.SHOMIS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mars_sea
 */
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("/admin");
		return modelAndView;
	}
}
