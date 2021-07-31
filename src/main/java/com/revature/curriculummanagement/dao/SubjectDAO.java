package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;

public interface SubjectDAO {
	void addSubjectDetails(Subject subject) throws SQLException, IOException;

	void updateSubjectDetails(Integer subjectId) throws SQLException, IOException;

	void deleteSubjectDetails(Integer subjectId) throws SQLException, IOException, SubjectNotFoundException;

	List<Subject> getSubjectDetails() throws SQLException, IOException;

	List<Subject> getParticularSubjectDetails(Integer subjectId)
			throws SQLException, IOException, SubjectNotFoundException;
}
