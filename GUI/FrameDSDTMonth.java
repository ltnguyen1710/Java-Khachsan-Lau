
package GUI;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class FrameDSDTMonth extends JFrame{
    
  private JLabel title;
    private JButton tim;
    private JTextField t1;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);

    FrameDSDTMonth(){
        DisPlay();
    }
    
    private void DisPlay() {
        setTitle("Danh Sach Doanh Thu");
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SACH DOANH THU");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        tb.setModel(model);
        model.addColumn("Thang");
        model.addColumn("Tien Mat");
        model.addColumn("Master Card");
        model.addColumn("Tong Tien");
        sp.setBounds(200, 170, 900, 400);
        tim = new JButton("IN DANH SACH", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\printer.png"));
        tim.setBounds(200, 600, 900, 30);
        add(title);
        add(sp);
        add(tim);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public static void main(String [] args){
        new FrameDSDTMonth();
    }  
}
