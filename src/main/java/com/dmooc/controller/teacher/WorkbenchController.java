package com.dmooc.controller.teacher;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dmooc.data.AppointMentData;
import com.dmooc.service.teacher.TeacherWorkbenchService;

@Controller
@RequestMapping("/teacher")
public class WorkbenchController {

	@Resource
	private TeacherWorkbenchService teacherWorkbenchService;
	
	@RequestMapping(value="/getSchedule",method=RequestMethod.GET)
	@ResponseBody
	public List<AppointMentData> getSchedule(){
		System.out.println("teacher wants his schedule ");
		return teacherWorkbenchService.getScheduleByCurrentTeacher();
	}
	

//	@RequestMapping(value="/getAppointments",method=RequestMethod.POST)
//	@ResponseBody
//	public List<AppointMentData>
	
}
