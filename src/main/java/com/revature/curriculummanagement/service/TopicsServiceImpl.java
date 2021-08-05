package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.TopicsDAO;
import com.revature.curriculummanagement.dao.TopicsDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;

public class TopicsServiceImpl implements TopicsService {
	TopicsDAO topicsDAOImpl = new TopicsDAOImpl();
	static Logger logger = Logger.getLogger("TopicsServiceImpl.class");

	public void addTopicsDetails(Topics topics) throws SQLException, IOException {
		logger.info("In topics DAO -> add method");
		topicsDAOImpl.addTopicsDetails(topics);
	}

	public void updateTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In topics DAO -> update method");
		topicsDAOImpl.updateTopicsDetails(unitNo);
	}

	public void deleteTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		logger.info("In topics DAO -> delete method");
		topicsDAOImpl.deleteTopicsDetails(unitNo);
	}

	public List<Topics> getTopicsDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In topics DAO -> get method");
		return topicsDAOImpl.getTopicsDetails();
	}

	public List<Topics> getParticularTopicDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		logger.info("In topics DAO -> get particular topics details method");
		return topicsDAOImpl.getParticularTopicDetails(unitNo);
	}
}
