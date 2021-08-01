package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.controller.TeacherAssignController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;

public class TeacherAssign {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static TeacherDetails teacherDetails = new TeacherDetails();
	static TeacherAssignController teacherAssignController = new TeacherAssignController();
	static List<TeacherDetails> teacherAssignList = new ArrayList<>();

	public static void insertAssign() throws NumberFormatException, IOException, SQLException {
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
	}

	public static void updateAssign() throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Enter the teacher id:");
		Integer teacherId = Integer.parseInt(bufferedReader.readLine());
		teacherAssignController.updateTeacherAssignDetails(teacherId);
	}

	public static void deleteAssign() throws NumberFormatException, IOException, SQLException, SubjectNotFoundException,
			StudentNotFoundException {
		System.out.println("Enter the teacher id:");
		Integer teacherId = Integer.parseInt(bufferedReader.readLine());
		teacherAssignController.deleteTeacherAssignDetails(teacherId);
	}

	public static void getAssign() throws SQLException, IOException {
		teacherAssignList = teacherAssignController.getTeacherAssignDetails();
		Iterator<TeacherDetails> teacherAssignIterator = teacherAssignList.iterator();
		while (teacherAssignIterator.hasNext()) {
			System.out.println(teacherAssignIterator.next());
		}
	}

	public static void getParticularAssign() throws NumberFormatException, IOException, SQLException,
			SubjectNotFoundException, StudentNotFoundException, TeacherNotFoundException {
		System.out.println("Enter the teacher id:");
		Integer teacherId = Integer.parseInt(bufferedReader.readLine());
		List<TeacherDetails> teacherAssignParicularList = new ArrayList<TeacherDetails>();
		teacherAssignParicularList = teacherAssignController.getParticularTeacherAssignDetails(teacherId);
		Iterator<TeacherDetails> teacherAssignParticularIterator = teacherAssignParicularList.iterator();
		while (teacherAssignParticularIterator.hasNext()) {
			System.out.println(teacherAssignParticularIterator.next());
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException, InvalidChoiceException,
			SQLException, SubjectNotFoundException, StudentNotFoundException, TeacherNotFoundException {
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
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertAssign();
				break;
			case 2:
				updateAssign();
				break;
			case 3:
				deleteAssign();
				break;
			case 4:
				getAssign();
				break;
			case 5:
				getParticularAssign();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}

}
