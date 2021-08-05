package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;
import com.revature.curriculummanagement.service.TopicsServiceImpl;

public class TopicsController {
	TopicsServiceImpl topicsServiceImpl = new TopicsServiceImpl();
	static Logger logger = Logger.getLogger("TopicsController.class");

	public void addTopicsDetails(Topics topics) throws SQLException, IOException {
		logger.info("In topics service -> add method");
		topicsServiceImpl.addTopicsDetails(topics);
	}

	public List<Topics> getTopicsDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In topics service -> get method");
		return topicsServiceImpl.getTopicsDetails();
	}

	public void updateTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In topics service -> update method");
		topicsServiceImpl.updateTopicsDetails(unitNo);
	}

	public void deleteTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		logger.info("In topics service -> delete method");
		topicsServiceImpl.deleteTopicsDetails(unitNo);
	}

	public List<Topics> getParticularTopicDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		logger.info("In topics service -> get particular topic details method");
		return topicsServiceImpl.getParticularTopicDetails(unitNo);
	}
}
