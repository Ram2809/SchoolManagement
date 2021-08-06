package com.revature.curriculummanagement.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TeacherAssignDAO;
import com.revature.curriculummanagement.dao.TeacherAssignDAOImpl;
import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.TeacherDetails;

public class TeacherAssignServiceImpl implements TeacherAssignService {
	TeacherAssignDAO teacherAssignDAOImpl = new TeacherAssignDAOImpl();
	static Logger logger = Logger.getLogger("TeacherAssignServiceImpl.class");

	public void addTeacherAssignDetails(TeacherDetails teacherDetails) {
		logger.info("In teacher assign DAO -> add method");
		teacherAssignDAOImpl.addTeacherAssignDetails(teacherDetails);
	}

	public void updateTeacherAssignDetails(Integer teacherId) throws BusinessServiceException {
		logger.info("In teacher assign DAO -> update method");
		try {
			teacherAssignDAOImpl.updateTeacherAssignDetails(teacherId);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void deleteTeacherAssignDetails(Integer teacherId) throws BusinessServiceException {
		logger.info("In teacher assign DAO -> delete method");
		try {
			teacherAssignDAOImpl.deleteTeacherAssignDetails(teacherId);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public List<TeacherDetails> getTeacherAssignDetails() {
		logger.info("In teacher assign DAO -> get method");
		return teacherAssignDAOImpl.getTeacherAssignDetails();
	}

	public List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws BusinessServiceException {
		logger.info("In teacher assign DAO -> get particular teacher assign details method");
		try {
			return teacherAssignDAOImpl.getParticularTeacherAssignDetails(teacherId);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

}
