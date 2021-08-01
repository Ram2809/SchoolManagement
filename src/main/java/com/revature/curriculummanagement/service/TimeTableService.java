package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.TimeTable;

public interface TimeTableService {
	void addTimeTableDetails() throws NumberFormatException, IOException;

	void updateTimeTableDetails(Integer classId, String day);

	void deleteTimeTableDetails(Integer classId, String day);

	List<TimeTable> getTimeTableDetails() throws NumberFormatException, IOException, SQLException;

	List<TimeTable> getParticularTimeTableDetails(Integer teacherId, String day)
			throws NumberFormatException, IOException, SQLException;

	void getTimeTableByclassRoom(Integer roomNo);

	void getTimeTableByclassStandard(Integer roomNo);
}
