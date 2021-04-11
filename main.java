
package Object;

import java.sql.*;
import java.util.Vector;

//nhớ add driver vào project rồi mới chạy 
public class main {
    
    static Connection con;
    static Vector<Room> rooms = new Vector();

    public static void main(String agrs[]) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLKhachsan";
            String username = "cop";
            String password = "cop123";
            con = DriverManager.getConnection(dbUrl, username, password);
            data();
            addtoDB();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    //ham nay de tao data cho cac doi tuong trong netbeans
    public static void data() {
        for (int i = 0; i < 56; i++) {
            if (i < 7) {
                VIP vip = new VIP();
                vip.setID(i + 1);
                vip.setPrice(2500);
                vip.setStatus("Trong");
                rooms.add(vip);
            }
            if (i >= 7 && i < 21) {
                Couple couple = new Couple();
                couple.setID(i + 1);
                couple.setPrice(1000);
                couple.setStatus("Trong");
                rooms.add(couple);
            }
            if (i >= 21 && i < 35) {
                Family fam = new Family();
                fam.setID(i + 1);
                fam.setPrice(1500);
                fam.setStatus("Trong");
                rooms.add(fam);
            }
            if (i >= 35) {
                Single sing = new Single();
                sing.setID(i + 1);
                sing.setPrice(200);
                sing.setStatus("Trong");
                rooms.add(sing);
            }
        }
    }
    //hàm này để thêm dữ liệu vừa tạo ở hàm data vào database (chỉ chạy 1 lần để thêm vào database)
    public static void addtoDB() {
        String sql = "insert into phong values(?,?,?,?)";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            for (int i = 0; i < 56; i++) {
                if(rooms.get(i) instanceof VIP){
                    prest.setInt(1, i+1);
                    prest.setString(2, "VIP");
                    prest.setString(3, rooms.get(i).getStatus());
                    prest.setInt(4, rooms.get(i).getPrice());
                    prest.executeUpdate();
                }
                if(rooms.get(i) instanceof Couple){
                    prest.setInt(1, i+1);
                    prest.setString(2, "Couple");
                    prest.setString(3, rooms.get(i).getStatus());
                    prest.setInt(4, rooms.get(i).getPrice());
                    prest.executeUpdate();
                }
                if(rooms.get(i) instanceof Family){
                    prest.setInt(1, i+1);
                    prest.setString(2, "Family");
                    prest.setString(3, rooms.get(i).getStatus());
                    prest.setInt(4, rooms.get(i).getPrice());
                    prest.executeUpdate();
                }
                if(rooms.get(i) instanceof Single){
                    prest.setInt(1, i+1);
                    prest.setString(2, "Single");
                    prest.setString(3, rooms.get(i).getStatus());
                    prest.setInt(4, rooms.get(i).getPrice());
                    prest.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
