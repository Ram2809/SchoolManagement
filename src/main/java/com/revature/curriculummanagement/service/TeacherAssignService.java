package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;

public interface TeacherAssignService {
	void addTeacherAssignDetails(TeacherDetails teacherDetails);

	List<TeacherDetails> getTeacherAssignDetails();

	void updateTeacherAssignDetails(Integer teacherId) throws BusinessServiceException;

	void deleteTeacherAssignDetails(Integer teacherId) throws BusinessServiceException;

	List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws BusinessServiceException;
}
