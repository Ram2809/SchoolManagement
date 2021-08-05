package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;
import com.revature.curriculummanagement.service.TeacherAssignService;
import com.revature.curriculummanagement.service.TeacherAssignServiceImpl;

public class TeacherAssignController {
	TeacherAssignService teacherAssignServiceImpl = new TeacherAssignServiceImpl();
	static Logger logger = Logger.getLogger("TeacherAssignController.class");

	public void addTeacherAssignDetails(TeacherDetails teacherDetails) throws SQLException, IOException {
		logger.info("In teacher assign service -> add method");
		teacherAssignServiceImpl.addTeacherAssignDetails(teacherDetails);
	}

	public List<TeacherDetails> getTeacherAssignDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In teacher assign service -> get method");
		return teacherAssignServiceImpl.getTeacherAssignDetails();
	}

	public void updateTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In teacher assign service -> update method");
		teacherAssignServiceImpl.updateTeacherAssignDetails(teacherId);
	}

	public void deleteTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		logger.info("In teacher assign service -> delete method");
		teacherAssignServiceImpl.deleteTeacherAssignDetails(teacherId);
	}

	public List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws NumberFormatException,
			IOException, SQLException, StudentNotFoundException, TeacherNotFoundException {
		logger.info("In teacher assign service -> get particular teacher assign details method");
		return teacherAssignServiceImpl.getParticularTeacherAssignDetails(teacherId);
	}
}
