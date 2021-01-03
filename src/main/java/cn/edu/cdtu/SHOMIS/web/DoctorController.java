package cn.edu.cdtu.SHOMIS.web;

import cn.edu.cdtu.SHOMIS.model.entity.*;
import cn.edu.cdtu.SHOMIS.model.repository.DoctorRepository;
import cn.edu.cdtu.SHOMIS.model.repository.DrugRepository;
import cn.edu.cdtu.SHOMIS.service.impl.DoctorServiceImpl;
import cn.edu.cdtu.SHOMIS.service.impl.RegisteredServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    protected RegisteredServiceImpl registeredService;

    @Autowired
    protected DoctorServiceImpl doctorService;
    @Autowired
    protected DrugRepository drugRepository;

    @RequestMapping("/doctorView")
    public  ModelAndView doctorView(HttpServletRequest request){
        ModelAndView doctor = new ModelAndView("doctor/doctorView");
        DoctorDO doctor1 = (DoctorDO) request.getSession().getAttribute("doctor");
        if (doctor1 == null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }else {
            doctor.addObject("doc",doctor1);
            return doctor;
        }

    }

    @RequestMapping("/registration")
    public ModelAndView registrationView(String sno,HttpServletRequest request){
        ModelAndView registration = new ModelAndView("doctor/registrationView");
        DoctorDO doctor1 = (DoctorDO) request.getSession().getAttribute("doctor");
        if (doctor1 == null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }else {
            List<RegisteredDO> registeredDOList = new ArrayList<>();
            if (sno != null && !sno.equals("")){
                int s = Integer.parseInt(sno);
                RegisteredDO registered = registeredService.findAllByStudentSno(s);
                if (registered==null){
                    registration.addObject("msg", "错误！该挂号信息不存在！");
                }
            }else {
                registeredDOList = registeredService.findBystudents(doctor1.getDno());
            }


            List<RegDo> regDoList = new ArrayList<>();
//        System.out.println(byDoctor_dnoOrderByrOrderDesc.size());
            for (int i = 0 ; i < registeredDOList.size(); i++){
                RegisteredDO registeredDO = registeredDOList.get(i);
                StudentDO student = registeredDO.getStudent();
                RegDo regDo = new RegDo();
                regDo.setSequence(registeredDO.getSequence());
                regDo.setSname(student.getSname());
                regDo.setSno(student.getSno());
                regDoList.add(regDo);
            }
            registration.addObject("regList", regDoList);
            registration.addObject("doc",doctor1);

            return registration;
        }
    }

    @RequestMapping("/ageSee")
    public ModelAndView ageSee(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("doctor/ageSeeDoctor");
        DoctorDO doctor1 = (DoctorDO) request.getSession().getAttribute("doctor");
        if (doctor1 == null){
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }else {
            modelAndView.addObject("doc",doctor1);
            return modelAndView;
        }
    }


    @RequestMapping("/seeDoctor")
    public ModelAndView seeDoctor(String sno,HttpServletRequest request){
        ModelAndView seeDoctor = new ModelAndView("doctor/seeDoctor");
        DoctorDO doctor1 = (DoctorDO) request.getSession().getAttribute("doctor");
        if (doctor1 == null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }else {
            int i = Integer.parseInt(sno);

            RegisteredDO registeredDO = registeredService.findAllByStudentSno(i);

            StudentDO student = registeredDO.getStudent();


            List<DrugDO> all = (ArrayList)drugRepository.findAll();
            System.out.println(all);

            seeDoctor.addObject("doc",doctor1);
            seeDoctor.addObject("reg", registeredDO);
            seeDoctor.addObject("stu", student);
            seeDoctor.addObject("drugList",all);



            return seeDoctor;
        }
    }

    @PostMapping("/updatePsw")
    @ResponseBody
    public String updatePsw(String oldPsw, String newPsw, String verify,HttpServletRequest request){
        String msg = "success";
        DoctorDO doctor1 = (DoctorDO) request.getSession().getAttribute("doctor");

        Integer dno = doctor1.getDno();

        DoctorDO byDnoAndDpwd = doctorService.findByDnoAndDpwd(dno, oldPsw);
        if (byDnoAndDpwd !=null){
            doctorService.updatePsw(newPsw, dno);

        }else {
            msg = "密码不正确！";
        }



        return msg;
    }

    @PostMapping("/updateDrug")
    @ResponseBody
    public String updateDrug(String prescription, Integer sno,Float price,String symptom,HttpServletRequest request){
        String msg = "success";

        Integer integer = registeredService.updateSee(prescription, price, sno, symptom);
        if (integer==0){
           msg = "修改失败！";
        }
        return msg;
    }

    @PostMapping("/alterreg")
    @ResponseBody
    public String updateReg(String xh,String sno,HttpServletRequest request){
        String msg = "success";
        String[] xhList = xh.split(",");
        String[] snoList = sno.split(",");

        for (int i = 0; i < snoList.length; i++){
            for (int j = i+1; j < snoList.length; j++){
                if (xhList[i].equals(xhList[j])){
                    msg = "顺序重复!";
                }
            }
        }
        if (msg == "success"){
            for (int i = 0; i < snoList.length; i++){

                int parseInt1 = Integer.parseInt(xhList[i]);
                int parseInt2 = Integer.parseInt(snoList[i]);
                System.out.println(parseInt1);
                Integer integer = registeredService.updateBysno(parseInt1, parseInt2);
                if (integer==0) {
                    msg = parseInt2 + ",failure";

                }
            }
        }

        return msg;
    }




}
