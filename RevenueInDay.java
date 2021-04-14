package GUI;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RevenueInDay extends JFrame {

    private JLabel title,l1;
    private JButton tim;
    private JTextField t1;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);

    RevenueInDay(){
        DisPlay();
    }
    
    private void DisPlay() {
        setTitle("Danh Sach Doanh Thu");
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SACH DOANH THU");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        l1 = new JLabel("Nhap Ngay Doanh Thu");
        l1.setBounds(350,100,200,30);
        t1 = new JTextField();
        t1.setBounds(500,100,200,30);
        tim = new JButton("TIM");
        tim.setBounds(800, 100, 80, 30);
        tb.setModel(model);
        model.addColumn("Doanh Thu ngay");
        model.addColumn("So du dau ca");
        model.addColumn("Tien Mat");
        model.addColumn("Master Card");
        model.addColumn("So Du cuoi ca");
        sp.setBounds(200, 170, 900, 500);
        add(title);
        add(sp);
        add(l1);
        add(t1);
        add(tim);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public static void main(String [] args){
        new RevenueInDay();
    }
}
