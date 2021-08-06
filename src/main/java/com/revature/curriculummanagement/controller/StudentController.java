package com.revature.curriculummanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.service.StudentService;
import com.revature.curriculummanagement.service.StudentServiceImpl;

public class StudentController {
	StudentService studentServiceImpl = new StudentServiceImpl();
	static Logger logger = Logger.getLogger("StudentController.class");

	public void addStudentDetails(Student student) {
		logger.info("In student service -> add method");
		studentServiceImpl.addStudentDetails(student);
	}

	public List<Student> getStudentDetails() {
		logger.info("In student service -> get method");
		return studentServiceImpl.getStudentDetails();
	}

	public void updateStudentDetails(Integer id) throws ControllerException {
		logger.info("In student service -> update method");
		try {
			studentServiceImpl.updateStudentDetails(id);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void deleteStudentDetails(Integer id) throws ControllerException {
		logger.info("In student service -> delete method");
		try {
			studentServiceImpl.deleteStudentDetails(id);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public List<Student> getParticularStudentDetails(Integer id) throws ControllerException {
		logger.info("In student service -> get particular student details method");
		try {
			return studentServiceImpl.getParticularStudentDetails(id);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void getStudentDetailsByClassRoom(Integer roomNo) {
		logger.info("In student service -> get student details by class room method");
		studentServiceImpl.getStudentDetailsByClassRoom(roomNo);
	}
}
