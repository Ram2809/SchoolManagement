package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.DiscussionDAO;
import com.revature.curriculummanagement.dao.DiscussionDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.model.Student;

public class DiscussionServiceImpl implements DiscussionService {
	DiscussionDAOImpl discussionDAOImpl = new DiscussionDAOImpl();
	static Logger logger = Logger.getLogger("DiscussionServiceImpl.class");

	public void addDiscussionDetails(Discussion discussion) throws SQLException, IOException {
		logger.info("In discussion DAO -> add method");
		discussionDAOImpl.addDiscussionDetails(discussion);
	}

	public void updateDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In discussion DAO -> update method");
		discussionDAOImpl.updateDiscussionDetails(questionNo);
	}

	public void deleteDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		logger.info("In discussion DAO -> delete method");
		discussionDAOImpl.deleteDiscussionDetails(questionNo);
	}

	public List<Discussion> getDiscussionDetails() throws NumberFormatException, IOException, SQLException {
		logger.info("In discussion DAO -> get method");
		return discussionDAOImpl.getDiscussionDetails();
	}

	public List<Discussion> getParticularDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		logger.info("In discussion DAO -> get particular discussion details method");
		return discussionDAOImpl.getParticularDiscussionDetails(questionNo);
	}

	public void getDiscussionStatusByUnit(String unitNo) {
		logger.info("In discussion DAO -> get discussion status by unit method");
		discussionDAOImpl.getDiscussionStatusByUnit(unitNo);

	}

}
