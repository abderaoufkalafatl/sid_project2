package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;


public class UserDAO {
	public boolean login(String email, String password) {
        boolean result = false;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

	public boolean register(String fullname, String email, String password, String role) {
        boolean result = false;

        String sql = "INSERT INTO users(fullname, email, password, role) VALUES(?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, password); // Ideally, hash the password
            ps.setString(4, role != null ? role : "client"); // default role

            int rows = ps.executeUpdate();
            result = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
	public User getUserByEmail(String email) {
	    User user = null;
	    Connection con = null;

	    try {
	        System.out.println("DAO: getUserByEmail() called");
	        System.out.println("EMAIL RECEIVED = " + email);

	        con = DBConnection.getConnection();

	        if (con == null) {
	            System.out.println("❌ CONNECTION IS NULL");
	            return null;
	        } else {
	            System.out.println("✅ CONNECTION OK");
	        }

	        String sql = "SELECT * FROM users WHERE email = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, email);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("✅ USER FOUND IN DB");

	            user = new User(
	                rs.getInt("id"),
	                rs.getString("fullname"),
	                rs.getString("email"),
	                rs.getString("password"),
	                rs.getString("role"),
	                rs.getTimestamp("created_at")
	            );
	        } else {
	            System.out.println("❌ NO USER WITH THIS EMAIL");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}


}