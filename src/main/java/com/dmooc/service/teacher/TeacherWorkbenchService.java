package com.dmooc.service.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.dmooc.dao.ScheduleDao;
import com.dmooc.data.AppointMentData;
import com.dmooc.model.AppointMentModel;
import com.dmooc.populate.AppointmentPopulate;

public class TeacherWorkbenchService {

	@Autowired  
	private HttpSession session;
	
	@Autowired 
	private ScheduleDao scheduleDao;
	
	@Autowired
	private AppointmentPopulate appointmentPopulate;
	
	public List<AppointMentData> getScheduleByCurrentTeacher(){
		if(session==null){
			return null;
		}
		
		String name = (String) session.getAttribute("name");
		if(name==null){
			return null;
		}
		
		List<AppointMentData> result = new ArrayList<>();
		List<AppointMentModel> appoints = scheduleDao.getAppoinmentsByTeacherName(name);
		if(appoints==null || appoints.size()==0){
			return null;
		}
		
		appoints.stream().forEach(appointMentModel->{
			AppointMentData appointMentData = new AppointMentData();
			appointmentPopulate.populate(appointMentModel, appointMentData);
			result.add(appointMentData);
		});
		
		return result;
	}
}
