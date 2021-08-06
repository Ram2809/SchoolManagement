package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.model.Classes;

public interface ClassService {
	void addClassDetails(Classes classes);

	void updateClassDetails(Integer roomNo) throws BusinessServiceException;

	void deleteClassDetails(Integer roomNo);

	List<Classes> getClassDetails();
}