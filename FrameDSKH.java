package DesginDoAn;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameDSKH extends JFrame {
    private JLabel title;
    private JButton tim;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);

    FrameDSKH() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Danh Sach Khach Hang");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SACH KHACH HANG");
        title.setBounds(320,0,700,60);
        title.setFont(new Font(null,Font.BOLD,50));
        tim = new JButton("TIM");
        tim.setBounds(800,100,80,30);
        tb.setModel(model);
        model.addColumn("ID");
        model.addColumn("Ho & Ten");
        model.addColumn("Ngay Sinh");
        model.addColumn("Gioi Tinh");
        model.addColumn("Ngay thue");
        model.addColumn("Ngay tra");
        model.addColumn("Loai Phong");
        sp.setBounds(100,170, 1100, 500);
        add(title);
        add(sp);
        add(tim);

    }

    public static void main(String[] args) {
        new FrameDSKH();
    }
}
