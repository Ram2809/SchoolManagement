package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.Subject;

public interface SubjectService {
	void addSubjectDetails(Subject subject);

	List<Subject> getSubjectDetails();

	void updateSubjectDetails(Integer subjectId) throws BusinessServiceException;

	void deleteSubjectDetails(Integer subjectId) throws BusinessServiceException;

	List<Subject> getParticularSubjectDetails(Integer subjectId) throws BusinessServiceException;

	void getSubjectStatus(Integer subjectId) throws BusinessServiceException;
}
