package com.cpllz.the16th.util.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

/**
 * @auther CPP
 * @date 2020/8/12 14:20
 */
public class JdbcTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://192.168.126.10:3306/ceshi", "root", "123456");
            ps = connection.prepareStatement("insert into demo1 values (101,?,?)");
            ps.setString(1, "caopu");

            InputStream in = new FileInputStream("D:\\111.jpg");
            ps.setBinaryStream(2, in);

            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (rs != null) {
                    ps.close();
                }
                if (rs != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
