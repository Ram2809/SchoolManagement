package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Teacher;
import com.revature.curriculummanagement.service.TeacherService;
import com.revature.curriculummanagement.service.TeacherServiceImpl;

public class TeacherController {
	TeacherService teacherServiceImpl = new TeacherServiceImpl();
	static Logger logger = Logger.getLogger("TeacherController.class");

	public void addTeacherDetails(Teacher teacher) throws SQLException, IOException {
		logger.info("In teacher service -> add method");
		teacherServiceImpl.addTeacherDetails(teacher);
	}

	public List<Teacher> getTeacherDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In teacher service -> get method");
		return teacherServiceImpl.getTeacherDetails();
	}

	public void updateTeacherDetails(Integer id)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In teacher service -> update method");
		teacherServiceImpl.updateTeacherDetails(id);
	}

	public void deleteTeacherDetails(Integer id)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		logger.info("In teacher service -> delete method");
		teacherServiceImpl.deleteTeacherDetails(id);
	}

	public List<Teacher> getParticularTeacherDetails(Integer id)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		logger.info("In teacher service -> get particular teacher details method");
		return teacherServiceImpl.getParticularTeacherDetails(id);
	}

	public void getTeacherDetailsByClassRoom(Integer roomNo) {
		logger.info("In teacher service -> get teacher details by class room method");
		teacherServiceImpl.getTeacherDetailsByClassRoom(roomNo);
	}
}
