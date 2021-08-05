package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;
import com.revature.curriculummanagement.service.SubjectServiceImpl;

public class SubjectController {
	SubjectServiceImpl subjectServiceImpl = new SubjectServiceImpl();
	static Logger logger = Logger.getLogger("SubjectController.class");

	public void addSubjectDetails(Subject subject) throws SQLException, IOException {
		logger.info("In subject service -> add method");
		subjectServiceImpl.addSubjectDetails(subject);
	}

	public List<Subject> getSubjectDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In subject service -> get method");
		return subjectServiceImpl.getSubjectDetails();
	}

	public void updateSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In subject service -> update method");
		subjectServiceImpl.updateSubjectDetails(subjectId);
	}

	public void deleteSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		logger.info("In subject service -> delete method");
		subjectServiceImpl.deleteSubjectDetails(subjectId);
	}

	public List<Subject> getParticularSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		logger.info("In subject service -> get particular subject details method");
		return subjectServiceImpl.getParticularSubjectDetails(subjectId);
	}

	public void getSubjectStatus(Integer subjectId) {
		logger.info("In subject service -> get subject status method");
		subjectServiceImpl.getSubjectStatus(subjectId);
	}
}
