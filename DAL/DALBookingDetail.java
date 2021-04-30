/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.BookingDetail;
import DTO.Room;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Utech
 */
public class DALBookingDetail {

    private Connection con;
    private Vector<BookingDetail> bookingdetaillist = new Vector();

    public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLKhachsan";
            String username = "HOLAKAKA";
            String password = "1";
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

    public Vector<BookingDetail> getbookingdetaillist() {
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from khach_datphong");
                while (rs.next()) {
                    BookingDetail bd = new BookingDetail();
                    bd.setIddatphong(rs.getInt("iddatphong"));
                    bd.setIdphong(rs.getString("idphong"));
                    bd.setIdkhach(rs.getInt("idkhach"));
                    bd.setIdnhanvien(rs.getInt("idnhanvien"));
                    bd.setNgaydat(rs.getDate("ngaydat"));
                    bd.setNgaytra(rs.getDate("ngaytra"));
                    bd.setGia(rs.getInt("gia"));
                    bd.setDatra(rs.getInt("datra"));
                    bookingdetaillist.add(bd);
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
        return bookingdetaillist;
    }

 
    
}
