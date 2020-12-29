package cn.edu.cdtu.SHOMIS.web;


import cn.edu.cdtu.SHOMIS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mars_sea
 */
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

}
