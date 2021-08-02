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
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.util.DBUtil;

public class ClassDAOImpl implements ClassDAO {
	static List<Classes> classList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public void addClassDetails(Classes classes) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO class VALUES(?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, classes.getClassRoomNo());
			pst.setString(2, classes.getStandard());
			pst.setString(3, classes.getSection());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows inserted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateClassDetails(Integer roomNo) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "";
			System.out.println("1.Update standard");
			System.out.println("2.Update section");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new standard:");
				String updateStandard = bufferedReader.readLine();
				query = "UPDATE class SET Standard=? WHERE RoomNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updateStandard);
				pst.setInt(2, roomNo);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new section:");
				String updateSection = bufferedReader.readLine();
				query = "UPDATE class SET Section=? WHERE RoomNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updateSection);
				pst.setInt(2, roomNo);
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

	public void deleteClassDetails(Integer roomNo) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "DELETE FROM class WHERE RoomNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, roomNo);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Row deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Classes> getClassDetails() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM class";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				classList.add(new Classes(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classList;
	}
}
