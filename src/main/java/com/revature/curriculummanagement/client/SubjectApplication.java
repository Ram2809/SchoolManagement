package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.controller.SubjectController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;

public class SubjectApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Subject subject = new Subject();
	static SubjectController subjectController = new SubjectController();
	static List<Subject> subjectList = new ArrayList<>();

	public static void insertSubject() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the subject details:");
		System.out.println("Enter the subject id:");
		Integer subjectId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the subject name:");
		String subjectName = bufferedReader.readLine();
		System.out.println("Enter the class id:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		subject.setClassId(subjectId);
		subject.setSubName(subjectName);
		subject.setClassId(classId);
		subjectController.addSubjectDetails(subject);
	}

	public static void updateSubject() throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Enter the subject id:");
		Integer subjectId = Integer.parseInt(bufferedReader.readLine());
		subjectController.updateSubjectDetails(subjectId);
	}

	public static void deleteSubject()
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		System.out.println("Enter the subject id:");
		Integer subjectId = Integer.parseInt(bufferedReader.readLine());
		subjectController.deleteSubjectDetails(subjectId);
	}

	public static void getSubject() throws SQLException, IOException {
		subjectList = subjectController.getSubjectDetails();
		Iterator<Subject> subjectIterator = subjectList.iterator();
		while (subjectIterator.hasNext()) {
			System.out.println(subjectIterator.next());
		}
	}

	public static void getParticularSubject()
			throws NumberFormatException, IOException, SQLException, SubjectNotFoundException {
		System.out.println("Enter the subject id:");
		Integer subjectId = Integer.parseInt(bufferedReader.readLine());
		List<Subject> subjectParicularList = new ArrayList<Subject>();
		subjectParicularList = subjectController.getParticularSubjectDetails(subjectId);
		Iterator<Subject> subjectParticularIterator = subjectParicularList.iterator();
		while (subjectParticularIterator.hasNext()) {
			System.out.println(subjectParticularIterator.next());
		}
	}

	public static void subjectStatus() throws NumberFormatException, IOException {
		System.out.println("Enter the subject id:");
		Integer subjectId = Integer.parseInt(bufferedReader.readLine());
		subjectController.getSubjectStatus(subjectId);
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, SQLException, InvalidChoiceException, SubjectNotFoundException {
		Logger logger = Logger.getLogger("SubjectApplication.class");
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
				logger.info("Exits from student application");
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}
}
