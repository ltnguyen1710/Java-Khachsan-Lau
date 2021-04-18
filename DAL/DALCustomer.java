package DAL;

import DTO.Customer;
import java.sql.*;
import java.util.Vector;

public class DALCustomer {

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

    public Vector<Customer> getVectorCus() {
        Vector<Customer> arrCus = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "SELECT* FROM KHACH";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Customer cus = new Customer();
                    cus.setID(rs.getString("CMND"));
                    cus.setName(rs.getString("TEN"));
                    cus.setSex(rs.getString("GIOITINH"));
                    cus.setDate(rs.getDate("NGAYSINH"));
                }

            } catch (Exception gC) {
                System.err.println(gC.getMessage());
            } finally {
                closeConnection();
            }
        }
        return arrCus;
    }

    public boolean addCus(Customer cus) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "INSERT INTO KHACH VALUES(?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cus.getID());
                stmt.setString(2, cus.getName());
                stmt.setString(3, cus.getSex());
                stmt.setDate(4, (Date) cus.getDate());
            } catch (Exception aC) {
                System.err.println(aC.getMessage());
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean hasCusID(String ID) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM KHACH WHERE IDKHACH=" + ID + "";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception hC) {
                System.err.println(hC);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
}
