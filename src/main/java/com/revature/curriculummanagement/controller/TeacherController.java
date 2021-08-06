package com.revature.curriculummanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.model.Teacher;
import com.revature.curriculummanagement.service.TeacherService;
import com.revature.curriculummanagement.service.TeacherServiceImpl;

public class TeacherController {
	TeacherService teacherServiceImpl = new TeacherServiceImpl();
	static Logger logger = Logger.getLogger("TeacherController.class");

	public void addTeacherDetails(Teacher teacher) {
		logger.info("In teacher service -> add method");
		teacherServiceImpl.addTeacherDetails(teacher);
	}

	public List<Teacher> getTeacherDetails() {
		logger.info("In teacher service -> get method");
		return teacherServiceImpl.getTeacherDetails();
	}

	public void updateTeacherDetails(Integer id) throws ControllerException {
		logger.info("In teacher service -> update method");
		try {
			teacherServiceImpl.updateTeacherDetails(id);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void deleteTeacherDetails(Integer id) throws ControllerException {
		logger.info("In teacher service -> delete method");
		try {
			teacherServiceImpl.deleteTeacherDetails(id);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public List<Teacher> getParticularTeacherDetails(Integer id) throws ControllerException {
		logger.info("In teacher service -> get particular teacher details method");
		try {
			return teacherServiceImpl.getParticularTeacherDetails(id);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void getTeacherDetailsByClassRoom(Integer roomNo) {
		logger.info("In teacher service -> get teacher details by class room method");
		teacherServiceImpl.getTeacherDetailsByClassRoom(roomNo);
	}
}
