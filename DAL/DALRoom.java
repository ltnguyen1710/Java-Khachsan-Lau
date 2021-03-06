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
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLKHACHSAN";
            String username = "nghia";
            String password = "nghiameow";
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
    public Vector<Room> getPhongtrong(String ngaynhan, String ngaytra) {
        Vector<Room> rooms = new Vector();
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select * from fn_roomsInTime('" + ngaynhan + "','" + ngaytra + "')");
                while (rs.next()) {
                    Room room = new Room();
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

    public void datphong(String idphong, String idkhach, int idnhanvien, String ngaydat, String ngaynhan, String ngaytra, int gia, int tralan1, String phuongthuc) {
        if (openConnection()) {
            try {
                CallableStatement callst = con.prepareCall("{call datphong(?,?,?,?,?,?,?,?,?)}");
                callst.setString(1, idphong);
                callst.setString(2, idkhach);
                callst.setInt(3, idnhanvien);
                callst.setString(4, ngaydat);
                callst.setString(5, ngaynhan);
                callst.setString(6, ngaytra);
                callst.setInt(7, gia);
                callst.setInt(8, tralan1);
                callst.setString(9, phuongthuc);
                callst.execute();
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
    }

    public int getGia(int sophong) {
        int gia = 0;
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select gia from phong where idphong='" + sophong + "'");
                if (rs.next()) {
                    gia = rs.getInt("gia");
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
        return gia;
    }

    public boolean changedGia(String loaiphong, int gia) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE PHONG SET GIA = '" + gia + "' WHERE LOAIPHONG='" + loaiphong + "'";
                Statement stmt = con.createStatement();
                if (stmt.executeUpdate(sql) >= 1) {
                    result = true;
                }
            } catch (Exception hS) {
                System.err.println(hS);
            } finally {
                closeConnection();
            }
        }
        return result;
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
