package GUI;

import BLL.BLLStaff;
import BLL.BLLAdmin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    BLLStaff BLLStaff = new BLLStaff();
    BLLAdmin BLLad = new BLLAdmin();
    private JButton b1, b2, b3, b4;
    private JLabel l, title, l1, l2, a;
    private JPanel p;
    public JTextField tk;
    public JTextField mk;

    public Login() {
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\login2.jpg")));
        a = new JLabel();
        a.setBounds(750, 200, 350, 50);
        a.setFont(new Font(null, Font.BOLD, 20));
        title = new JLabel("CHÀO MỪNG ĐẾN VỚI KHÁCH SẠN LẬU HẢI NGOẠI");
        title.setBounds(240, 80, 1000, 40);
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setForeground(Color.yellow);
        l = new JLabel("Đăng Nhập Dưới Quyền");
        l.setBounds(525, 200, 400, 50);
        l.setFont(new Font(null, Font.BOLD, 20));
        l.setForeground(Color.white);
        b1 = new JButton("Admin", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\staff.png"));
        b2 = new JButton("Thu ngân", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\staff1.png"));
        b3 = new JButton("Đăng nhập");
        b4 = new JButton("Đăng nhập");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BLLStaff.ChecklogStaff(Integer.parseInt(tk.getText()), mk.getText())) {
                    new homePage(tk.getText());
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
                }

            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BLLad.Checklog(tk.getText(), mk.getText())) {
                    new HomePageAdmin();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
                }

            }

        });
        p = new JPanel();

        tk = new JTextField();
        mk = new JPasswordField();

        l1 = new JLabel("Tài Khoản:");
        l2 = new JLabel("Mật Khẩu:");
        b1.setBounds(480, 250, 150, 60);
        b2.setBounds(640, 250, 150, 60);
        p.setBounds(490, 320, 300, 300);

        p.add(l1);
        p.add(tk);
        p.add(l2);
        p.add(mk);

        //l1.setbounds(10,10,);
        tk.setPreferredSize(new Dimension(200, 30));
        mk.setPreferredSize(new Dimension(200, 30));

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                a.setText("Admin");
                l.setText("Đăng Nhập Dưới Quyền  ");
                a.setForeground(Color.RED);
                add(a);
                tk.setText(null);
                mk.setText(null);

                b3.setVisible(false);
                p.add(b4);
                b4.setVisible(true);
                add(p);
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                a.setText("Thu Ngân");
                l.setText("Đăng Nhập Dưới Quyền ");
                a.setForeground(Color.BLUE);
                add(a);
                tk.setText(null);
                mk.setText(null);

                b4.setVisible(false);
                p.add(b3);
                b3.setVisible(true);
                add(p);
            }
        });
        add(title);
        add(l);
        add(b1);
        add(b2);
        setTitle("TRUNG TÂM KHÁCH SẠN LẬU HẢI NGOẠI");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {

        new Login().setVisible(true);
    }
}
