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
		ModelAndView modelAndView = new ModelAndView();
		switch (message){
			case "学生":
				modelAndView.setViewName("redirect:/student");
				break;
			case "医生":
				modelAndView.setViewName("redirect:/doctor");
				break;
			case "管理员":
				modelAndView.setViewName("redirect:/admin");
				break;
			default:
				modelAndView.setViewName("/login");
				modelAndView.addObject("message",message);

		}
		return modelAndView;
	}
}
