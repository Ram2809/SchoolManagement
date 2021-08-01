package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.dao.SubjectDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;

public class SubjectServiceImpl implements SubjectService {
	SubjectDAOImpl subjectDAOImpl = new SubjectDAOImpl();

	public void addSubjectDetails(Subject subject) throws SQLException, IOException {
		subjectDAOImpl.addSubjectDetails(subject);
	}

	public void updateSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		subjectDAOImpl.updateSubjectDetails(subjectId);
	}

	public void deleteSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		subjectDAOImpl.deleteSubjectDetails(subjectId);
	}

	public List<Subject> getSubjectDetails() throws NumberFormatException, IOException, SQLException {
		return subjectDAOImpl.getSubjectDetails();
	}

	public List<Subject> getParticularSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		return subjectDAOImpl.getParticularSubjectDetails(subjectId);
	}

	public void getSubjectStatus(Integer subjectId) {
		subjectDAOImpl.getSubjectStatus(subjectId);
	}
}
