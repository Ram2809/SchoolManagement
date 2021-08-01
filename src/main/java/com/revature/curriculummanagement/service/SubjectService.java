package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;

public interface SubjectService {
	void addSubjectDetails(Subject subject) throws SQLException, IOException;

	List<Subject> getSubjectDetails() throws NumberFormatException, IOException, SQLException;

	void updateSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException;

	void deleteSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException;

	List<Subject> getParticularSubjectDetails(Integer subjectId)
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException;

	void getSubjectStatus(Integer subjectId);
}
