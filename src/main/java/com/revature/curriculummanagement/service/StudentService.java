package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.Student;

public interface StudentService {
	void addStudentDetails(Student student);

	List<Student> getStudentDetails();

	void updateStudentDetails(Integer id) throws BusinessServiceException;

	void deleteStudentDetails(Integer id) throws BusinessServiceException;

	List<Student> getParticularStudentDetails(Integer id) throws BusinessServiceException;

	void getStudentDetailsByClassRoom(Integer roomNo);
}
