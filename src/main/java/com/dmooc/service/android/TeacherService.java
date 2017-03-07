package com.dmooc.service.android;

import com.dmooc.dao.TeacherDao;
import com.dmooc.model.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherService {
	@Autowired
	TeacherDao teacherDao;

    public List<TeacherModel> getTeachers(){
        return teacherDao.getTeachers();
    }

    public TeacherModel getTeacher(String teacherId){
    	List<TeacherModel> result = teacherDao.getTeacherByTeacherId(teacherId);
    	if(result!=null && result.size()>0)
    		return result.get(0);
    	else 
    		return null;
    }

    /**
     * @param grade
     * @param subject
     * @return 返回符合搜索条件的教师信息
     */
	public List<TeacherModel> getTeacherByCondition(String grade, String subject) {
		
		return teacherDao.getTeacherByCondition(grade,subject);
	}

}
