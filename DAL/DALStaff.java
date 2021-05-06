package DAL;

import DTO.Staff;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DALStaff {

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

    public Vector<Staff> getVectorSta() {
        Vector<Staff> arrSta = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "SELECT* FROM NHANVIEN";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Staff sta = new Staff();
                    sta.setId(rs.getInt("IDNHANVIEN"));
                    sta.setTen(rs.getString("TEN"));
                    sta.setMatkhau(rs.getString("MK"));
                    sta.setNgaysinh(rs.getString("NGAYSINH"));
                    sta.setGioitinh(rs.getString("GIOITINH"));
                    sta.setNgayvaolam(rs.getString("NGAYVAOLAM"));
                    arrSta.add(sta);
                }
            } catch (Exception gS) {
                System.err.println(gS.getMessage());
            } finally {
                closeConnection();
            }
        }
        return arrSta;
    }

    public boolean addStaff(Staff sta) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, sta.getId());
                stmt.setString(2, sta.getMatkhau());
                stmt.setString(3, sta.getTen());
                stmt.setString(4, sta.getGioitinh());
                stmt.setString(5, sta.getNgaysinh());
                stmt.setString(6, sta.getNgayvaolam());
                if (stmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (Exception aS) {
                System.err.println(aS.getMessage());
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean checkLogin(int tk, String mk) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE IDNHANVIEN =" + tk + "  AND MK = '" + mk + "'";
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

    public boolean checkMKS(String mk) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE MK='" + mk + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception hS) {
                System.err.println(hS);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean changedPass(int idstaff, String newPass) {
        boolean result = false;
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE NHANVIEN SET MK = '" + newPass + "' WHERE IDNHANVIEN=" + idstaff + "");
            } catch (Exception hS) {
                System.err.println(hS);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean checkStaff(int idstaff) {
        boolean result = false;
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select * from nhanvien where idnhanvien=" + idstaff);
                result = rs.next();
            } catch (Exception hS) {
                System.err.println(hS);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean FixStaff(int idstaff, String mk, String name, String gioitinh, String ngaysinh, String ngayLam) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE nhanvien SET mk='" + mk + "', ten='" + name + "',gioitinh='" + gioitinh + "',ngaysinh='" + ngaysinh + "',ngayvaolam='" + ngayLam + "' WHERE idnhanvien=" + idstaff;
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

    public boolean DelStaff(int idstaff) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "DELETE FROM nhanvien WHERE idnhanvien = " + idstaff;
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

}
