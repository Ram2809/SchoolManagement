package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.controller.TeacherAssignController;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.TeacherDetails;

public class TeacherAssign {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static TeacherDetails teacherDetails = new TeacherDetails();
	static TeacherAssignController teacherAssignController = new TeacherAssignController();
	static List<TeacherDetails> teacherAssignList = new ArrayList<>();
	static Logger logger = Logger.getLogger("TeacherAssign.class");

	public static void insertAssign() {
		try {
			System.out.println("Enter the teacher id:");
			Integer teacherId = Integer.parseInt(bufferedReader.readLine());
			System.out.println("Enter the class room No:");
			Integer classRoomNo = Integer.parseInt(bufferedReader.readLine());
			System.out.println("Enter the subject id:");
			Integer subjectId = Integer.parseInt(bufferedReader.readLine());
			teacherDetails.setTeacher_id(teacherId);
			teacherDetails.setClassRoomNo(classRoomNo);
			teacherDetails.setSubjectId(subjectId);
			teacherAssignController.addTeacherAssignDetails(teacherDetails);
		} catch (IOException | NumberFormatException e) {
			logger.info(e.getMessage());
		}
	}

	public static void updateAssign() {
		try {
			System.out.println("Enter the teacher id:");
			Integer teacherId = Integer.parseInt(bufferedReader.readLine());
			teacherAssignController.updateTeacherAssignDetails(teacherId);
		} catch (NumberFormatException | IOException | ControllerException e) {
			logger.info(e.getMessage());
		}
	}

	public static void deleteAssign() {
		try {
			System.out.println("Enter the teacher id:");
			Integer teacherId = Integer.parseInt(bufferedReader.readLine());
			teacherAssignController.deleteTeacherAssignDetails(teacherId);
		} catch (IOException | NumberFormatException | ControllerException e) {
			logger.info(e.getMessage());
		}
	}

	public static void getAssign() {
		teacherAssignList = teacherAssignController.getTeacherAssignDetails();
		Iterator<TeacherDetails> teacherAssignIterator = teacherAssignList.iterator();
		while (teacherAssignIterator.hasNext()) {
			System.out.println(teacherAssignIterator.next());
		}
	}

	public static void getParticularAssign() {
		try {
			System.out.println("Enter the teacher id:");
			Integer teacherId = Integer.parseInt(bufferedReader.readLine());
			List<TeacherDetails> teacherAssignParicularList = new ArrayList<TeacherDetails>();
			teacherAssignParicularList = teacherAssignController.getParticularTeacherAssignDetails(teacherId);
			Iterator<TeacherDetails> teacherAssignParticularIterator = teacherAssignParicularList.iterator();
			while (teacherAssignParticularIterator.hasNext()) {
				System.out.println(teacherAssignParticularIterator.next());
			}
		} catch (IOException | NumberFormatException | ControllerException e) {
			logger.info(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Teacher Assign Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular teacher assign data");
			System.out.println("6.Exit");
			System.out.println("Enter the choice:");
			try {
				Integer userChoice = Integer.parseInt(bufferedReader.readLine());
				switch (userChoice) {
				case 1:
					logger.info("In teacher assign controller -> add method");
					insertAssign();
					break;
				case 2:
					logger.info("In teacher assign controller -> update method");
					updateAssign();
					break;
				case 3:
					logger.info("In teacher assign controller -> delete method");
					deleteAssign();
					break;
				case 4:
					logger.info("In teacher assign controller -> get method");
					getAssign();
					break;
				case 5:
					logger.info("In teacher assign controller -> get particular teacher assign details method");
					getParticularAssign();
					break;
				case 6:
					logger.info("Exits from teacher assign application");
					System.exit(0);
					break;
				default:
					throw new InvalidChoiceException("Enter the valid choice!");
				}
			} catch (IOException | NumberFormatException | InvalidChoiceException e) {
				logger.info(e.getMessage());
				e.printStackTrace();
			}
		}

	}
}
