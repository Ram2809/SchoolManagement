package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.service.DiscussionServiceImpl;

public class DiscussionController {
	DiscussionServiceImpl discussionServiceImpl = new DiscussionServiceImpl();

	public void addDiscussionDetails(Discussion discussion) throws SQLException, IOException {
		discussionServiceImpl.addDiscussionDetails(discussion);
	}

	public List<Discussion> getDiscussionDetails() throws NumberFormatException, IOException, SQLException {
		return discussionServiceImpl.getDiscussionDetails();
	}

	public void updateDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		discussionServiceImpl.updateDiscussionDetails(questionNo);
	}

	public void deleteDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		discussionServiceImpl.deleteDiscussionDetails(questionNo);
	}

	public List<Discussion> getParticularDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		return discussionServiceImpl.getParticularDiscussionDetails(questionNo);
	}
}
