package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.SubjectDAO;
import com.revature.curriculummanagement.dao.SubjectDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;

public class SubjectServiceImpl implements SubjectService {
	SubjectDAO subjectDAOImpl = new SubjectDAOImpl();
	static Logger logger = Logger.getLogger("SubjectServiceImpl.class");

	public void addSubjectDetails(Subject subject) throws SQLException, IOException {
		logger.info("In subject DAO -> add method");
		subjectDAOImpl.addSubjectDetails(subject);
	}

	public void updateSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In subject DAO -> update method");
		subjectDAOImpl.updateSubjectDetails(subjectId);
	}

	public void deleteSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		logger.info("In subject DAO -> delete method");
		subjectDAOImpl.deleteSubjectDetails(subjectId);
	}

	public List<Subject> getSubjectDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In subject DAO -> get method");
		return subjectDAOImpl.getSubjectDetails();
	}

	public List<Subject> getParticularSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		logger.info("In subject DAO -> get particular subject details method");
		return subjectDAOImpl.getParticularSubjectDetails(subjectId);
	}

	public void getSubjectStatus(Integer subjectId) {
		logger.info("In subject DAO -> get subject status method");
		subjectDAOImpl.getSubjectStatus(subjectId);
	}
}
