package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.curriculummanagement.model.HeadMaster;
import com.revature.curriculummanagement.util.DBUtil;

public class HeadMasterDAOImpl implements HeadMasterDAO {
	static List<HeadMaster> headMasterList = new ArrayList<>();

	public void addHeadMasterDetails(HeadMaster headMaster) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO headMaster VALUES(?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, headMaster.getId());
			pst.setString(2, headMaster.getName());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows inserted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateHeadMasterDetails(Integer updateId, String newName) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "UPDATE headMaster SET name=? WHERE id=?";
			pst = con.prepareStatement(query);
			pst.setString(1, newName);
			pst.setInt(2, updateId);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows updated!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteHeadMasterDetails(Integer deleteId) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "DELETE FROM headmaster WHERE id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, deleteId);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<HeadMaster> getHeadMasterDetails() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM headmaster";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				headMasterList.add(new HeadMaster(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return headMasterList;
	}
}
