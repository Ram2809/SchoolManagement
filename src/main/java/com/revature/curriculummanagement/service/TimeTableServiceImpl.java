package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TimeTableDAOImpl;
import com.revature.curriculummanagement.model.TimeTable;

public class TimeTableServiceImpl implements TimeTableService {
	TimeTableDAOImpl timeTableDAOImpl = new TimeTableDAOImpl();
	static Logger logger = Logger.getLogger("TimeTableServiceImpl.class");

	public void addTimeTableDetails() throws NumberFormatException, IOException {
		logger.info("In time table DAO -> add method");
		timeTableDAOImpl.addTimeTableDetails();
	}

	public void updateTimeTableDetails(Integer classId, String day) {
		logger.info("In time table DAO -> update method");
		timeTableDAOImpl.updateTimeTableDetails(classId, day);
	}

	public void deleteTimeTableDetails(Integer classId, String day) {
		logger.info("In time table DAO -> delete method");
		timeTableDAOImpl.deleteTimeTableDetails(classId, day);
	}

	public List<TimeTable> getTimeTableDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In time table DAO -> get method");
		return timeTableDAOImpl.getTimeTableDetails();
	}

	public List<TimeTable> getParticularTimeTableDetails(Integer classId, String day)
			throws NumberFormatException, IOException, SQLException {
		logger.info("In time table DAO -> get particular time table details method");
		return timeTableDAOImpl.getParticularTimeTableDetails(classId, day);
	}

	public void getTimeTableByclassRoom(Integer roomNo) {
		logger.info("In time table DAO -> get time table by class room method");
		timeTableDAOImpl.getTimeTableByclassRoom(roomNo);

	}

	public void getTimeTableByclassStandard(Integer roomNo) {
		logger.info("In time table DAO -> get time table by standard method");
		timeTableDAOImpl.getTimeTableByclassStandard(roomNo);
	}

}
