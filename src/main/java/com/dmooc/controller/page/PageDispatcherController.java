package com.dmooc.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmooc.constants.PageUrlConstants;
import com.dmooc.service.teacher.TeacherLoginAndRegisterService;

@Controller
public class PageDispatcherController {
	
	@Autowired
	private PageUrlConstants pageUrlConstants;
	
	@Autowired
	private TeacherLoginAndRegisterService teacherLoginAndRegisterService;
	
	@RequestMapping("/")
	public String indexPage(){
		System.out.println("index page");
		return pageUrlConstants.TEACHER_LOGIN_PAGE;
	}
	
	@RequestMapping("/login")
	public String loginPage(){
		System.out.println("login page");
		return pageUrlConstants.TEACHER_LOGIN_PAGE;
	}
	
	@RequestMapping("/teacher/loginPage")
	public String teacherLoginPage(){
		System.out.println("login page");
		return pageUrlConstants.TEACHER_LOGIN_PAGE;
	}
	
	@RequestMapping("/teacher/registerPage")
	public String TeacherRegisterPage(){
		System.out.println("register page");
		return pageUrlConstants.TEACHER_REGISTER_PAGE;
	}
	
	@RequestMapping("/teacher/homepage")
	public String teacherHomepage(){
		System.out.println("home page");
		teacherLoginAndRegisterService.handleLoginSuccess();
		return pageUrlConstants.TEACHER_HOME_PAGE;
	}
	
	@RequestMapping("/teacher/logsPage")
	public String teacherLogsPage(){
		System.out.println("reports page");
		return pageUrlConstants.TEACHER_LOGS_PAGE;
	}
	
	@RequestMapping("*")
	public String notFoundPage(){
		System.out.println("page not found");
		return pageUrlConstants.NOT_FOUND_PAGE;
	}
	
}
