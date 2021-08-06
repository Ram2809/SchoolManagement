package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.InvalidChoiceException;

public class TeacherOperations {

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Logger logger = Logger.getLogger("TeacherOperations.class");
		logger.info("In teacher operations class");
		System.out.println("Welcome to Teacher Section\n");
		while (true) {
			System.out.println("1.Topics Section");
			System.out.println("2.Discussion Section");
			System.out.println("3.Exit");
			System.out.println("Enter your choice:");
			try {
				Integer userChoice = Integer.parseInt(bufferedReader.readLine());
				switch (userChoice) {
				case 1:
					logger.info("In topic application");
					TopicApplication.main(args);
					break;
				case 2:
					logger.info("In discussion application");
					DiscussionApplication.main(args);
					break;
				case 3:
					logger.info("Exits from teacher operations application");
					System.exit(0);
					break;
				default:
					throw new InvalidChoiceException("Enter the valid choice!");
				}
			} catch (IOException | NumberFormatException | InvalidChoiceException e) {
				logger.warn(e.getMessage());
			}
		}
	}
}
