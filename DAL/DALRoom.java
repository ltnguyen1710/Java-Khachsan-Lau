/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.Room;
import java.sql.*;
import java.util.Vector;

public class DALRoom {

    private Connection con;
    

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
    //lấy danh sách tất cả các phòng
    public Vector<Room> getRooms() {
       Vector<Room> rooms = new Vector();
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Seclect * from room");
                while (rs.next()) {
                    Room room = new Room();
                    room.setID(rs.getInt("idphong"));
                    room.setType(rs.getString("loaiphong"));
                    room.setStatus(rs.getString("tinhtrang"));
                    room.setPrice(rs.getInt("gia"));
                    rooms.add(room);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnection();
            }
        }
        return rooms;
    }
    //lây tình trạng phòng
    public boolean getTinhtrang(int sophong) {
        boolean result = false;
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select * from phong where idphong=" + sophong + " and tinhtrang='Trong'");
                result = rs.next();
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    
    //đặt tình trạng cho phòng
    public void setTinhtrang(int sophong) {
        if (openConnection()) {
            try {
                CallableStatement callst = con.prepareCall("{call setTinhtrang(?)}");
                callst.setInt(1, sophong);
                callst.execute();
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
    }
    //lay danh sach phong trong tu ngaydat toi ngaytra
    public Vector<Room> getPhongtrong(String ngaydat,String ngaytra){
        Vector<Room> rooms = new Vector();
         if (openConnection()) {
            try {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("Select * from fn_roomsInTime('"+ngaydat+"','"+ngaytra+"')");
                while(rs.next()){
                    Room room=new Room();
                    room.setID(rs.getInt("idphong"));
                    room.setType(rs.getString("loaiphong"));
                    room.setPrice(rs.getInt("gia"));
                    rooms.add(room);
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
        return rooms;
    }
    public void datphong(String idphong, String idkhach, int idnhanvien, String ngaydat, String ngaytra, int gia, int datra,String phuongthuc, String ngaytratien) {
        if (openConnection()) {
            try {
                CallableStatement callst = con.prepareCall("{call datphong(?,?,?,?,?,?,?,?,?)}");
                callst.setString(1, idphong);
                callst.setString(2, idkhach);
                callst.setInt(3, idnhanvien);
                callst.setString(4, ngaydat);
                callst.setString(5, ngaytra);
                callst.setInt(6, gia);
                callst.setInt(7, datra);
                callst.setString(8, phuongthuc);
                callst.setString(9, ngaytratien);
                callst.execute();
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
    }
    /*public void setPhongdathue(int sophong) {
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("Update phong set tinhtrang='Da thue' where sophong='" + sophong + "'");
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
    }

    public void setPhongtrong(int sophong) {
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("Update phong set tinhtrang='Trong' where sophong='" + sophong + "'");
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
    }*/
}
