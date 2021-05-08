package DAL;

import DTO.Customer;
import GUI.Login;
import java.sql.*;
import java.util.Vector;

public class DALCustomer {

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

    public Customer xuatcusID(String cmnd) {
        Customer cus = new Customer();
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM KHACH WHERE CMND='" + cmnd + "'");
                if (rs.next()) {
                    cus.setID(rs.getString("cmnd"));
                    cus.setName(rs.getString("ten"));
                    cus.setSex(rs.getString("gioitinh"));
                    cus.setDate(rs.getString("ngaysinh"));
                }
            } catch (Exception aC) {
                System.err.println(aC.getMessage());
            } finally {
                closeConnection();
            }
        }
        return cus;
    }
        public String tenCus(String cmnd) {
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT TEN  FROM KHACH WHERE CMND='" + cmnd + "'");
                if (rs.next()) {
                    return rs.getString("ten");
                }
            } catch (Exception aC) {
                System.err.println(aC.getMessage());
            } finally {
                closeConnection();
            }
        }
        return "";
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

    public Vector<Customer> getCustomerlist() {
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
                    cus.setDate(rs.getString("NGAYSINH"));
                    arrCus.add(cus);
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
                stmt.setString(4, cus.getDate());
                stmt.executeUpdate();
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
                String sql = "SELECT * FROM KHACH WHERE CMND='" + ID + "'";
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

    public boolean FixCus(String ID, String ten, String Sex, String date) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE KHACH SET ten = '" + ten + "', gioitinh='" + Sex + "', ngaysinh='" + date + "' WHERE cmnd='" + ID + "'";
                Statement stmt = con.createStatement();
                if (stmt.executeUpdate(sql) >= 1) {
                    result = true;
                }
            } catch (Exception hC) {
                System.err.println(hC);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean DelCus(String ID) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "DELETE FROM KHACH WHERE CMND='" + ID + "'";
                Statement stmt = con.createStatement();
                if (stmt.executeUpdate(sql) >= 1) {
                    result = true;
                }
            } catch (Exception hC) {
                System.err.println(hC);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
}
