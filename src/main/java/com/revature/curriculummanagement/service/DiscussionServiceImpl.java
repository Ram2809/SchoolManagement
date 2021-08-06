package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.DiscussionDAO;
import com.revature.curriculummanagement.dao.DiscussionDAOImpl;
import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.model.Student;

public class DiscussionServiceImpl implements DiscussionService {
	DiscussionDAO discussionDAOImpl = new DiscussionDAOImpl();
	static Logger logger = Logger.getLogger("DiscussionServiceImpl.class");

	public void addDiscussionDetails(Discussion discussion) {
		logger.info("In discussion DAO -> add method");
		discussionDAOImpl.addDiscussionDetails(discussion);
	}

	public void updateDiscussionDetails(String questionNo) throws BusinessServiceException {
		logger.info("In discussion DAO -> update method");
		try {
			discussionDAOImpl.updateDiscussionDetails(questionNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void deleteDiscussionDetails(String questionNo) throws BusinessServiceException {
		logger.info("In discussion DAO -> delete method");
		try {
			discussionDAOImpl.deleteDiscussionDetails(questionNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public List<Discussion> getDiscussionDetails() {
		logger.info("In discussion DAO -> get method");
		return discussionDAOImpl.getDiscussionDetails();
	}

	public List<Discussion> getParticularDiscussionDetails(String questionNo) throws BusinessServiceException {
		logger.info("In discussion DAO -> get particular discussion details method");
		try {
			return discussionDAOImpl.getParticularDiscussionDetails(questionNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void getDiscussionStatusByUnit(String unitNo) {
		logger.info("In discussion DAO -> get discussion status by unit method");
		discussionDAOImpl.getDiscussionStatusByUnit(unitNo);

	}

}
