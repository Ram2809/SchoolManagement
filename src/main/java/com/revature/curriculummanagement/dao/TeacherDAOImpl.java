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
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Teacher;
import com.revature.curriculummanagement.util.DBUtil;

public class TeacherDAOImpl implements TeacherDAO {
	static List<Teacher> teacherList = new ArrayList<>();
	static List<Integer> teacherIdList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void getTeacherId() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "select Id from teacher";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				teacherIdList.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTeacherDetails(Teacher teacher) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO teacher VALUES(?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, teacher.getId());
			pst.setString(2, teacher.getName());
			pst.setString(3, teacher.getDateOfBirth());
			pst.setString(4, teacher.getAddress());
			pst.setString(5, teacher.getQualification());
			pst.setString(6, teacher.getSubject());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows inserted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTeacherDetails(Integer id) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "";
			getTeacherId();
			if (!teacherIdList.contains(id)) {
				throw new TeacherNotFoundException("Teacher not found,Enter the valid id!");
			}
			System.out.println("1.Update name");
			System.out.println("2.Update date of birth");
			System.out.println("3.Update address");
			System.out.println("4.Update qualification");
			System.out.println("5.Update subject");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new name:");
				String newName = bufferedReader.readLine();
				query = "UPDATE teacher SET Name=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setString(1, newName);
				pst.setInt(2, id);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new dob:");
				String newDOB = bufferedReader.readLine();
				query = "UPDATE teacher SET Date_of_Birth=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setString(1, newDOB);
				pst.setInt(2, id);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 3:
				System.out.println("Enter the new address:");
				String newAddress = bufferedReader.readLine();
				query = "UPDATE teacher SET Address=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setString(1, newAddress);
				pst.setInt(2, id);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 4:
				System.out.println("Enter the new qualification:");
				String newQualification = bufferedReader.readLine();
				query = "UPDATE teacher SET Qualification=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setString(1, newQualification);
				pst.setInt(2, id);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 5:
				System.out.println("Enter the new subject:");
				String newSubject = bufferedReader.readLine();
				query = "UPDATE teacher SET Subject=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setString(1, newSubject);
				pst.setInt(2, id);
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

	public void deleteTeacherDetails(Integer id) throws SQLException, IOException, TeacherNotFoundException {
		getTeacherId();
		if (!teacherIdList.contains(id)) {
			throw new TeacherNotFoundException("Teacher not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "DELETE FROM teacher WHERE Id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Teacher> getTeacherDetails() throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM teacher";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				teacherList.add(new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherList;
	}

	public List<Teacher> getParticularTeacherDetails(Integer id)
			throws SQLException, IOException, TeacherNotFoundException {
		List<Teacher> teacherParticularList = new ArrayList<>();
		getTeacherId();
		if (!teacherIdList.contains(id)) {
			throw new TeacherNotFoundException("Teacher not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM teacher WHERE Id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				teacherParticularList.add(new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherParticularList;
	}

	public void getTeacherDetailsByClassRoom(Integer roomNo) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT teacher.Id AS TeacherId,teacher.name AS TeacherName,teacherdetails.subjectId AS SubjectId,subject.name AS SubjectName from teacher JOIN teacherdetails ON teacher.id=teacherdetails.teacherId JOIN subject ON teacherdetails.subjectId=subject.Id WHERE classRoomNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, roomNo);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
