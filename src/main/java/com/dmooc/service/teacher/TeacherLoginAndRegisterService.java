package com.dmooc.service.teacher;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.dmooc.constants.PageUrlConstants;
import com.dmooc.dao.TeacherDao;
import com.dmooc.data.TeacherLoginAndRegisterData;
import com.dmooc.model.TeacherModel;

public class TeacherLoginAndRegisterService {
	@Autowired
	PageUrlConstants pageUrlConstants;
	
	@Autowired
	MongoOperations mongo;
	
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired  
	private HttpSession session;

	public String login(TeacherLoginAndRegisterData loginData) {
		return pageUrlConstants.TEACHER_HOME_PAGE;
	}

	/**
	 * 注册新老师
	 * @param registerData
	 * @return
	 */
	public String register(TeacherLoginAndRegisterData registerData) {
		teacherDao.addNewTeacher(registerData);
		return pageUrlConstants.TEACHER_LOGIN_PAGE;
	}

	public void addData() {
		teacherDao.addData();
	}

	public void handleLoginSuccess() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
		String name = userDetails.getUsername();
		session.setAttribute("name", name);
	}
	

}
