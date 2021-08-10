package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.controller.SubjectController;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Subject;

public class SubjectApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Subject subject = new Subject();
	static SubjectController subjectController = new SubjectController();
	static List<Subject> subjectList = new ArrayList<>();
	static Logger logger = Logger.getLogger("SubjectApplication.class");

	public static void insertSubject() {
		try {
			System.out.println("Enter the subject details:");
			System.out.println("Enter the subject id:");
			Integer subjectId = Integer.parseInt(bufferedReader.readLine());
			System.out.println("Enter the subject name:");
			String subjectName = bufferedReader.readLine();
			System.out.println("Enter the class id:");
			Integer classId = Integer.parseInt(bufferedReader.readLine());
			subject.setSubId(subjectId);
			subject.setSubName(subjectName);
			subject.setClassId(classId);
			subjectController.addSubjectDetails(subject);
		} catch (IOException | NumberFormatException e) {
			logger.warn(e.getMessage());
		}
	}

	public static void updateSubject() {
		try {
			System.out.println("Enter the subject id:");
			Integer subjectId = Integer.parseInt(bufferedReader.readLine());
			subjectController.updateSubjectDetails(subjectId);
		} catch (IOException | NumberFormatException | ControllerException e) {
			logger.warn(e.getMessage());
		}
	}

	public static void deleteSubject() {
		try {
			System.out.println("Enter the subject id:");
			Integer subjectId = Integer.parseInt(bufferedReader.readLine());
			subjectController.deleteSubjectDetails(subjectId);
		} catch (IOException | NumberFormatException | ControllerException e) {
			logger.warn(e.getMessage());
		}
	}

	public static void getSubject() {
		subjectList = subjectController.getSubjectDetails();
		Iterator<Subject> subjectIterator = subjectList.iterator();
		System.out
				.println("-------------------------------------------------------------------------------------------");
		while (subjectIterator.hasNext()) {
			System.out.println(subjectIterator.next());
		}
		System.out
				.println("-------------------------------------------------------------------------------------------");
	}

	public static void getParticularSubject() throws ControllerException {
		try {
			System.out.println("Enter the subject id:");
			Integer subjectId = Integer.parseInt(bufferedReader.readLine());
			List<Subject> subjectParicularList = new ArrayList<Subject>();
			subjectParicularList = subjectController.getParticularSubjectDetails(subjectId);
			Iterator<Subject> subjectParticularIterator = subjectParicularList.iterator();
			System.out.println(
					"-------------------------------------------------------------------------------------------");
			while (subjectParticularIterator.hasNext()) {
				System.out.println(subjectParticularIterator.next());
			}
			System.out.println(
					"-------------------------------------------------------------------------------------------");
		} catch (IOException | NumberFormatException | ControllerException e) {
			logger.warn(e.getMessage());
		}
	}

	public static void subjectStatus() {
		try {
			System.out.println("Enter the subject id:");
			Integer subjectId = Integer.parseInt(bufferedReader.readLine());
			subjectController.getSubjectStatus(subjectId);
		} catch (NumberFormatException | IOException | ControllerException e) {
			logger.warn(e.getMessage());
		}

	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("Subject Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Particular subject data");
			System.out.println("6.Get subject status");
			System.out.println("7.Exit");
			System.out.println("Enter the choice:");
			try {
				Integer userChoice = Integer.parseInt(bufferedReader.readLine());
				switch (userChoice) {
				case 1:
					logger.info("In subject controller -> add method");
					insertSubject();
					break;
				case 2:
					logger.info("In subject controller -> update method");
					updateSubject();
					break;
				case 3:
					logger.info("In subject controller -> delete method");
					deleteSubject();
					break;
				case 4:
					logger.info("In subject controller -> get method");
					getSubject();
					break;
				case 5:
					logger.info("In subject controller -> get particular subject data method");
					getParticularSubject();
					break;
				case 6:
					logger.info("In subject controller -> get subject status method");
					subjectStatus();
					break;
				case 7:
					logger.info("Exits from subject application");
					System.exit(0);
					break;
				default:
					throw new InvalidChoiceException("Enter the valid choice!");
				}
			} catch (IOException | NumberFormatException | ControllerException | InvalidChoiceException e) {
				logger.warn(e.getMessage());
			}
		}
	}
}
