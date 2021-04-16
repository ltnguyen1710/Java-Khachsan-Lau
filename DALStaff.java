
package DAL;

import DTO.Customer;
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
                    sta.setNgaysinh(rs.getString("GIOITINH"));
                    sta.setNgayvaolam(rs.getDate("NGAYVAOLAM"));
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
                String sql = "INSERT INTO NHANVIEN VALUES(?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, sta.getId());
                stmt.setString(2, sta.getTen());
                stmt.setString(3, sta.getNgaysinh());
                stmt.setDate(4, (Date) sta.getNgayvaolam());
            } catch (Exception aS) {
                System.err.println(aS.getMessage());
            } finally {
                closeConnection();
            }
        }
        return result;
    }
            public boolean hasStaID(int ID) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM NHANVIEN WHERE IDNHANVIEN=" + ID + "";
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
}
