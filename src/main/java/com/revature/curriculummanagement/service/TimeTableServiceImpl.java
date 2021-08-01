package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.dao.TimeTableDAOImpl;
import com.revature.curriculummanagement.model.TimeTable;

public class TimeTableServiceImpl implements TimeTableService {
	TimeTableDAOImpl timeTableDAOImpl = new TimeTableDAOImpl();

	public void addTimeTableDetails() throws NumberFormatException, IOException {
		timeTableDAOImpl.addTimeTableDetails();
	}

	public void updateTimeTableDetails(Integer classId, String day) {
		timeTableDAOImpl.updateTimeTableDetails(classId, day);
	}

	public void deleteTimeTableDetails(Integer classId, String day) {
		timeTableDAOImpl.deleteTimeTableDetails(classId, day);
	}

	public List<TimeTable> getTimeTableDetails() throws NumberFormatException, IOException, SQLException {
		return timeTableDAOImpl.getTimeTableDetails();
	}

	public List<TimeTable> getParticularTimeTableDetails(Integer classId, String day)
			throws NumberFormatException, IOException, SQLException {
		return timeTableDAOImpl.getParticularTimeTableDetails(classId, day);
	}

	public void getTimeTableByclassRoom(Integer roomNo) {
		timeTableDAOImpl.getTimeTableByclassRoom(roomNo);

	}

	public void getTimeTableByclassStandard(Integer roomNo) {
		timeTableDAOImpl.getTimeTableByclassStandard(roomNo);
	}

}
