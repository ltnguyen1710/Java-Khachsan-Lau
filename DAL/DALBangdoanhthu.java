/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.Bangdoanhthu;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author Holakaka
 */
public class DALBangdoanhthu {
     private Connection con;
     

    public  boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLKHACHSAN";
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
    public int getDthu() {
        int dthu=0;
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DBO.BANGDT() WHERE NGAY='" + java.time.LocalDate.now().toString() + "'");
                if (rs.next()) {
                    dthu= rs.getInt("DTNGAY");
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
            
        }
        return dthu;
    }
     
    public int getTienmat() {
        int tienMat=0;
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DBO.BANGDT() WHERE NGAY='" + java.time.LocalDate.now().toString() + "'");
                if (rs.next()) {
                    tienMat= rs.getInt("TIENMAT");
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
            
        }
        return tienMat;
    }

    public int getVisa() {
        int visa=0;
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DBO.BANGDT() WHERE NGAY='" + java.time.LocalDate.now().toString() + "'");
                if (rs.next()) {
                    visa= rs.getInt("MASTERCARD");
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
            
        }
        return visa;
    }
        public String getNgay() {
        String day="";
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DBO.BANGDT() WHERE NGAY='" + java.time.LocalDate.now().toString() + "'");
                if (rs.next()) {
                    day= rs.getString("NGAY");
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
            
        }
        return day;
    }
        public Vector<Bangdoanhthu> getBangdoanhthu(){
            Vector<Bangdoanhthu> bangdoanhthu = new Vector();
            if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DBO.BANGDT()");
                while (rs.next()) {
                    Bangdoanhthu doanhthu=new Bangdoanhthu();
                    doanhthu.setNgay(rs.getString("NGAY"));
                    doanhthu.setTienmat(rs.getInt("TIENMAT"));
                    doanhthu.setVisa(rs.getInt("MASTERCARD"));
                    doanhthu.setDthu(rs.getInt("DTNGAY"));
                    bangdoanhthu.add(doanhthu);
                }
                
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }            
        }
            return bangdoanhthu;
        }


}
