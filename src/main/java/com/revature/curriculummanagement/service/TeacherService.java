package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.Teacher;

public interface TeacherService {
	void addTeacherDetails(Teacher teacher);

	List<Teacher> getTeacherDetails();

	void updateTeacherDetails(Integer id) throws BusinessServiceException;

	void deleteTeacherDetails(Integer id) throws BusinessServiceException;

	List<Teacher> getParticularTeacherDetails(Integer id) throws BusinessServiceException;

	void getTeacherDetailsByClassRoom(Integer roomNo) throws BusinessServiceException;

	void getTeacherDetailsBySubjectName(String subjectName) throws BusinessServiceException;
}
