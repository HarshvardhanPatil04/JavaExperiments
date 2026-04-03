package Experiment4;

import java.sql.*;

public class Experiment4 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Product";
        String username = "root";
        String password = "Harsh270133Hardik";
        String query = "SELECT * FROM Product_Details";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("Pro_id") +
                        ", Name: " + rs.getString("Pro_name") +
                        ", Price: " + rs.getFloat("Pro_price"));
            }

            con.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}