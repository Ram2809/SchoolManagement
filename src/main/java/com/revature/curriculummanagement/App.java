package com.revature.curriculummanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.client.HeadMaterApplication;
import com.revature.curriculummanagement.client.TeacherOperations;
import com.revature.curriculummanagement.exception.InvalidChoiceException;

public class App {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("App.class");
		HeadMaterApplication headMasterApplication = new HeadMaterApplication();
		TeacherOperations teacherOperations = new TeacherOperations();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		logger.info("In Curriculum Management App");
		System.out.println("Welcome to Curriculum Management System\n");
		while (true) {
			System.out.println("1.Head Master Section");
			System.out.println("2.Teacher Section");
			System.out.println("3.Exit");
			System.out.println("Enter your choice:");
			try {
				Integer userChoice = Integer.parseInt(bufferedReader.readLine());
				switch (userChoice) {
				case 1:
					logger.info("In head master section");
					headMasterApplication.main(args);
					break;
				case 2:
					logger.info("In teacher section");
					teacherOperations.main(args);
					break;
				case 3:
					logger.info("Exits from curriculum management app");
					System.exit(0);
					break;
				default:
					throw new InvalidChoiceException("Enter the valid choice!");
				}
			} catch (IOException | InvalidChoiceException e) {
				logger.warn(e.getMessage());
			}
		}
	}
}
