package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;

public interface StudentService {
	void addStudentDetails(Student student);

	List<Student> getStudentDetails();

	void updateStudentDetails(Integer id) throws BusinessServiceException;

	void deleteStudentDetails(Integer id) throws BusinessServiceException;

	List<Student> getParticularStudentDetails(Integer id) throws BusinessServiceException;

	void getStudentDetailsByClassRoom(Integer roomNo);
}
