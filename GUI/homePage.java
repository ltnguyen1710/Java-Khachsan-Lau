package GUI;

import BLL.BLLStaff;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import BLL.BLLRoom;

// giao dien thu ngan.
public class homePage extends JFrame {

    JPanel p1, p2, p3, p4;
    JButton b1, b2, b3, b4, b5,b6;
    JButton[] V = new JButton[7];
    JButton[] GD = new JButton[14];
    JButton[] DOI = new JButton[14];
    JButton[] DON = new JButton[21];
    int a = 1;
    int b = 8;
    int c = 22;
    int d = 36;
    String taikhoan;
    final int sodudau;
    FrameChangePassWd FCP = new FrameChangePassWd();
    FrameKhoaSo FKS = new FrameKhoaSo();
    RevenueInDay RID = new RevenueInDay();
    FrameDatPhong FDP = new FrameDatPhong();
    Login login = new Login();
    BLLStaff BLLstaff = new BLLStaff();
    Login log = new Login();
    FrameChangePassWd changePass = new FrameChangePassWd();
    BLLRoom bllroom = new BLLRoom();
    FrameDSDP DSDP = new FrameDSDP(); 

    homePage() {
        String inputDialog = JOptionPane.showInputDialog("SÔ DƯ ĐẦU ");
        sodudau = Integer.parseInt(inputDialog);
        DisPlay();
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    private void DisPlay() {
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\homepage.jpg")));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // khoi tao p1 va da ten panel
        p1 = new JPanel(new GridLayout(1, 0, 10, 10));
        p1.setBorder(BorderFactory.createTitledBorder(null, "Phong V.I.P",
                TitledBorder.CENTER, TitledBorder.CENTER, new Font("Brush Script Std", Font.PLAIN, 20), Color.YELLOW));
        p1.setBounds(50, 20, 700, 65);
        p1.setBackground(new Color(0, 0, 0, 0));
        add(p1);
        for (JButton i : V) {
            i = new JButton(String.valueOf(a++), new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\vip.png"));
            if (!bllroom.getTinhtrang(a - 1).equalsIgnoreCase("Trong")) {
                i.setBackground(Color.red);
            }
            p1.add(i);

            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
        // khoi tao p2 va dat ten panel
        p2 = new JPanel(null);
        p2.setBorder(BorderFactory.createTitledBorder(null, "Phong Gia Dinh",
                TitledBorder.CENTER, TitledBorder.CENTER, new Font("Brush Script Std", Font.PLAIN, 20), new Color(0, 204, 255)));
        p2.setBounds(50, 115, 700, 125);
        p2.setBackground(new Color(0, 0, 0, 0));

        for (JButton i : GD) {
            i = new JButton(String.valueOf(b++), new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\family.png"));
            if (!bllroom.getTinhtrang(b - 1).equalsIgnoreCase("Trong")) {
                i.setBackground(Color.red);
            }
            p2.add(i);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
        }
        p2.setLayout(new GridLayout(2, 7, 10, 10));
        add(p2);
        // khoi tao p3 va dat ten panel
        p3 = new JPanel(null);
        p3.setBorder(BorderFactory.createTitledBorder(null, "Phong Doi",
                TitledBorder.CENTER, TitledBorder.CENTER, new Font("Brush Script Std", Font.PLAIN, 20), new Color(255, 0, 255)));
        p3.setBounds(50, 270, 700, 125);
        p3.setBackground(new Color(0, 0, 0, 0));
        add(p3);

        for (JButton i : DOI) {
            i = new JButton(String.valueOf(c++), new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\couple.png"));
            if (!bllroom.getTinhtrang(c - 1).equalsIgnoreCase("Trong")) {
                i.setBackground(Color.red);
            }
            p3.add(i);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
        }
        p3.setLayout(new GridLayout(2, 7, 10, 10));
        // khoi tao p4 va dat ten panel
        p4 = new JPanel(null);
        p4.setBorder(BorderFactory.createTitledBorder(null, "Phong Don",
                TitledBorder.CENTER, TitledBorder.CENTER, new Font("Brush Script Std", Font.PLAIN, 20), new Color(255, 77, 77)));
        p4.setBounds(50, 425, 700, 180);
        p4.setBackground(new Color(0, 0, 0, 0));
        for (JButton i : DON) {
            i = new JButton(String.valueOf(d++), new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\single.png"));
            if (!bllroom.getTinhtrang(d - 1).equalsIgnoreCase("Trong")) {
                i.setBackground(Color.red);
            }
            p4.add(i);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

        p4.setLayout(new GridLayout(3, 7, 10, 10));
        add(p4);
        b1 = new JButton("Doi Mat Khau", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\sup.png"));
        b2 = new JButton("Khoa So", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\lock.png"));
        b3 = new JButton("Doanh Thu", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\list.png"));
        b4 = new JButton("Dat Phong", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\room.png"));
        b5 = new JButton("Dang Xuat", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\log-out.png"));
        b6 = new JButton("DS D.Phong", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\log-out.png"));
        b1.setBounds(1100, 20, 180, 80);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FCP.isVisible()) {
                    FCP.setTaikhoan(taikhoan);
                    FCP.setVisible(true);
                }
            }

        });
        b2.setBounds(1100, 120, 180, 80);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FKS.isVisible()) {
                    FKS.setSoDuDau(sodudau);
                    FKS.setVisible(true);
                }
            }

        });
        b3.setBounds(1100, 220, 180, 80);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!RID.isVisible()) {
                    RID.dumamay();
                    RID.setVisible(true);
                }
            }

        });
        b4.setBounds(1100, 320, 180, 80);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FDP.isVisible()) {
                    FDP.setVisible(true);
                }
            }

        });
        b6.setBounds(1100, 420, 180, 80);
        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (!DSDP.isVisible()) {
                    DSDP.setVisible(true);
                }
            }
        
        });
        b5.setBounds(1100, 520, 180, 80);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                if (!login.isVisible()) {
                    login.setVisible(true);
                }
            }

        });
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        setVisible(true);
    }

    public static void main(String[] args) {
        new homePage();

    }

}
