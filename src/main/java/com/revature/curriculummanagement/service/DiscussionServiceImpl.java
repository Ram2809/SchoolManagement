package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.dao.DiscussionDAO;
import com.revature.curriculummanagement.dao.DiscussionDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.model.Student;

public class DiscussionServiceImpl implements DiscussionService {
	DiscussionDAOImpl discussionDAOImpl = new DiscussionDAOImpl();

	public void addDiscussionDetails(Discussion discussion) throws SQLException, IOException {
		discussionDAOImpl.addDiscussionDetails(discussion);
	}

	public void updateDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		discussionDAOImpl.updateDiscussionDetails(questionNo);
	}

	public void deleteDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		discussionDAOImpl.deleteDiscussionDetails(questionNo);
	}

	public List<Discussion> getDiscussionDetails() throws NumberFormatException, IOException, SQLException {
		return discussionDAOImpl.getDiscussionDetails();
	}

	public List<Discussion> getParticularDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		return discussionDAOImpl.getParticularDiscussionDetails(questionNo);
	}

	public void getDiscussionStatusByUnit(String unitNo) {
		discussionDAOImpl.getDiscussionStatusByUnit(unitNo);

	}

}
