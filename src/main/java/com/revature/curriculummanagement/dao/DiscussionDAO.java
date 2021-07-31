package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.model.Discussion;



public interface DiscussionDAO {
	void addDiscussionDetails(Discussion discussion) throws SQLException, IOException;

	void updateDiscussionDetails(String questionNo) throws SQLException, IOException;

	void deleteDiscussionDetails(String questionNo) throws SQLException, IOException, QuestionNotFoundException;

	List<Discussion> getDiscussionDetails() throws SQLException, IOException;

	List<Discussion> getParticularDiscussionDetails(String questionNo)
			throws SQLException, IOException, QuestionNotFoundException;
}
