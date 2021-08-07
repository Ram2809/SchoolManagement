package com.revature.curriculummanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.model.TimeTable;
import com.revature.curriculummanagement.service.TimeTableService;
import com.revature.curriculummanagement.service.TimeTableServiceImpl;

public class TimeTableController {
	TimeTableService timeTableServiceImpl = new TimeTableServiceImpl();
	static Logger logger = Logger.getLogger("TimeTableController.class");

	public void addTimeTableDetails() throws ControllerException {
		logger.info("In time table service -> add method");
		try {
			timeTableServiceImpl.addTimeTableDetails();
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void updateTimeTableDetails(Integer classId, String day) throws ControllerException {
		logger.info("In time table service -> update method");
		try {
			timeTableServiceImpl.updateTimeTableDetails(classId, day);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void deleteTimeTableDetails(Integer classId, String day) throws ControllerException {
		logger.info("In time table service -> delete method");
		try {
			timeTableServiceImpl.deleteTimeTableDetails(classId, day);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public List<TimeTable> getTimeTableDetails() {
		logger.info("In time table service -> get method");
		return timeTableServiceImpl.getTimeTableDetails();
	}

	public List<TimeTable> getParticularTimeTableDetails(Integer teacherId, String day) throws ControllerException {
		logger.info("In time table service -> get particular time table details method");
		try {
			return timeTableServiceImpl.getParticularTimeTableDetails(teacherId, day);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void getTimeTableByclassRoom(Integer roomNo) throws ControllerException {
		logger.info("In time table service -> get time table for specific class room method");
		try {
			timeTableServiceImpl.getTimeTableByclassRoom(roomNo);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void getTimeTableByclassStandard(Integer roomNo) throws ControllerException {
		logger.info("In time table service -> get time table for specific standard method");
		try {
			timeTableServiceImpl.getTimeTableByclassStandard(roomNo);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
