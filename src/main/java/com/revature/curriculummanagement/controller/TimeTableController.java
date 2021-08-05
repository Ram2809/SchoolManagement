package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.TimeTable;
import com.revature.curriculummanagement.service.TimeTableServiceImpl;

public class TimeTableController {
	TimeTableServiceImpl timeTableServiceImpl = new TimeTableServiceImpl();
	static Logger logger = Logger.getLogger("TimeTableController.class");

	public void addTimeTableDetails() throws NumberFormatException, IOException {
		logger.info("In time table service -> add method");
		timeTableServiceImpl.addTimeTableDetails();
	}

	public void updateTimeTableDetails(Integer classId, String day) {
		logger.info("In time table service -> update method");
		timeTableServiceImpl.updateTimeTableDetails(classId, day);
	}

	public void deleteTimeTableDetails(Integer classId, String day) {
		logger.info("In time table service -> delete method");
		timeTableServiceImpl.deleteTimeTableDetails(classId, day);
	}

	public List<TimeTable> getTimeTableDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In time table service -> get method");
		return timeTableServiceImpl.getTimeTableDetails();
	}

	public List<TimeTable> getParticularTimeTableDetails(Integer teacherId, String day)
			throws NumberFormatException, IOException, SQLException {
		logger.info("In time table service -> get particular time table details method");
		return timeTableServiceImpl.getParticularTimeTableDetails(teacherId, day);
	}

	public void getTimeTableByclassRoom(Integer roomNo) {
		logger.info("In time table service -> get time table for specific class room method");
		timeTableServiceImpl.getTimeTableByclassRoom(roomNo);
	}

	public void getTimeTableByclassStandard(Integer roomNo) {
		logger.info("In time table service -> get time table for specific standard method");
		timeTableServiceImpl.getTimeTableByclassStandard(roomNo);
	}
}
