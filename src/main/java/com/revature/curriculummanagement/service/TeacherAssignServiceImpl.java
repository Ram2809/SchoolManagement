package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TeacherAssignDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;

public class TeacherAssignServiceImpl implements TeacherAssignService {
	TeacherAssignDAOImpl teacherAssignDAOImpl = new TeacherAssignDAOImpl();
	static Logger logger = Logger.getLogger("TeacherAssignServiceImpl.class");

	public void addTeacherAssignDetails(TeacherDetails teacherDetails) throws SQLException, IOException {
		logger.info("In teacher assign DAO -> add method");
		teacherAssignDAOImpl.addTeacherAssignDetails(teacherDetails);
	}

	public void updateTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In teacher assign DAO -> update method");
		teacherAssignDAOImpl.updateTeacherAssignDetails(teacherId);
	}

	public void deleteTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		logger.info("In teacher assign DAO -> delete method");
		teacherAssignDAOImpl.deleteTeacherAssignDetails(teacherId);
	}

	public List<TeacherDetails> getTeacherAssignDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In teacher assign DAO -> get method");
		return teacherAssignDAOImpl.getTeacherAssignDetails();
	}

	public List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws NumberFormatException,
			IOException, SQLException, StudentNotFoundException, TeacherNotFoundException {
		logger.info("In teacher assign DAO -> get particular teacher assign details method");
		return teacherAssignDAOImpl.getParticularTeacherAssignDetails(teacherId);
	}

}
