package com.revature.curriculummanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.model.TeacherDetails;
import com.revature.curriculummanagement.service.TeacherAssignService;
import com.revature.curriculummanagement.service.TeacherAssignServiceImpl;

public class TeacherAssignController {
	TeacherAssignService teacherAssignServiceImpl = new TeacherAssignServiceImpl();
	static Logger logger = Logger.getLogger("TeacherAssignController.class");

	public void addTeacherAssignDetails(TeacherDetails teacherDetails) {
		logger.info("In teacher assign service -> add method");
		teacherAssignServiceImpl.addTeacherAssignDetails(teacherDetails);
	}

	public List<TeacherDetails> getTeacherAssignDetails() {
		logger.info("In teacher assign service -> get method");
		return teacherAssignServiceImpl.getTeacherAssignDetails();
	}

	public void updateTeacherAssignDetails(Integer teacherId) throws ControllerException {
		logger.info("In teacher assign service -> update method");
		try {
			teacherAssignServiceImpl.updateTeacherAssignDetails(teacherId);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void deleteTeacherAssignDetails(Integer teacherId) throws ControllerException {
		logger.info("In teacher assign service -> delete method");
		try {
			teacherAssignServiceImpl.deleteTeacherAssignDetails(teacherId);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws ControllerException {
		logger.info("In teacher assign service -> get particular teacher assign details method");
		try {
			return teacherAssignServiceImpl.getParticularTeacherAssignDetails(teacherId);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
