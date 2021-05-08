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

    public boolean openConnection() {
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

    public Vector<BookingDetail> getbookingdetaillist() {
        Vector<BookingDetail> bookingdetaillist = new Vector();
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from khach_datphong where (tralan1+tralan2)< gia");
                while (rs.next()) {
                    BookingDetail bd = new BookingDetail();
                    bd.setIddatphong(rs.getInt("iddatphong"));
                    bd.setIdphong(rs.getString("idphong"));
                    bd.setIdkhach(rs.getString("idkhach"));
                    bd.setIdnhanvien(rs.getInt("idnhanvien"));
                    bd.setNgaydat(rs.getString("ngaydat"));
                    bd.setNgaytra(rs.getString("ngaytra"));
                    bd.setGia(rs.getInt("gia"));
                    bd.setTralan1(rs.getInt("tralan1"));
                    bd.setTralan2(rs.getInt("tralan2"));
                    bd.setNgaynhan(rs.getString("ngaynhan"));
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

    public void setDetailtrasau(String cmnd, String ngaynhan, String phuongthuc, int gia, String idphong) {
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("Update khach_datphong set phuongthucthanhtoan=concat(phuongthucthanhtoan,'," + phuongthuc + "')"
                        + " where phuongthucthanhtoan <> '" + phuongthuc + "' and idkhach='" + cmnd + "' and ngaynhan='" + ngaynhan + "' and len(phuongthucthanhtoan)<=11");
                stmt.executeUpdate("Update khach_datphong set tralan2=gia-tralan1 where idkhach='" + cmnd + "' and ngaynhan='" + ngaynhan + "' and gia>tralan1 and idphong='" + idphong + "'");
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
    }

    public void huy(String cmnd, String ngaynhan, String phuongthuc, int gia, String idphong) {
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("Update khach_datphong set phuongthucthanhtoan=concat(phuongthucthanhtoan,'," + phuongthuc + "')"
                        + " where phuongthucthanhtoan <> '" + phuongthuc + "' and idkhach='" + cmnd + "' and ngaynhan='" + ngaynhan + "' and len(phuongthucthanhtoan)<=11");
                stmt.executeUpdate("Update khach_datphong set gia=" + gia + " where idkhach='" + cmnd + "' and ngaynhan='" + ngaynhan + "' and idphong='" + idphong + "'");
                stmt.executeUpdate("Update khach_datphong set ngaytra='" + ngaynhan + "' where idkhach='" + cmnd + "' and ngaynhan='" + ngaynhan + "' and idphong='" + idphong + "'");
                stmt.executeUpdate("Update khach_datphong set tralan2=gia-tralan1 where idkhach='" + cmnd + "' and ngaynhan='" + ngaynhan + "' and gia>tralan1 and idphong='" + idphong + "'");
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
    }

    public BookingDetail thongtinphong(int sophong,String today) {
        BookingDetail bookdt = new BookingDetail();
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.INFOR_ROOM("+sophong+",'"+today+"')");
                if(rs.next()){
                    bookdt.setIdkhach(rs.getString("idkhach1"));
                    bookdt.setNgaynhan(rs.getString("ngaynhan1"));
                    bookdt.setNgaytra(rs.getString("ngaytra1"));                    
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
        return bookdt;
    }

    public void huy(String ngaynhan, String cmnd, String idphong) {
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("Delete from khach_datphong where ngaynhan='" + ngaynhan + "' and idkhach='" + cmnd + "' and idphong='" + idphong + "'");
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
    }

}
