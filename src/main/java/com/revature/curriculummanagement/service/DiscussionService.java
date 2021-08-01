package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.model.Student;

public interface DiscussionService {
	void addDiscussionDetails(Discussion discussion) throws SQLException, IOException;

	List<Discussion> getDiscussionDetails() throws NumberFormatException, IOException, SQLException;

	void updateDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException, QuestionNotFoundException;

	void deleteDiscussionDetails(String questionNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException;

	List<Discussion> getParticularDiscussionDetails(String questioNo)
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException;

	void getDiscussionStatusByUnit(String unitNo);
}
