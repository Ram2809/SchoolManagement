package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TeacherDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Teacher;

public class TeacherServiceImpl implements TeacherService {
	TeacherDAOImpl teacherDAOImpl = new TeacherDAOImpl();
	static Logger logger = Logger.getLogger("TeacherServiceImpl.class");

	public void addTeacherDetails(Teacher teacher) {
		logger.info("In teacher DAO -> add method");
		teacherDAOImpl.addTeacherDetails(teacher);
	}

	public void updateTeacherDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In teacher DAO -> update method");
		teacherDAOImpl.updateTeacherDetails(updateId);
	}

	public void deleteTeacherDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		logger.info("In teacher DAO -> delete method");
		teacherDAOImpl.deleteTeacherDetails(deleteId);
	}

	public List<Teacher> getTeacherDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In teacher DAO -> get method");
		return teacherDAOImpl.getTeacherDetails();
	}

	public List<Teacher> getParticularTeacherDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		logger.info("In teacher DAO -> get particular teacher details method");
		return teacherDAOImpl.getParticularTeacherDetails(fetchId);
	}

	public void getTeacherDetailsByClassRoom(Integer roomNo) {
		logger.info("In teacher DAO -> get teacher details by class room method");
		teacherDAOImpl.getTeacherDetailsByClassRoom(roomNo);
	}

}
