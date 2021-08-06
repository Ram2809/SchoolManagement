package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.StudentDAO;
import com.revature.curriculummanagement.dao.StudentDAOImpl;
import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;

public class StudentServiceImpl implements StudentService {
	StudentDAO studentDAOImpl = new StudentDAOImpl();
	static Logger logger = Logger.getLogger("StudentServiceImpl.class");

	public void addStudentDetails(Student student) {
		logger.info("In student DAO -> add method");
		studentDAOImpl.addStudentDetails(student);
	}

	public void updateStudentDetails(Integer id) throws BusinessServiceException {
		logger.info("In student DAO -> update method");
		try {
			studentDAOImpl.updateStudentDetails(id);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void deleteStudentDetails(Integer id) throws BusinessServiceException {
		logger.info("In student DAO -> delete method");
		try {
			studentDAOImpl.deleteStudentDetails(id);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public List<Student> getStudentDetails() {
		logger.info("In student DAO -> get method");
		return studentDAOImpl.getStudentDetails();
	}

	public List<Student> getParticularStudentDetails(Integer id) throws BusinessServiceException {
		logger.info("In student DAO -> get particular student details method");
		try {
			return studentDAOImpl.getParticularStudentDetails(id);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void getStudentDetailsByClassRoom(Integer roomNo) {
		logger.info("In student DAO -> get student details by class room method");
		studentDAOImpl.getStudentDetailsByClassRoom(roomNo);
	}

}