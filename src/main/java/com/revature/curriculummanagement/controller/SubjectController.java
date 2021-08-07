package com.revature.curriculummanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.model.Subject;
import com.revature.curriculummanagement.service.SubjectService;
import com.revature.curriculummanagement.service.SubjectServiceImpl;

public class SubjectController {
	SubjectService subjectServiceImpl = new SubjectServiceImpl();
	static Logger logger = Logger.getLogger("SubjectController.class");

	public void addSubjectDetails(Subject subject) {
		logger.info("In subject service -> add method");
		subjectServiceImpl.addSubjectDetails(subject);
	}

	public List<Subject> getSubjectDetails() {
		logger.info("In subject service -> get method");
		return subjectServiceImpl.getSubjectDetails();
	}

	public void updateSubjectDetails(Integer subjectId) throws ControllerException {
		logger.info("In subject service -> update method");
		try {
			subjectServiceImpl.updateSubjectDetails(subjectId);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void deleteSubjectDetails(Integer subjectId) throws ControllerException {
		logger.info("In subject service -> delete method");
		try {
			subjectServiceImpl.deleteSubjectDetails(subjectId);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public List<Subject> getParticularSubjectDetails(Integer subjectId) throws ControllerException {
		logger.info("In subject service -> get particular subject details method");
		try {
			return subjectServiceImpl.getParticularSubjectDetails(subjectId);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void getSubjectStatus(Integer subjectId) throws ControllerException {
		logger.info("In subject service -> get subject status method");
		try {
			subjectServiceImpl.getSubjectStatus(subjectId);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
