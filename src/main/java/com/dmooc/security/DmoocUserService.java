package com.dmooc.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dmooc.dao.TeacherDao;
import com.dmooc.model.TeacherModel;

public class DmoocUserService implements UserDetailsService {

	private TeacherDao teacherDao;
	
	private HttpSession session;
	
	public DmoocUserService(TeacherDao teacherDao,HttpSession session) {
		this.teacherDao = teacherDao;
		this.session = session;
	}
	/* 
     * 根据用户名加载认证用户
     */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<TeacherModel> result = teacherDao.getTeacherByUsername(username);
		if(result.size()==0)
			throw new UsernameNotFoundException(username+"不存在");
		else{
			TeacherModel teacher = result.get(0);
			String password = teacher.getPassword()+session.getAttribute("verifyCode");
			teacher.setPassword(password);
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			authList.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
			UserDetails userDetails = new User(teacher.getUsername(), teacher.getPassword(), authList);
			return userDetails;
		}
	}

}
