package GUI;

import GUI.homePage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JButton b1, b2, b3, b4;
    private JLabel l, title, l1, l2, a;
    private JPanel p1, p2;
    private JTextField tkAd, tkStaff;
    private JTextField mkAd, mkStaff;

    Login() {
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\login2.jpg")));
        a = new JLabel();
        a.setBounds(750, 200, 350, 50);
        a.setFont(new Font(null, Font.BOLD, 20));
        title = new JLabel("Chao Mung Den Voi Trung Tam Khach San Lau Hai Ngoai");
        title.setBounds(220, 60, 1000, 40);
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setForeground(Color.yellow);
        l = new JLabel("Dang Nhap Duoi Quyen");
        l.setBounds(525, 200, 400, 50);
        l.setFont(new Font(null, Font.BOLD, 20));
        l.setForeground(Color.white);
        b1 = new JButton("Admin", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\staff.png"));
        b2 = new JButton("Thu Ngan", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\staff1.png"));
        b3 = new JButton("Dang Nhap");
        b4 = new JButton("Thoat");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new homePage();
                setVisible(false);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Login().setVisible(true);
                setVisible(false);
            }

        });
        p1 = new JPanel();
        p2 = new JPanel();
        tkAd = new JTextField();
        mkAd = new JPasswordField();
        tkStaff = new JTextField();
        mkStaff = new JPasswordField();
        l1 = new JLabel("Tai khoan:");
        l2 = new JLabel("Mat Khau :");
        b1.setBounds(480, 250, 150, 60);
        b2.setBounds(640, 250, 150, 60);
        p1.setBounds(490, 320, 300, 300);
        p2.setBounds(490, 320, 300, 300);

        //l1.setbounds(10,10,);
        tkAd.setPreferredSize(new Dimension(200, 30));
        mkAd.setPreferredSize(new Dimension(200, 30));
        tkStaff.setPreferredSize(new Dimension(200, 30));
        mkStaff.setPreferredSize(new Dimension(200, 30));

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p1.revalidate();
                a.setText("Admin");
                l.setText("Dang Nhap Duoi Quyen ");
                a.setForeground(Color.RED);
                add(a);
                tkAd.setText(null);
                mkAd.setText(null);
                p1.add(l1);
                p1.add(tkAd);
                p1.add(l2);
                p1.add(mkAd);
                p1.add(b3);
                p1.add(b4);
                b2.setEnabled(false);
                add(p1);
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p2.revalidate();
                a.setText("Thu Ngan");
                l.setText("Dang Nhap Duoi Quyen ");
                a.setForeground(Color.BLUE);
                add(a);
                tkStaff.setText(null);
                mkStaff.setText(null);
                p2.add(l1);
                p2.add(tkStaff);
                p2.add(l2);
                p2.add(mkStaff);
                p2.add(b3);
                p2.add(b4);
                b1.setEnabled(false);
                add(p2);
            }
        });

        add(title);
        add(l);
        add(b1);
        add(b2);
        setTitle("Trung Tam Khach San Lau Hai Ngoai");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new Login().setVisible(true);
    }
}
