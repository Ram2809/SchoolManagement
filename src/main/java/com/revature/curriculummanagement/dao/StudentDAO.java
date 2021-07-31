package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.model.Student;

public interface StudentDAO {
	void addStudentDetails(Student student) throws SQLException, IOException;

	void updateStudentDetails(Integer updateId) throws SQLException, IOException;

	void deleteStudentDetails(Integer deleteId) throws SQLException, IOException, StudentNotFoundException;

	List<Student> getStudentDetails() throws SQLException, IOException;

	List<Student> getParticularStudentDetails(Integer fetchId)
			throws SQLException, IOException, StudentNotFoundException;
}
