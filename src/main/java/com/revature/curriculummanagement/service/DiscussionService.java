package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.Discussion;

public interface DiscussionService {
	void addDiscussionDetails(Discussion discussion);

	List<Discussion> getDiscussionDetails();

	void updateDiscussionDetails(String questionNo) throws BusinessServiceException;

	void deleteDiscussionDetails(String questionNo) throws BusinessServiceException;

	List<Discussion> getParticularDiscussionDetails(String questioNo) throws BusinessServiceException;

	void getDiscussionStatusByUnit(String unitNo) throws BusinessServiceException;
}
