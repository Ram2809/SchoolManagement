package com.revature.curriculummanagement.dao;

import java.util.List;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.Discussion;

public interface DiscussionDAO {
	void addDiscussionDetails(Discussion discussion);

	void updateDiscussionDetails(String questionNo) throws DatabaseException;

	void deleteDiscussionDetails(String questionNo) throws DatabaseException;

	List<Discussion> getDiscussionDetails();

	List<Discussion> getParticularDiscussionDetails(String questionNo) throws DatabaseException;

	void getDiscussionStatusByUnit(String unitNo);
}
