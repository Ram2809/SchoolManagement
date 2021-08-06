package com.revature.curriculummanagement.dao;

import java.util.List;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.Topics;

public interface TopicsDAO {
	void addTopicsDetails(Topics topics);

	void updateTopicsDetails(String unitNo) throws DatabaseException;

	void deleteTopicsDetails(String unitNo) throws DatabaseException;

	List<Topics> getTopicsDetails();

	List<Topics> getParticularTopicDetails(String unitNo) throws DatabaseException;
}
