package desgin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    JButton b1, b2, b3;
    JLabel l, title, l1, l2, a;
    JPanel p;
    JTextField tk;
    JPasswordField mk;

    Login() {
        a = new JLabel();
        a.setBounds(750, 200, 350, 50);
        a.setFont(new Font(null, Font.BOLD, 20));
        title = new JLabel("Chao Mung Den Voi Trung Tam Khach San Lau Hai Ngoai");
        title.setBounds(220, 60, 1000, 40);
        title.setFont(new Font(null, Font.BOLD, 30));
        l = new JLabel("Dang Nhap Duoi Quyen");
        l.setBounds(525, 200, 400, 50);
        l.setFont(new Font(null, Font.BOLD, 20));

        b1 = new JButton("Admin");
        b2 = new JButton("Thu Ngan");
        b3 = new JButton("Dang Nhap");
        p = new JPanel();
        tk = new JTextField();
        mk = new JPasswordField();
        l1 = new JLabel("Tai khoan:");
        l2 = new JLabel("Mat Khau :");
        b1.setBounds(520, 250, 120, 30);
        b2.setBounds(640, 250, 120, 30);
        p.setBounds(490, 300, 300, 300);
        //l1.setbounds(10,10,);
        tk.setPreferredSize(new Dimension(200, 30));
        mk.setPreferredSize(new Dimension(200, 30));
        p.add(l1);
        p.add(tk);
        p.add(l2);
        p.add(mk);
        p.add(b3);
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                a.setText("Admin");
                l.setText("Dang Nhap Duoi Quyen ");
                a.setForeground(Color.RED);
                add(a);
                tk.setText(null);
                mk.setText(null);
                add(p);
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                a.setText("Thu Ngan");
                l.setText("Dang Nhap Duoi Quyen ");
                a.setForeground(Color.BLUE);
                add(a);
                tk.setText(null);
                mk.setText(null);
                add(p);
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
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }
}
