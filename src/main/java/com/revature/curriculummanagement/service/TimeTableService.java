package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.TimeTable;

public interface TimeTableService {
	void addTimeTableDetails();

	void updateTimeTableDetails(Integer classId, String day) throws BusinessServiceException;

	void deleteTimeTableDetails(Integer classId, String day);

	List<TimeTable> getTimeTableDetails();

	List<TimeTable> getParticularTimeTableDetails(Integer teacherId, String day);

	void getTimeTableByclassRoom(Integer roomNo);

	void getTimeTableByclassStandard(Integer roomNo);
}
