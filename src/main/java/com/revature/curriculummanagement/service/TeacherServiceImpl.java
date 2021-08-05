package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TeacherDAO;
import com.revature.curriculummanagement.dao.TeacherDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Teacher;

public class TeacherServiceImpl implements TeacherService {
	TeacherDAO teacherDAOImpl = new TeacherDAOImpl();
	static Logger logger = Logger.getLogger("TeacherServiceImpl.class");

	public void addTeacherDetails(Teacher teacher) {
		logger.info("In teacher DAO -> add method");
		teacherDAOImpl.addTeacherDetails(teacher);
	}

	public void updateTeacherDetails(Integer id)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In teacher DAO -> update method");
		teacherDAOImpl.updateTeacherDetails(id);
	}

	public void deleteTeacherDetails(Integer id)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		logger.info("In teacher DAO -> delete method");
		teacherDAOImpl.deleteTeacherDetails(id);
	}

	public List<Teacher> getTeacherDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In teacher DAO -> get method");
		return teacherDAOImpl.getTeacherDetails();
	}

	public List<Teacher> getParticularTeacherDetails(Integer id)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		logger.info("In teacher DAO -> get particular teacher details method");
		return teacherDAOImpl.getParticularTeacherDetails(id);
	}

	public void getTeacherDetailsByClassRoom(Integer roomNo) {
		logger.info("In teacher DAO -> get teacher details by class room method");
		teacherDAOImpl.getTeacherDetailsByClassRoom(roomNo);
	}

}
