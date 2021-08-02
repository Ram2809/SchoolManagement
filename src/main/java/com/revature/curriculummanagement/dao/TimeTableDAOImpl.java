package com.revature.curriculummanagement.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.TimeTable;
import com.revature.curriculummanagement.util.DBUtil;

public class TimeTableDAOImpl implements TimeTableDAO {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static TimeTable timeTable = new TimeTable();
	static List<TimeTable> timeTableList = new ArrayList<TimeTable>();

	public void addTimeTableDetails() throws NumberFormatException, IOException {
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

	public void updateTimeTableDetails(Integer classId, String day) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "";
			System.out.println("1.Update period one");
			System.out.println("2.Update period two");
			System.out.println("3.Update period three");
			System.out.println("4.Update period four");
			System.out.println("5.Update period five");
			System.out.println("6.Update period six");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new peroid:");
				String updatePeriodOne = bufferedReader.readLine();
				query = "UPDATE timetable SET periodOne=? WHERE classRoomNo=? AND Day=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updatePeriodOne);
				pst.setInt(2, classId);
				pst.setString(3, day);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new peroid:");
				String updatePeriodTwo = bufferedReader.readLine();
				query = "UPDATE timetable SET periodTwo=? WHERE classRoomNo=? AND Day=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updatePeriodTwo);
				pst.setInt(2, classId);
				pst.setString(3, day);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 3:
				System.out.println("Enter the new peroid:");
				String updatePeriodThree = bufferedReader.readLine();
				query = "UPDATE timetable SET periodThree=? WHERE classRoomNo=? AND Day=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updatePeriodThree);
				pst.setInt(2, classId);
				pst.setString(3, day);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 4:
				System.out.println("Enter the new peroid:");
				String updatePeriodFour = bufferedReader.readLine();
				query = "UPDATE timetable SET periodFour=? WHERE classRoomNo=? AND Day=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updatePeriodFour);
				pst.setInt(2, classId);
				pst.setString(3, day);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 5:
				System.out.println("Enter the new peroid:");
				String updatePeriodFive = bufferedReader.readLine();
				query = "UPDATE timetable SET periodFive=? WHERE classRoomNo=? AND Day=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updatePeriodFive);
				pst.setInt(2, classId);
				pst.setString(3, day);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 6:
				System.out.println("Enter the new peroid:");
				String updatePeriodSix = bufferedReader.readLine();
				query = "UPDATE timetable SET periodSix=? WHERE classRoomNo=? AND Day=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updatePeriodSix);
				pst.setInt(2, classId);
				pst.setString(3, day);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTimeTableDetails(Integer classId, String day) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "DELETE FROM timetable WHERE classRoomNo=? AND Day=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, classId);
			pst.setString(2, day);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TimeTable> getTimeTableDetails() throws SQLException, IOException {
		// TODO Auto-generated method stub
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM timetable";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				timeTableList.add(new TimeTable(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeTableList;
	}

	public List<TimeTable> getParticularTimeTableDetails(Integer classId, String day) throws SQLException, IOException {
		List<TimeTable> timeTableParticularList = new ArrayList<>();
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM timetable WHERE classRoomNo=? AND day=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, classId);
			pst.setString(2, day);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				timeTableParticularList.add(new TimeTable(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeTableParticularList;
	}

	public void getTimeTableByclassRoom(Integer roomNo) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT day,periodOne,periodTwo,periodThree,periodFour,periodFive,periodSix FROM timetable WHERE classRoomNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, roomNo);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getTimeTableByclassStandard(Integer roomNo) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT class.RoomNo,class.Standard,class.Section,timetable.day,timetable.periodOne,timetable.periodTwo,timetable.periodThree,timetable.periodFour,timetable.periodFive,timetable.periodSix FROM class JOIN timetable ON class.RoomNo=timetable.classRoomNo WHERE roomNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, roomNo);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8)
						+ " " + rs.getString(9) + " " + rs.getString(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
