package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;

public class TeacherOperations {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException,
			InvalidChoiceException, TopicNotFoundException, QuestionNotFoundException, StudentNotFoundException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to Teacher Section\n");
		while (true) {
			System.out.println("1.Topics Section");
			System.out.println("2.Discussion Section");
			System.out.println("3.Exit");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				TopicApplication.main(args);
				break;
			case 2:
				DiscussionApplication.main(args);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}

}
