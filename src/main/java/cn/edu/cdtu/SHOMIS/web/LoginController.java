package cn.edu.cdtu.SHOMIS.web;

import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;
import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;
import cn.edu.cdtu.SHOMIS.model.entity.StudentDO;
import cn.edu.cdtu.SHOMIS.model.repository.AdminRepository;
import cn.edu.cdtu.SHOMIS.model.repository.DoctorRepository;
import cn.edu.cdtu.SHOMIS.model.repository.StudentRepository;
import cn.edu.cdtu.SHOMIS.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author mars_sea
 */
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	protected AdminRepository adminRepository;
	@Autowired
	protected StudentRepository studentRepository;
	@Autowired
	protected DoctorRepository doctorRepository;


	@GetMapping("/login")
	public ModelAndView openLogin(){
		return new ModelAndView("/login");
	}

	@PostMapping("/loginPost")
	public @ResponseBody ModelAndView login(Integer number, String password, HttpServletRequest request){
		String message = loginService.loginByNumberAndPassword(number,password);
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		switch (message){
			case "学生":
				StudentDO bySnoAndSpwd = studentRepository.findBySnoAndSpwd(number, password);
				session.setAttribute("student", bySnoAndSpwd);
				modelAndView.setViewName("redirect:/student");
				break;
			case "医生":
				DoctorDO byDnoAndDpwd = doctorRepository.findByDnoAndDpwd(number, password);
				session.setAttribute("doctor", byDnoAndDpwd);

				modelAndView.setViewName("redirect:/doctorView");
				break;
			case "管理员":
				AdminDO byAnoAndApwd = adminRepository.findByAnoAndApwd(number, password);

				session.setAttribute("admin", byAnoAndApwd);

				modelAndView.setViewName("redirect:/admin");
				break;
			default:
				modelAndView.setViewName("/login");
				modelAndView.addObject("message",message);

		}
		return modelAndView;
	}
}
