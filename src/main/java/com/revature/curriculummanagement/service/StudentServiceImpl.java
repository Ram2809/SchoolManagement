package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.StudentDAO;
import com.revature.curriculummanagement.dao.StudentDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;

public class StudentServiceImpl implements StudentService {
	StudentDAO studentDAOImpl = new StudentDAOImpl();
	static Logger logger = Logger.getLogger("StudentServiceImpl.class");

	public void addStudentDetails(Student student) throws SQLException, IOException {
		logger.info("In student DAO -> add method");
		studentDAOImpl.addStudentDetails(student);
	}

	public void updateStudentDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In student DAO -> update method");
		studentDAOImpl.updateStudentDetails(updateId);
	}

	public void deleteStudentDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		logger.info("In student DAO -> delete method");
		studentDAOImpl.deleteStudentDetails(deleteId);
	}

	public List<Student> getStudentDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In student DAO -> get method");
		return studentDAOImpl.getStudentDetails();
	}

	public List<Student> getParticularStudentDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		logger.info("In student DAO -> get particular student details method");
		return studentDAOImpl.getParticularStudentDetails(fetchId);
	}

	public void getStudentDetailsByClassRoom(Integer roomNo) {
		logger.info("In student DAO -> get student details by class room method");
		studentDAOImpl.getStudentDetailsByClassRoom(roomNo);
	}

}