package com.dmooc.controller.teacher;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmooc.data.TeacherLoginAndRegisterData;
import com.dmooc.service.teacher.TeacherLoginAndRegisterService;
import com.dmooc.service.tools.VerifyCodeService;
import com.dmooc.validate.LoginAndRegisterValidate;

@Controller
@RequestMapping("/teacher")
public class LoginAndRegisterController {
	private final String TEACHER_REGISTER_PAGE = "/jsp/teacherRegisterPage.jsp";
	
	@Autowired
	private TeacherLoginAndRegisterService teacherLoginAndRegisterService;
	
	@Autowired
	private LoginAndRegisterValidate loginAndRegisterValidate;
	
	@Autowired
	private VerifyCodeService verifyCodeService;
	
	@RequestMapping("/addData")
	@ResponseBody
	public String addData(){
		teacherLoginAndRegisterService.addData();
		return "success";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String teacherLogin(){
		System.out.println("teacher try login in");
		return "redirect:/teacher/homepage";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String teacherRegister(TeacherLoginAndRegisterData  registerData,Model model){
		System.out.println("teacher try register");
		Map<String,String> results = loginAndRegisterValidate.validate(registerData);
		if(!results.isEmpty()){
			for(String key : results.keySet()){
				model.addAttribute(key, results.get(key));
			}
			return TEACHER_REGISTER_PAGE;
		}
		return teacherLoginAndRegisterService.register(registerData);
	}
	
	@RequestMapping(value="/getVerifyCodeImg")
	@ResponseBody
	public String getVerifyCodeImg(HttpServletRequest request,HttpServletResponse response){
		verifyCodeService.createVerifyCodeImg(request,response);
		return "get verify code img success";
	}
	
	@RequestMapping(value="/verifyCode")
	@ResponseBody
	public boolean verifyCode(HttpServletRequest request){
		return verifyCodeService.verifyCode(request);
	}
	
	
}
