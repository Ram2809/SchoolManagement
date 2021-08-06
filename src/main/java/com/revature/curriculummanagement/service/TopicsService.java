package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.Topics;

public interface TopicsService {
	void addTopicsDetails(Topics topics);

	List<Topics> getTopicsDetails();

	void updateTopicsDetails(String unitNo) throws BusinessServiceException;

	void deleteTopicsDetails(String unitNo) throws BusinessServiceException;

	List<Topics> getParticularTopicDetails(String unitNo) throws BusinessServiceException;
}
