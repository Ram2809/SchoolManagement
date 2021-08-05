package com.revature.curriculummanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.model.Topics;
import com.revature.curriculummanagement.service.TopicsService;
import com.revature.curriculummanagement.service.TopicsServiceImpl;

public class TopicsController {
	TopicsService topicsServiceImpl = new TopicsServiceImpl();
	static Logger logger = Logger.getLogger("TopicsController.class");

	public void addTopicsDetails(Topics topics) {
		logger.info("In topics service -> add method");
		topicsServiceImpl.addTopicsDetails(topics);
	}

	public List<Topics> getTopicsDetails() {
		logger.info("In topics service -> get method");
		return topicsServiceImpl.getTopicsDetails();
	}

	public void updateTopicsDetails(String unitNo) {
		logger.info("In topics service -> update method");
		topicsServiceImpl.updateTopicsDetails(unitNo);
	}

	public void deleteTopicsDetails(String unitNo) throws ControllerException {
		logger.info("In topics service -> delete method");
		try {
			topicsServiceImpl.deleteTopicsDetails(unitNo);
		} catch (BusinessServiceException e) {
			logger.info(e.getMessage());
			throw new ControllerException(e.getMessage());
		}
	}

	public List<Topics> getParticularTopicDetails(String unitNo) throws ControllerException {
		logger.info("In topics service -> get particular topic details method");
		try {
			return topicsServiceImpl.getParticularTopicDetails(unitNo);
		} catch (BusinessServiceException e) {
			logger.info(e.getMessage());
			throw new ControllerException(e.getMessage());
		}
	}
}
