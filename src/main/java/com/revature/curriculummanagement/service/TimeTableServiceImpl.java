package com.revature.curriculummanagement.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TimeTableDAO;
import com.revature.curriculummanagement.dao.TimeTableDAOImpl;
import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.TimeTable;

public class TimeTableServiceImpl implements TimeTableService {
	TimeTableDAO timeTableDAOImpl = new TimeTableDAOImpl();
	static Logger logger = Logger.getLogger("TimeTableServiceImpl.class");

	public void addTimeTableDetails() throws BusinessServiceException {
		logger.info("In time table DAO -> add method");
		try {
			timeTableDAOImpl.addTimeTableDetails();
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void updateTimeTableDetails(Integer classId, String day) throws BusinessServiceException {
		logger.info("In time table DAO -> update method");
		try {
			timeTableDAOImpl.updateTimeTableDetails(classId, day);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void deleteTimeTableDetails(Integer classId, String day) throws BusinessServiceException {
		logger.info("In time table DAO -> delete method");
		try {
			timeTableDAOImpl.deleteTimeTableDetails(classId, day);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public List<TimeTable> getTimeTableDetails() {
		logger.info("In time table DAO -> get method");
		return timeTableDAOImpl.getTimeTableDetails();
	}

	public List<TimeTable> getParticularTimeTableDetails(Integer classId, String day) throws BusinessServiceException {
		logger.info("In time table DAO -> get particular time table details method");
		try {
			return timeTableDAOImpl.getParticularTimeTableDetails(classId, day);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void getTimeTableByclassRoom(Integer roomNo) throws BusinessServiceException {
		logger.info("In time table DAO -> get time table by class room method");
		try {
			timeTableDAOImpl.getTimeTableByclassRoom(roomNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}

	}

	public void getTimeTableByclassStandard(Integer roomNo) throws BusinessServiceException {
		logger.info("In time table DAO -> get time table by standard method");
		try {
			timeTableDAOImpl.getTimeTableByclassStandard(roomNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

}
