package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.SubjectDAO;
import com.revature.curriculummanagement.dao.SubjectDAOImpl;
import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;

public class SubjectServiceImpl implements SubjectService {
	SubjectDAO subjectDAOImpl = new SubjectDAOImpl();
	static Logger logger = Logger.getLogger("SubjectServiceImpl.class");

	public void addSubjectDetails(Subject subject) {
		logger.info("In subject DAO -> add method");
		subjectDAOImpl.addSubjectDetails(subject);
	}

	public void updateSubjectDetails(Integer subjectId) throws BusinessServiceException {
		logger.info("In subject DAO -> update method");
		try {
			subjectDAOImpl.updateSubjectDetails(subjectId);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void deleteSubjectDetails(Integer subjectId) throws BusinessServiceException {
		logger.info("In subject DAO -> delete method");
		try {
			subjectDAOImpl.deleteSubjectDetails(subjectId);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public List<Subject> getSubjectDetails() {
		logger.info("In subject DAO -> get method");
		return subjectDAOImpl.getSubjectDetails();
	}

	public List<Subject> getParticularSubjectDetails(Integer subjectId) throws BusinessServiceException {
		logger.info("In subject DAO -> get particular subject details method");
		try {
			return subjectDAOImpl.getParticularSubjectDetails(subjectId);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void getSubjectStatus(Integer subjectId) {
		logger.info("In subject DAO -> get subject status method");
		subjectDAOImpl.getSubjectStatus(subjectId);
	}
}
