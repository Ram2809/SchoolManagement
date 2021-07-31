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
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;
import com.revature.curriculummanagement.util.DBUtil;
import static com.revature.curriculummanagement.dao.TeacherDAOImpl.*;

public class TeacherAssignDAOImpl implements TeacherAssignDAO {
	static List<TeacherDetails> teacherAssignList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public void addTeacherAssignDetails(TeacherDetails teacherDetails) throws SQLException, IOException {
		// TODO Auto-generated method stub
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO teacherDetails VALUES(?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, teacherDetails.getTeacher_id());
			pst.setInt(2, teacherDetails.getClassRoomNo());
			pst.setInt(3, teacherDetails.getSubjectId());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows inserted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTeacherAssignDetails(Integer teacherId) throws SQLException, IOException {
		// TODO Auto-generated method stub
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "";
			getTeacherId();// static import
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
				Integer updateRoomNo = Integer.parseInt(bufferedReader.readLine());
				query = "UPDATE teacherDetails SET classRoomNo=? WHERE teacherId=?";
				pst = con.prepareStatement(query);
				pst.setInt(1, updateRoomNo);
				pst.setInt(2, teacherId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new subject id:");
				Integer updateSubjectId = Integer.parseInt(bufferedReader.readLine());
				query = "UPDATE teacherDetails SET subjectId=? WHERE teacherId=?";
				pst = con.prepareStatement(query);
				pst.setInt(1, updateSubjectId);
				pst.setInt(2, teacherId);
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

	@Override
	public void deleteTeacherAssignDetails(Integer teacherId)
			throws SQLException, IOException, StudentNotFoundException {

		getTeacherId();
		if (!teacherIdList.contains(teacherId)) {
			throw new StudentNotFoundException("Student not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "DELETE FROM teacherdetails WHERE teacherId=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, teacherId);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherDetails> getTeacherAssignDetails() throws SQLException, IOException {

		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM teacherdetails";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				teacherAssignList.add(new TeacherDetails(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherAssignList;
	}

	@Override
	public List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId)
			throws SQLException, IOException, StudentNotFoundException, TeacherNotFoundException {
		List<TeacherDetails> teacherAssignParticularList = new ArrayList<>();
		getTeacherId();
		if (!teacherIdList.contains(teacherId)) {
			throw new TeacherNotFoundException("Teacher not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM teacherdetails WHERE teacherId=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, teacherId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				teacherAssignParticularList.add(new TeacherDetails(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherAssignParticularList;
	}

}
