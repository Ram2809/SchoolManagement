package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.curriculummanagement.model.HeadMaster;
import com.revature.curriculummanagement.util.DBUtil;

public class HeadMasterDAOImpl implements HeadMasterDAO {

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
			String query = "update headmaster set name=? where id=?";
			pst = con.prepareStatement(query);
			pst.setString(1, newName);
			pst.setInt(2, updateId);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows updated!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
