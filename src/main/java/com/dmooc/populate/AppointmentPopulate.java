package com.dmooc.populate;

import com.dmooc.data.AppointMentData;
import com.dmooc.model.AppointMentModel;

public class AppointmentPopulate {

	public void populate(AppointMentModel source, AppointMentData target){
		target.setUrl(null);
		target.setTitle(source.getSubject());
		
		String timer = source.getClass_time();
		String[] classTime = timer.split(" ");
		String prefix = classTime[0];
		String suffix = classTime[1];
		String[] sustain = suffix.split("-");
		String startTime = prefix + " " + sustain[0];
		String endTime = prefix + " " + sustain[1];
		target.setStartTime(startTime);
		target.setEndTime(endTime);
	}
}
