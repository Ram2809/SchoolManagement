package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;

public interface TopicsService {
	void addTopicsDetails(Topics topics);

	List<Topics> getTopicsDetails();

	void updateTopicsDetails(String unitNo);

	void deleteTopicsDetails(String unitNo) throws BusinessServiceException;

	List<Topics> getParticularTopicDetails(String unitNo) throws BusinessServiceException;
}
