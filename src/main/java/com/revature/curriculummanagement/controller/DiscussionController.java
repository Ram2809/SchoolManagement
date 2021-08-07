package com.revature.curriculummanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.service.DiscussionService;
import com.revature.curriculummanagement.service.DiscussionServiceImpl;

public class DiscussionController {
	DiscussionService discussionServiceImpl = new DiscussionServiceImpl();
	static Logger logger = Logger.getLogger("DiscussionController.class");

	public void addDiscussionDetails(Discussion discussion) {
		logger.info("In discussion service -> add method");
		discussionServiceImpl.addDiscussionDetails(discussion);
	}

	public List<Discussion> getDiscussionDetails() {
		logger.info("In discussion service -> get method");
		return discussionServiceImpl.getDiscussionDetails();
	}

	public void updateDiscussionDetails(String questionNo) throws ControllerException {
		logger.info("In discussion service -> update method");
		try {
			discussionServiceImpl.updateDiscussionDetails(questionNo);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void deleteDiscussionDetails(String questionNo) throws ControllerException {
		logger.info("In discussion service -> delete method");
		try {
			discussionServiceImpl.deleteDiscussionDetails(questionNo);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public List<Discussion> getParticularDiscussionDetails(String questionNo) throws ControllerException {
		logger.info("In discussion service -> get particular discussion details method");
		try {
			return discussionServiceImpl.getParticularDiscussionDetails(questionNo);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void getDiscussionStatusByUnit(String unitNo) throws ControllerException {
		logger.info("In discussion service -> get discussion status by unit method");
		try {
			discussionServiceImpl.getDiscussionStatusByUnit(unitNo);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
