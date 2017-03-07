package com.dmooc.validate;

import java.util.HashMap;
import java.util.Map;

import com.dmooc.data.TeacherLoginAndRegisterData;

public class LoginAndRegisterValidate {
	private final String EMPTY_ERROR = "不可为空,不能包含空格";
	private final String PASSWORD_NOT_SAME_ERROR = "两次输入的密码不相同";

	public Map<String,String> validate(TeacherLoginAndRegisterData  registerData){
		Map<String,String> result = new HashMap<>();
		//非空判断
		if(registerData.getUsername().trim()=="" || registerData.getUsername().contains(" "))
			result.put("username", EMPTY_ERROR);
		if(registerData.getPassword().trim()=="" || registerData.getPassword().contains(" "))
			result.put("password", EMPTY_ERROR);
		if(registerData.getPassword2().trim()=="" || registerData.getPassword2().contains(" "))
			result.put("password2", EMPTY_ERROR);
		if(registerData.getMobile().trim()=="" || registerData.getMobile().contains(" "))
			result.put("mobile", EMPTY_ERROR);
		//逻辑判断
		if(!registerData.getPassword().equals(registerData.getPassword2()))
			result.put("password2", PASSWORD_NOT_SAME_ERROR);
		return result;
	}
}
