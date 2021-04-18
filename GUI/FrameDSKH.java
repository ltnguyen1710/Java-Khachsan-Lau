package GUI;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameDSKH extends JFrame {

    private JLabel title, l1;
    private JTextField t1;
    private JButton tim;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);

    FrameDSKH() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Danh Sach Khach Hang");
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SACH KHACH HANG");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        l1 = new JLabel("CMND Khach Hang");
        l1.setBounds(380, 100, 200, 30);
        t1 = new JTextField();
        t1.setBounds(500, 100, 200, 30);
        tim = new JButton("TIM", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        tim.setBounds(720, 100, 120, 30);
        tb.setModel(model);
        model.addColumn("CMND");
        model.addColumn("Ho & Ten");
        model.addColumn("Ngay Sinh");
        model.addColumn("Gioi Tinh");
        model.addColumn("Ngay thue");
        model.addColumn("Ngay tra");
        model.addColumn("Loai Phong");
        model.addColumn("So Phong");
        sp.setBounds(100, 170, 1100, 500);
        add(title);
        add(sp);
        add(l1);
        add(t1);
        add(tim);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameDSKH();
    }
}
