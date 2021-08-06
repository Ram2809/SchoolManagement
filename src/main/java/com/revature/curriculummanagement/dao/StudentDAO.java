package com.revature.curriculummanagement.dao;

import java.util.List;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.Student;

public interface StudentDAO {
	void addStudentDetails(Student student);

	void updateStudentDetails(Integer id) throws DatabaseException;

	void deleteStudentDetails(Integer id) throws DatabaseException;

	List<Student> getStudentDetails();

	List<Student> getParticularStudentDetails(Integer id) throws DatabaseException;

	void getStudentDetailsByClassRoom(Integer roomNo);
}
