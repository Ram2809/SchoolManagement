package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.TeacherDetails;

public interface TeacherAssignService {
	void addTeacherAssignDetails(TeacherDetails teacherDetails);

	List<TeacherDetails> getTeacherAssignDetails();

	void updateTeacherAssignDetails(Integer teacherId) throws BusinessServiceException;

	void deleteTeacherAssignDetails(Integer teacherId) throws BusinessServiceException;

	List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws BusinessServiceException;
}
