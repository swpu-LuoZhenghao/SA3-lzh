package cesi.util;

import cesi.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    // 直接将数据库连接信息放在这里
    private static Connection conn;
    private static Statement stmt;
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/personal_contacts";
    private static final String username = "root";
    private static final String password = "root";

    public DB() {
    }
    static {

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public boolean register(User user) {
        // 注册用户到数据库
        String sql = "INSERT INTO contacts (name, address, phone) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getAddress());
            pstmt.setString(3, user.getPhone());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<User> getAllUsers() {



        // 从数据库获取所有用户信息
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM contacts";
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    public  boolean delete(String name) {
        // 从数据库删除用户
        String sql = "DELETE FROM contacts WHERE name = ?";
        try  {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(String name, String address, String phone) {
        // 更新数据库中的用户信息
        String sql = "UPDATE contacts SET address = ?, phone = ? WHERE name = ?";
        try  {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, address);
            pstmt.setString(2, phone);
            pstmt.setString(3, name);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
