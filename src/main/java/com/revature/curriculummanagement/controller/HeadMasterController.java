package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.curriculummanagement.model.HeadMaster;
import com.revature.curriculummanagement.service.HeadMasterServiceImpl;

public class HeadMasterController {
	static HeadMasterServiceImpl headMasterServiceImpl = new HeadMasterServiceImpl();

	public static void addHeadMasterDetails(HeadMaster headMaster) throws SQLException, IOException {
		headMasterServiceImpl.addHeadMasterDetails(headMaster);
	}

	public static void updateHeadMasterDetails(Integer updateId, String newName) throws SQLException, IOException {
		headMasterServiceImpl.updateHeadMasterDetails(updateId, newName);
	}
}
