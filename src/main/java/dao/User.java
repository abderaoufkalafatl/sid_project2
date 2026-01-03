package dao;

import java.sql.Timestamp;

public class User {
	 	private int id;
	    private String fullname;
	    private String email;
	    private String password;
	    private String role;
	    private Timestamp createdAt;

	    // Constructor
	    public User(int id, String fullname, String email, String password, String role, Timestamp createdAt) {
	        this.id = id;
	        this.fullname = fullname;
	        this.email = email;
	        this.password = password;
	        this.role = role;
	        this.createdAt = createdAt;
	    }

	    // Getters
	    public int getId() { return id; }
	    public String getFullname() { return fullname; }
	    public String getEmail() { return email; }
	    public String getPassword() { return password; }
	    public String getRole() { return role; }
	    public Timestamp getCreatedAt() { return createdAt; }

	    // Setters (optional)
	    public void setFullname(String fullname) { this.fullname = fullname; }
	    public void setEmail(String email) { this.email = email; }
	    public void setPassword(String password) { this.password = password; }
	    public void setRole(String role) { this.role = role; }
}
