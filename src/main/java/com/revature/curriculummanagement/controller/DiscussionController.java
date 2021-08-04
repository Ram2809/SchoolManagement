package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.service.DiscussionServiceImpl;

public class DiscussionController {
	DiscussionServiceImpl discussionServiceImpl = new DiscussionServiceImpl();
	static Logger logger=Logger.getLogger("DiscussionController.class");
	public void addDiscussionDetails(Discussion discussion) throws SQLException, IOException {
		logger.info("In discussion service -> add method");
		discussionServiceImpl.addDiscussionDetails(discussion);
	}

	public List<Discussion> getDiscussionDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In discussion service -> get method");
		return discussionServiceImpl.getDiscussionDetails();
	}

	public void updateDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In discussion service -> update method");
		discussionServiceImpl.updateDiscussionDetails(questionNo);
	}

	public void deleteDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		logger.info("In discussion service -> delete method");
		discussionServiceImpl.deleteDiscussionDetails(questionNo);
	}

	public List<Discussion> getParticularDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		logger.info("In discussion service -> get particular discussion details method");
		return discussionServiceImpl.getParticularDiscussionDetails(questionNo);
	}

	public void getDiscussionStatusByUnit(String unitNo) {
		logger.info("In discussion service -> get discussion status by unit method");
		discussionServiceImpl.getDiscussionStatusByUnit(unitNo);
	}
}
