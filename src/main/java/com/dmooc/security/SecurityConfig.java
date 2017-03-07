package com.dmooc.security;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.dmooc.dao.TeacherDao;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired  
	HttpSession session;
	/*
	 * 通过重载，配置user-detail服务
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("nimda").roles("TEACHER","ADMIN");
		auth.userDetailsService(new DmoocUserService(teacherDao,session));
	}
	
	/*
	 * 通过重载，配置如何通过拦截器保护请求
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/teacher/registerPage","/teacher/register","/teacher/getVerifyCodeImg","/teacher/verifyCode","/teacher/addData","/android/**").permitAll()
			.antMatchers("/teacher/**").access("hasRole('TEACHER')")
		  	.and().formLogin().loginPage("/login").defaultSuccessUrl("/teacher/homepage")
		  	.usernameParameter("username").passwordParameter("password")
	        .and().exceptionHandling().accessDeniedPage("/login")
	    	.and().csrf();
	}
	
	/*
	 * 通过重载，配置spring security的filter链
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

}
