package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.TimeTable;
import com.revature.curriculummanagement.util.DBUtil;

public class TimeTableApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static TimeTable timeTable = new TimeTable();

	public static void insertTimeTable() throws IOException {
		System.out.println("Enter the timetable details:");
		System.out.println("Enter the class room no:");
		Integer roomNo = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter the day");
			String day = bufferedReader.readLine();
			System.out.println("Enter 1st period");
			String firstPeriod = bufferedReader.readLine();
			System.out.println("Enter 2nd period");
			String secondPeriod = bufferedReader.readLine();
			System.out.println("Enter 3rd period");
			String thirdPeriod = bufferedReader.readLine();
			System.out.println("Enter 4th period");
			String fourthPeriod = bufferedReader.readLine();
			System.out.println("Enter 5th period");
			String fifthPeriod = bufferedReader.readLine();
			System.out.println("Enter 6th period");
			String sixthPeriod = bufferedReader.readLine();
			timeTable.setClassRoomNo(roomNo);
			timeTable.setDay(day);
			timeTable.setPeriodOne(firstPeriod);
			timeTable.setPeriodTwo(secondPeriod);
			timeTable.setPeriodThree(thirdPeriod);
			timeTable.setPeriodFour(fourthPeriod);
			timeTable.setPeriodFive(fifthPeriod);
			timeTable.setPeriodSix(sixthPeriod);
			try (Connection con = DBUtil.getConnection();) {
				PreparedStatement pst = null;
				String query = "INSERT INTO timetable VALUES(?,?,?,?,?,?,?,?)";
				pst = con.prepareStatement(query);
				pst.setInt(1, timeTable.getClassRoomNo());
				pst.setString(2, timeTable.getDay());
				pst.setString(3, timeTable.getPeriodOne());
				pst.setString(4, timeTable.getPeriodTwo());
				pst.setString(5, timeTable.getPeriodThree());
				pst.setString(6, timeTable.getPeriodFour());
				pst.setString(7, timeTable.getPeriodFive());
				pst.setString(8, timeTable.getPeriodSix());
				int count = pst.executeUpdate();
				System.out.println(count + " " + "Rows Inserted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException, InvalidChoiceException {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("TimeTable Application");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular student data");
			System.out.println("6.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertTimeTable();
				break;
			/*
			 * case 2: updateStudent(); break; case 3: deleteStudent(); break; case 4:
			 * getStudent(); break; case 5: getParticularStudent(); break;
			 */
			case 6:
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}

}
