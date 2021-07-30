package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.revature.curriculummanagement.controller.HeadMasterController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.HeadMaster;

public class HeadMaterApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static HeadMaster headMaster = new HeadMaster();
	static HeadMasterController headMasterController = new HeadMasterController();

	public static void insertHeadMaster() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the head master details:");
		System.out.println("Enter the head master id:");
		Integer id = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the head master name:");
		String name = bufferedReader.readLine();
		headMaster.setId(id);
		headMaster.setName(name);
		headMasterController.addHeadMasterDetails(headMaster);
	}

	public static void updateHeadMaster() throws IOException, SQLException {
		System.out.println("Enter the id:");
		Integer updateId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the name:");
		String newName = bufferedReader.readLine();
		headMasterController.updateHeadMasterDetails(updateId, newName);
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Head Master Application");
		while (true) {
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Exit");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertHeadMaster();
				break;
			case 2:
				updateHeadMaster();
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}
}
