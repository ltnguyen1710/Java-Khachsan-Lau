package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameDSKH extends JFrame {

    private JLabel title, l1, name1, CMND1, sex, date1;
    private String sex1[] = {"NAM", "NU"};
    private String l[] = {"VIP", "Family", "Couple", "Single"};
    private JComboBox KOfRoom = new JComboBox(l);
    private JComboBox cb = new JComboBox(sex1);
    private JPanel p;
    private JTextField t1, name, CMND, RentDay, PayDay, date, NumRoom;
    private JButton tim, FIX, De;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);

    FrameDSKH() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Danh sách khách hàng");
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SÁCH KHÁCH HÀNG");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        l1 = new JLabel("CMND KHÁCH HÀNG");
        l1.setBounds(380, 100, 200, 30);
        t1 = new JTextField();
        t1.setBounds(500, 100, 200, 30);
        tim = new JButton("TÌM", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        tim.setBounds(720, 100, 120, 30);
        tb.setModel(model);
        model.addColumn("CMND");
        model.addColumn("Họ và Tên");
        model.addColumn("Ngày Sinh");
        model.addColumn("Giới Tính");
        sp.setBounds(50, 170, 800, 500);
        add(title);
        add(sp);
        add(l1);
        add(t1);
        add(tim);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        p = new JPanel(null);
        p.setBounds(900, 170, 310, 500);
        p.setBorder(BorderFactory.createTitledBorder("FIX & DELETE CUSTOMER"));
        CMND1 = new JLabel("CMND");
        CMND1.setBounds(5, 20, 90, 30);
        CMND = new JTextField();
        CMND.setBounds(100, 20, 200, 30);
        name1 = new JLabel("Họ và Tên");
        name1.setBounds(5, 50, 90, 30);
        name = new JTextField();
        name.setBounds(100, 50, 200, 30);
        sex = new JLabel("Giới Tính");
        sex.setBounds(5, 80, 90, 30);
        cb.setBounds(100, 80, 100, 30);
        date1 = new JLabel("Ngày sinh");
        date1.setBounds(5, 110, 90, 30);
        date = new JTextField();
        date.setBounds(100, 110, 200, 30);

        FIX = new JButton("SỬA");
        FIX.setBounds(80, 270, 100, 30);
        De = new JButton("XÓA");
        De.setBounds(180, 270, 100, 30);
        add(p);
        p.add(name1);
        p.add(name);
        p.add(CMND1);
        p.add(CMND);
        p.add(sex);
        p.add(cb);
        p.add(date1);
        p.add(date);
        p.add(FIX);
        p.add(De);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameDSKH();
    }
}
