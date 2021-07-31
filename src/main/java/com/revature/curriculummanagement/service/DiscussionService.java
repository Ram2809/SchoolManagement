package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;

public interface DiscussionService {
	void addStudentDetails(Student student) throws SQLException, IOException;

	/*List<Student> getStudentDetails() throws NumberFormatException, IOException, SQLException;

	void updateStudentDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException;

	void deleteStudentDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException;

	List<Student> getParticularStudentDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException;*/
}
