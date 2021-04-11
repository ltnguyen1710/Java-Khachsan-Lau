package DesginDoAn;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RevenueInDay extends JFrame {

    private JLabel title;
    private JButton tim;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);

    RevenueInDay(){
        DisPlay();
    }
    
    private void DisPlay() {
        setTitle("Danh Sach Khach Hang");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SACH DOANH THU");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
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
        add(tim);
    }
    public static void main(String [] args){
        new RevenueInDay();
    }
}
