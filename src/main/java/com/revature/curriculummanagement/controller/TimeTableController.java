package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.TimeTable;
import com.revature.curriculummanagement.service.TimeTableServiceImpl;

public class TimeTableController {
	TimeTableServiceImpl timeTableServiceImpl = new TimeTableServiceImpl();

	public void addTimeTableDetails() throws NumberFormatException, IOException {
		timeTableServiceImpl.addTimeTableDetails();
	}

	public void updateTimeTableDetails(Integer classId, String day) {
		timeTableServiceImpl.updateTimeTableDetails(classId, day);
	}

	public void deleteTimeTableDetails(Integer classId, String day) {
		timeTableServiceImpl.deleteTimeTableDetails(classId, day);
	}

	public List<TimeTable> getTimeTableDetails() throws NumberFormatException, IOException, SQLException {
		return timeTableServiceImpl.getTimeTableDetails();
	}

	public List<TimeTable> getParticularTimeTableDetails(Integer teacherId, String day)
			throws NumberFormatException, IOException, SQLException {
		return timeTableServiceImpl.getParticularTimeTableDetails(teacherId, day);
	}

	public void getTimeTableByclassRoom(Integer roomNo) {
		timeTableServiceImpl.getTimeTableByclassRoom(roomNo);
	}

	public void getTimeTableByclassStandard(Integer roomNo) {
		timeTableServiceImpl.getTimeTableByclassStandard(roomNo);
	}
}
