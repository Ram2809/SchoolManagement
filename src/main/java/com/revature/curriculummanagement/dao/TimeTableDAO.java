package com.revature.curriculummanagement.dao;

import java.util.List;

import com.revature.curriculummanagement.model.TimeTable;

public interface TimeTableDAO {
	void addTimeTableDetails();

	void updateTimeTableDetails(Integer classId, String day);

	void deleteTimeTableDetails(Integer classId, String day);

	List<TimeTable> getTimeTableDetails();

	List<TimeTable> getParticularTimeTableDetails(Integer classId, String day);

	void getTimeTableByclassRoom(Integer roomNo);

	void getTimeTableByclassStandard(Integer roomNo);
}
