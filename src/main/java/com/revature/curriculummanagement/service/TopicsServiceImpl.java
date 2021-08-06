package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TopicsDAO;
import com.revature.curriculummanagement.dao.TopicsDAOImpl;
import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;

public class TopicsServiceImpl implements TopicsService {
	TopicsDAO topicsDAOImpl = new TopicsDAOImpl();
	static Logger logger = Logger.getLogger("TopicsServiceImpl.class");

	public void addTopicsDetails(Topics topics) {
		logger.info("In topics DAO -> add method");
		topicsDAOImpl.addTopicsDetails(topics);
	}

	public void updateTopicsDetails(String unitNo) throws BusinessServiceException {
		logger.info("In topics DAO -> update method");
		try {
			topicsDAOImpl.updateTopicsDetails(unitNo);
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void deleteTopicsDetails(String unitNo) throws BusinessServiceException {
		logger.info("In topics DAO -> delete method");
		try {
			topicsDAOImpl.deleteTopicsDetails(unitNo);
		} catch (DatabaseException e) {
			logger.info(e.getMessage());
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public List<Topics> getTopicsDetails() {
		logger.info("In topics DAO -> get method");
		return topicsDAOImpl.getTopicsDetails();
	}

	public List<Topics> getParticularTopicDetails(String unitNo) throws BusinessServiceException {
		logger.info("In topics DAO -> get particular topics details method");
		try {
			return topicsDAOImpl.getParticularTopicDetails(unitNo);
		} catch (DatabaseException e) {
			logger.info(e.getMessage());
			throw new BusinessServiceException(e.getMessage());
		}
	}
}
