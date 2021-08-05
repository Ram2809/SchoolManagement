package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.service.StudentService;
import com.revature.curriculummanagement.service.StudentServiceImpl;

public class StudentController {
	StudentService studentServiceImpl = new StudentServiceImpl();
	static Logger logger = Logger.getLogger("StudentController.class");

	public void addStudentDetails(Student student) throws SQLException, IOException {
		logger.info("In student service -> add method");
		studentServiceImpl.addStudentDetails(student);
	}

	public List<Student> getStudentDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In student service -> get method");
		return studentServiceImpl.getStudentDetails();
	}

	public void updateStudentDetails(Integer id)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In student service -> update method");
		studentServiceImpl.updateStudentDetails(id);
	}

	public void deleteStudentDetails(Integer id)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		logger.info("In student service -> delete method");
		studentServiceImpl.deleteStudentDetails(id);
	}

	public List<Student> getParticularStudentDetails(Integer id)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		logger.info("In student service -> get particular student details method");
		return studentServiceImpl.getParticularStudentDetails(id);
	}

	public void getStudentDetailsByClassRoom(Integer roomNo) {
		logger.info("In student service -> get student details by class room method");
		studentServiceImpl.getStudentDetailsByClassRoom(roomNo);
	}
}
