package com.revature.curriculummanagement.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TeacherDAO;
import com.revature.curriculummanagement.dao.TeacherDAOImpl;
import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.Teacher;

public class TeacherServiceImpl implements TeacherService {
	TeacherDAO teacherDAOImpl = new TeacherDAOImpl();
	static Logger logger = Logger.getLogger("TeacherServiceImpl.class");

	public void addTeacherDetails(Teacher teacher) {
		logger.info("In teacher DAO -> add method");
		teacherDAOImpl.addTeacherDetails(teacher);
	}

	public void updateTeacherDetails(Integer id) throws BusinessServiceException {
		logger.info("In teacher DAO -> update method");
		try {
			teacherDAOImpl.updateTeacherDetails(id);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void deleteTeacherDetails(Integer id) throws BusinessServiceException {
		logger.info("In teacher DAO -> delete method");
		try {
			teacherDAOImpl.deleteTeacherDetails(id);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public List<Teacher> getTeacherDetails() {
		logger.info("In teacher DAO -> get method");
		return teacherDAOImpl.getTeacherDetails();
	}

	public List<Teacher> getParticularTeacherDetails(Integer id) throws BusinessServiceException {
		logger.info("In teacher DAO -> get particular teacher details method");
		try {
			return teacherDAOImpl.getParticularTeacherDetails(id);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void getTeacherDetailsByClassRoom(Integer roomNo) throws BusinessServiceException {
		logger.info("In teacher DAO -> get teacher details by class room method");
		try {
			teacherDAOImpl.getTeacherDetailsByClassRoom(roomNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	@Override
	public void getTeacherDetailsBySubjectName(String subjectName) throws BusinessServiceException {
		logger.info("In teacher DAO -> get teacher details by subject name method");
		try {
			teacherDAOImpl.getTeacherDetailsBySubjectName(subjectName);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}

	}

}
