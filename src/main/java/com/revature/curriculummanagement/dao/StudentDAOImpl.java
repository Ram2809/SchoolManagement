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
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.util.DBUtil;

public class StudentDAOImpl implements StudentDAO {
	static List<Student> studentList = new ArrayList<>();
	static List<Integer> studentIdList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void getStudentId() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "select RollNo from student";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				studentIdList.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addStudentDetails(Student student) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO student VALUES(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, student.getRollNo());
			pst.setString(2, student.getName());
			pst.setString(3, student.getDateOfBirth());
			pst.setString(4, student.getAddress());
			pst.setInt(5, student.getClassRoomNo());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows inserted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStudentDetails(Integer updateId) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "";
			getStudentId();
			if (!studentIdList.contains(updateId)) {
				throw new StudentNotFoundException("Student not found,Enter the valid id!");
			}
			System.out.println("1.Update name");
			System.out.println("2.Update date of birth");
			System.out.println("3.Update address");
			System.out.println("4.Update class room no");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new name:");
				String updateName = bufferedReader.readLine();
				query = "UPDATE student SET Name=? WHERE RollNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updateName);
				pst.setInt(2, updateId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new dob:");
				String updateDOB = bufferedReader.readLine();
				query = "UPDATE student SET Date_of_Birth=? WHERE RollNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updateDOB);
				pst.setInt(2, updateId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 3:
				System.out.println("Enter the new address:");
				String updateAddress = bufferedReader.readLine();
				query = "UPDATE student SET Address=? WHERE RollNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updateAddress);
				pst.setInt(2, updateId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 4:
				System.out.println("Enter the new class room no:");
				Integer updateRoomNo = Integer.parseInt(bufferedReader.readLine());
				query = "UPDATE student SET classRoomNo=? WHERE RollNo=?";
				pst = con.prepareStatement(query);
				pst.setInt(1, updateRoomNo);
				pst.setInt(2, updateId);
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

	public void deleteStudentDetails(Integer deleteId) throws SQLException, IOException, StudentNotFoundException {
		getStudentId();
		if (!studentIdList.contains(deleteId)) {
			throw new StudentNotFoundException("Student not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "DELETE FROM student WHERE RollNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, deleteId);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> getStudentDetails() throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM student";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				studentList.add(
						new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public List<Student> getParticularStudentDetails(Integer fetchId)
			throws SQLException, IOException, StudentNotFoundException {
		List<Student> studentParticularList = new ArrayList<>();
		getStudentId();
		if (!studentIdList.contains(fetchId)) {
			throw new StudentNotFoundException("Student not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM student WHERE RollNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, fetchId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				studentParticularList.add(
						new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentParticularList;
	}

}
