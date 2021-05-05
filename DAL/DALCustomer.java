package DAL;

import DTO.Customer;
import GUI.Login;
import java.sql.*;
import java.util.Vector;

public class DALCustomer {

    private Connection con;
    private Vector<Customer> customer = new Vector();
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

    public Customer xuatcusID(String cmnd) {
        Customer cus = new Customer();
        if (openConnection()) {
            try {
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM KHACH WHERE CMND='"+cmnd+"'");
               if(rs.next()){
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
        public Vector<Customer> getCustomerlist() {
        if (openConnection()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from khach");
                while (rs.next()) {
                    Customer cus = new Customer();
                    cus.setID(rs.getString("cmnd"));
                    cus.setName(rs.getString("ten"));
                    cus.setSex(rs.getString("gioitinh"));
                    cus.setDate(rs.getString("ngaysinh"));
                    customer.add(cus);
                }
            } catch (Exception gA) {
                System.err.println(gA.getMessage());
            } finally {
                closeConnection();
            }
        }
        return customer;
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
                String sql = "SELECT * FROM KHACH WHERE CMND=" + ID + "";
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
