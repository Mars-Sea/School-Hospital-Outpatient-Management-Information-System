package cn.edu.cdtu.SHOMIS.web;


import cn.edu.cdtu.SHOMIS.model.entity.DoctorDO;
import cn.edu.cdtu.SHOMIS.model.entity.StudentDO;
import cn.edu.cdtu.SHOMIS.model.entity.Today;
import cn.edu.cdtu.SHOMIS.model.entity.TopStudent;
import cn.edu.cdtu.SHOMIS.model.repository.AdminRepository;
import cn.edu.cdtu.SHOMIS.model.repository.StudentRepository;
import cn.edu.cdtu.SHOMIS.service.AdminService;
import cn.edu.cdtu.SHOMIS.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
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
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/admin")
	public ModelAndView index() throws ParseException {
		ArrayList<DoctorDO> doctors = doctorService.findAllDoctor();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Today> todays = adminService.toDay(formatter.parse(formatter.format(date)));
		ModelAndView modelAndView = new ModelAndView("/admin");
		modelAndView.addObject("doctors", doctors);
		modelAndView.addObject("todays", todays);
		return modelAndView;
	}

	@GetMapping("/statistics")
	public ModelAndView statistics(){
		ArrayList<String> statistics = adminRepository.statistics();
		ArrayList<String> data = new ArrayList<>();
		ArrayList<String> labels = new ArrayList<>();
		for (String s: statistics) {
			String[] strings = s.split(",");
			data.add(strings[1]);
			labels.add(strings[0]);
		}

		ArrayList<String> topS = adminRepository.topStudent();
		ArrayList<TopStudent> topStudents = new ArrayList<>();
		for (String s: topS) {
			String[] strings = s.split(",");
			TopStudent student = new TopStudent(strings[0],strings[1],strings[2]);
			topStudents.add(student);
		}

		ArrayList<String> topD = adminRepository.topDoctor();
		ArrayList<String> dataD = new ArrayList<>();
		ArrayList<String> labelsD = new ArrayList<>();
		ArrayList<TopStudent> topDoctor = new ArrayList<>();
		for (String s: topD) {
			String[] strings = s.split(",");
			dataD.add(strings[2]);
			labelsD.add(strings[0]);
			TopStudent topd = new TopStudent(strings[0],strings[1],strings[2]);
			topDoctor.add(topd);
		}
		ModelAndView modelAndView = new ModelAndView("/statistics");
		modelAndView.addObject("data",data);
		modelAndView.addObject("labels",labels);
		modelAndView.addObject("datad",dataD);
		modelAndView.addObject("labelsd",labelsD);
		modelAndView.addObject("topStudents",topStudents);
		modelAndView.addObject("topDoctor",topDoctor);
		return modelAndView;
	}

	@GetMapping("/student")
	public ModelAndView sutdent() throws ParseException {
		ArrayList<StudentDO> students = (ArrayList<StudentDO>) studentRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("/student");
		modelAndView.addObject("students", students);
		return modelAndView;
	}

	@PostMapping("/student")
	public @ResponseBody ModelAndView searchSutdent(String search) throws ParseException {
		ArrayList<StudentDO> students = studentRepository.findallBySearch("%"+search+"%","%"+search+"%");
		ModelAndView modelAndView = new ModelAndView("/student");
		modelAndView.addObject("students", students);
		return modelAndView;
	}

	@PostMapping("/addstudent")
	public @ResponseBody ModelAndView addStudent(String sno, String sname, String ssex, String sage){
		System.out.println("666666");
		StudentDO studentDO = new StudentDO(Integer.parseInt(sno),sname,Integer.parseInt(sage),ssex,"123456");
		studentRepository.save(studentDO);
		ModelAndView modelAndView = new ModelAndView("redirect:/student");
		return modelAndView;
	}

}
