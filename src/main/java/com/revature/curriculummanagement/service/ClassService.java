package com.revature.curriculummanagement.service;
import java.io.IOException;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;

public interface ClassService {
	void addClassDetails(Classes classes);

	void getClassDetails(Classes classes);

	void updateClassDetails(Classes classes) throws NumberFormatException, IOException, InvalidChoiceException;

	void deleteClassDetails(Classes classes) throws NumberFormatException, IOException;
}