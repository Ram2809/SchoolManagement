package com.revature.curriculummanagement.dao;

import java.util.List;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.TimeTable;

public interface TimeTableDAO {
	void addTimeTableDetails() throws DatabaseException;

	void updateTimeTableDetails(Integer classId, String day) throws DatabaseException;

	void deleteTimeTableDetails(Integer classId, String day) throws DatabaseException;

	List<TimeTable> getTimeTableDetails();

	List<TimeTable> getParticularTimeTableDetails(Integer classId, String day) throws DatabaseException;

	void getTimeTableByclassRoom(Integer roomNo) throws DatabaseException;

	void getTimeTableByclassStandard(Integer roomNo) throws DatabaseException;
}
