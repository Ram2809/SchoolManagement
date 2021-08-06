package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;

public interface SubjectDAO {
	void addSubjectDetails(Subject subject);

	void updateSubjectDetails(Integer subjectId) throws DatabaseException;

	void deleteSubjectDetails(Integer subjectId) throws DatabaseException;

	List<Subject> getSubjectDetails();

	List<Subject> getParticularSubjectDetails(Integer subjectId) throws DatabaseException;

	void getSubjectStatus(Integer subjectId);
}
