package com.revature.curriculummanagement.dao;

import java.util.List;

import com.revature.curriculummanagement.model.HeadMaster;

public interface HeadMasterDAO {
	void addHeadMasterDetails(HeadMaster headMaster);

	void updateHeadMasterDetails(Integer id, String newName);

	void deleteHeadMasterDetails(Integer id);

	List<HeadMaster> getHeadMasterDetails();
}
