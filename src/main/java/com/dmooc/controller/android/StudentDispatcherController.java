package com.dmooc.controller.android;

import com.dmooc.model.TeacherModel;
import com.dmooc.service.android.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by KunLiu on 2017/2/14.
 */

@Controller
@RequestMapping("/android/student")
public class StudentDispatcherController {
	
	@Autowired
	TeacherService teacherService;
	
    @RequestMapping(value = "/getTeacherList", method = RequestMethod.GET)
    @ResponseBody
    public List<TeacherModel> GetTeacherList() {
       return teacherService.getTeachers();
    }

    @RequestMapping(value = "/getTeacherInfo", method = RequestMethod.GET)
    @ResponseBody
    public TeacherModel GetTeacherInfo(@RequestParam(value = "teacherId", required = false) String teacherId) {
       return teacherService.getTeacher(teacherId);
    }

    @RequestMapping(value = "/queryTeachers", method = RequestMethod.GET)
    @ResponseBody
    public List<TeacherModel> QueryTeachers(@RequestParam(value = "grade", required = false) String grade,
                                @RequestParam(value = "subject", required = false) String subject) {
        return teacherService.getTeacherByCondition(grade,subject);
    }
}
