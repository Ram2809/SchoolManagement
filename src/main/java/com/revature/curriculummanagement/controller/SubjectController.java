package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;
import com.revature.curriculummanagement.service.SubjectServiceImpl;

public class SubjectController {
	SubjectServiceImpl subjectServiceImpl = new SubjectServiceImpl();

	public void addSubjectDetails(Subject subject) throws SQLException, IOException {
		subjectServiceImpl.addSubjectDetails(subject);
	}

	public List<Subject> getSubjectDetails() throws NumberFormatException, IOException, SQLException {
		return subjectServiceImpl.getSubjectDetails();
	}

	public void updateSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		subjectServiceImpl.updateSubjectDetails(subjectId);
	}

	public void deleteSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		subjectServiceImpl.deleteSubjectDetails(subjectId);
	}

	public List<Subject> getParticularSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		return subjectServiceImpl.getParticularSubjectDetails(subjectId);
	}

	public void getSubjectStatus(Integer subjectId) {
		subjectServiceImpl.getSubjectStatus(subjectId);
	}
}
