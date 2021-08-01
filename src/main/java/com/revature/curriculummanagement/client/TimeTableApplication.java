package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.controller.TimeTableController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.TimeTable;

public class TimeTableApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static TimeTable timeTable = new TimeTable();
	static TimeTableController timeTableController = new TimeTableController();
	static List<TimeTable> timeTableList = new ArrayList<>();

	public static void insertTimeTable() throws IOException {
		System.out.println("Enter the timetable details:");
		timeTableController.addTimeTableDetails();
	}

	public static void updateTimeTable() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the day:");
		String day = bufferedReader.readLine();
		timeTableController.updateTimeTableDetails(classId, day);
	}

	public static void deleteTimeTable() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the day:");
		String day = bufferedReader.readLine();
		timeTableController.deleteTimeTableDetails(classId, day);
	}

	public static void getTimeTable() throws NumberFormatException, IOException, SQLException {
		timeTableList = timeTableController.getTimeTableDetails();
		Iterator<TimeTable> timeTableIterator = timeTableList.iterator();
		while (timeTableIterator.hasNext()) {
			System.out.println(timeTableIterator.next());
		}
	}

	public static void getParticularTimeTable() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the class room no:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the day:");
		String day = bufferedReader.readLine();
		List<TimeTable> timeTableParicularList = new ArrayList<TimeTable>();
		timeTableParicularList = timeTableController.getParticularTimeTableDetails(classId, day);
		Iterator<TimeTable> timeTableParticularIterator = timeTableParicularList.iterator();
		while (timeTableParticularIterator.hasNext()) {
			System.out.println(timeTableParticularIterator.next());
		}
	}

	public static void timeTableByclassRoom() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer roomNo = Integer.parseInt(bufferedReader.readLine());
		timeTableController.getTimeTableByclassRoom(roomNo);
	}

	public static void timeTableByclassStandard() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer roomNo = Integer.parseInt(bufferedReader.readLine());
		timeTableController.getTimeTableByclassStandard(roomNo);
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("TimeTable Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular student data");
			System.out.println("6.Get timetable for paticular class");
			System.out.println("7.Get timetable for paticular standard");
			System.out.println("8.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertTimeTable();
				break;
			case 2:
				updateTimeTable();
				break;
			case 3:
				deleteTimeTable();
				break;
			case 4:
				getTimeTable();
				break;
			case 5:
				getParticularTimeTable();
				break;
			case 6:
				timeTableByclassRoom();
				break;
			case 7:
				timeTableByclassStandard();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}

}
