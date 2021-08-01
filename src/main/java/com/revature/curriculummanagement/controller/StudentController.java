package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.service.StudentServiceImpl;

public class StudentController {
	StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

	public void addStudentDetails(Student student) throws SQLException, IOException {
		studentServiceImpl.addStudentDetails(student);
	}

	public List<Student> getStudentDetails() throws NumberFormatException, IOException, SQLException {
		return studentServiceImpl.getStudentDetails();
	}

	public void updateStudentDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		studentServiceImpl.updateStudentDetails(updateId);
	}

	public void deleteStudentDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		studentServiceImpl.deleteStudentDetails(deleteId);
	}

	public List<Student> getParticularStudentDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		return studentServiceImpl.getParticularStudentDetails(fetchId);
	}

	public void getStudentDetailsByClassRoom(Integer roomNo) {
		studentServiceImpl.getStudentDetailsByClassRoom(roomNo);
	}
}
