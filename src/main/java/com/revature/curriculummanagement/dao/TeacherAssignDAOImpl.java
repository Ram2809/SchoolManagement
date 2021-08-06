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

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;
import com.revature.curriculummanagement.util.DBUtil;

public class TeacherAssignDAOImpl implements TeacherAssignDAO {
	static List<TeacherDetails> teacherAssignList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> teacherIdList = new ArrayList<>();
	static Logger logger = Logger.getLogger("TeacherAssignDAOImpl.class");

	public static void getTeacherId() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "select teacherId from teacherdetails";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				teacherIdList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addTeacherAssignDetails(TeacherDetails teacherDetails) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO teacherDetails VALUES(?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, teacherDetails.getTeacher_id());
			pst.setInt(2, teacherDetails.getClassRoomNo());
			pst.setInt(3, teacherDetails.getSubjectId());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTeacherAssignDetails(Integer teacherId) throws DatabaseException {
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			String query = "";
			getTeacherId();
			if (!teacherIdList.contains(teacherId)) {
				throw new TeacherNotFoundException("Teacher not found,Enter the valid id!");
			}
			System.out.println("1.Update class room no");
			System.out.println("2.Update subject id");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new room no:");
				Integer newRoomNo = Integer.parseInt(bufferedReader.readLine());
				query = "UPDATE teacherDetails SET classRoomNo=? WHERE teacherId=?";
				pst = con.prepareStatement(query);
				pst.setInt(1, newRoomNo);
				pst.setInt(2, teacherId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new subject id:");
				Integer newSubjectId = Integer.parseInt(bufferedReader.readLine());
				query = "UPDATE teacherDetails SET subjectId=? WHERE teacherId=?";
				pst = con.prepareStatement(query);
				pst.setInt(1, newSubjectId);
				pst.setInt(2, teacherId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (IOException | NumberFormatException | SQLException | TeacherNotFoundException
				| InvalidChoiceException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
	}

	public void deleteTeacherAssignDetails(Integer teacherId) throws DatabaseException {
		try {
			getTeacherId();
			if (!teacherIdList.contains(teacherId)) {
				throw new TeacherNotFoundException("Teacher not found,Enter the valid id!");
			}
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			String query = "DELETE FROM teacherdetails WHERE teacherId=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, teacherId);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (SQLException | TeacherNotFoundException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
	}

	public List<TeacherDetails> getTeacherAssignDetails() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM teacherdetails";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				teacherAssignList.add(new TeacherDetails(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherAssignList;
	}

	public List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws DatabaseException {
		List<TeacherDetails> teacherAssignParticularList = new ArrayList<>();
		try {
			getTeacherId();
			if (!teacherIdList.contains(teacherId)) {
				throw new TeacherNotFoundException("Teacher not found,Enter the valid id!");
			}
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			String query = "SELECT * FROM teacherdetails WHERE teacherId=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, teacherId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				teacherAssignParticularList.add(new TeacherDetails(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (SQLException | TeacherNotFoundException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return teacherAssignParticularList;
	}

}
