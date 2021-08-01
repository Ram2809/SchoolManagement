package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.TimeTable;

public interface TimeTableDAO {
	void addTimeTableDetails() throws NumberFormatException, IOException;

	void updateTimeTableDetails(Integer classId, String day);

	void deleteTimeTableDetails(Integer classId, String day);

	List<TimeTable> getTimeTableDetails() throws SQLException, IOException;

	List<TimeTable> getParticularTimeTableDetails(Integer classId, String day) throws SQLException, IOException;

	void getTimeTableByclassRoom(Integer roomNo);

	void getTimeTableByclassStandard(Integer roomNo);
}
