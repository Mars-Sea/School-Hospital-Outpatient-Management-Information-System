package cn.edu.cdtu.SHOMIS.web;

import cn.edu.cdtu.SHOMIS.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mars_sea
 */
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;


	@GetMapping("/login")
	public ModelAndView openLogin(){
		return new ModelAndView("/login");
	}

	@PostMapping("/loginPost")
	public @ResponseBody ModelAndView login(Integer number, String password){
		System.out.println(number+"!!!!"+password);
		String message = loginService.loginByNumberAndPassword(number,password);
		switch (message){
			case "学生":
				return new ModelAndView("/student");
			case "医生":
				return new ModelAndView("/doctor");
			case "管理员":
				return new ModelAndView("/admin");
			default:
				ModelAndView modelAndView = new ModelAndView("/login");
				modelAndView.addObject("message",message);
				return modelAndView;
		}


	}
}
