package cn.edu.cdtu.SHOMIS.web;

import cn.edu.cdtu.SHOMIS.model.entity.AdminDO;
import cn.edu.cdtu.SHOMIS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mars_sea
 */
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/login")
	public String login(@RequestBody String ano, String apwd){
		AdminDO admin = adminService.adminLoginByAnoAndApwd(ano, apwd);

		if (admin.getAno().isEmpty()){
			return "用户密码错误或者用户不存在！";
		}
		return admin.getName();
	}
	@GetMapping("/test1")
	public void test(){
		System.out.println("test");
	}
}
