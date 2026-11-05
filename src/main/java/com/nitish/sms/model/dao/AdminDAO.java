package com.nitish.sms.model.dao;

import com.nitish.sms.model.Admin;
import com.nitish.sms.model.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public Admin login(String email, String password) {

        Admin admin = null;

        String sql = "SELECT * FROM admins WHERE email = ? AND password = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    admin = new Admin();

                    admin.setAdminId(rs.getInt("admin_id"));
                    admin.setUsername(rs.getString("username"));
                    admin.setEmail(rs.getString("email"));
                    admin.setPassword(rs.getString("password"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}