package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.TimeTable;

public interface TimeTableService {
	void addTimeTableDetails() throws BusinessServiceException;

	void updateTimeTableDetails(Integer classId, String day) throws BusinessServiceException;

	void deleteTimeTableDetails(Integer classId, String day) throws BusinessServiceException;

	List<TimeTable> getTimeTableDetails();

	List<TimeTable> getParticularTimeTableDetails(Integer teacherId, String day) throws BusinessServiceException;

	void getTimeTableByclassRoom(Integer roomNo) throws BusinessServiceException;

	void getTimeTableByclassStandard(Integer roomNo) throws BusinessServiceException;
}
