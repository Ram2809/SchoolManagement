package com.revature.curriculummanagement.service;

import java.util.List;

import com.revature.curriculummanagement.model.HeadMaster;

public interface HeadMasterService {
	void addHeadMasterDetails(HeadMaster headMaster);

	void updateHeadMasterDetails(Integer id, String newName);

	void deleteHeadMasterDetails(Integer id);

	List<HeadMaster> getHeadMasterDetails();
}
