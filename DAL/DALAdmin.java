package DAL;

import DTO.Admin;
import GUI.Login;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DALAdmin {

    private Connection con;

    public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLKhachsan";
            String username = "cop";
            String password = "cop123";
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
//   lay du lieu tu database
/*
    public Vector<Admin> getVectorAd() {
        Vector<Admin> arrAd = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "SELECT* FROM ADMIN";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Admin ad = new Admin();
                    ad.setId(rs.getInt("IDADMIN"));
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
        return arrAd;
    }
     */
//nhap du lieu vao database
/*
    public boolean addAd(Admin ad) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "INSERT INTO ADMIN VALUES(?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, ad.getId());
            } catch (Exception aA) {
                System.err.println(aA.getMessage());
            } finally {
                closeConnection();
            }
        }
        return result;
    }
     */
    public boolean checkLogin(String tk, String mk) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM ADMIN WHERE TKADMIN ='" + tk + "'  AND MKADMIN = '" + mk + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (SQLException aC) {
                System.err.println(aC.getMessage());
            } finally {
                closeConnection();
            }
        }
        return result;
    }
//kiem tra id ton tai
/*
    public boolean hasAdID(int ID) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM ADMIN WHERE IDADMIN=" + ID + "";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception hA) {
                System.err.println(hA);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
     */
}
