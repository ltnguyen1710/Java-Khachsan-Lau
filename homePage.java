package desgin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// giao dien thu ngan.
public class homePage extends JFrame {

    JPanel p1, p2, p3, p4;
    JButton b1, b2, b3, b4, b5;
    JButton[] V = new JButton[7];
    JButton[] GD = new JButton[14];
    JButton[] DOI = new JButton[14];
    JButton[] DON = new JButton[21];

    homePage() {
        DisPlay();
    }

    private void DisPlay() {
        // khoi tao p1 va da ten panel
        p1 = new JPanel(null);
        p1.setBorder(BorderFactory.createTitledBorder("Phong V.I.P"));
        p1.setBounds(50, 20, 700, 65);
        add(p1);
        int a = 1;
        for (JButton i : V) {
            i = new JButton(String.valueOf(a++));
            p1.add(i);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showInputDialog(null, "thang ngu");
                }
            });
        }
        p1.setLayout(new GridLayout(1, 0, 10, 10));
        // khoi tao p2 va dat ten panel
        p2 = new JPanel(null);
        p2.setBorder(BorderFactory.createTitledBorder("Phong Gia Dinh"));
        p2.setBounds(50, 115, 700, 125);
        int b = 1;
        for (JButton i : GD) {
            i = new JButton(String.valueOf(b++));
            p2.add(i);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showInputDialog(null, "thang ngu");
                }
            });
        }
        p2.setLayout(new GridLayout(2, 7, 10, 10));
        add(p2);
        // khoi tao p3 va dat ten panel
        p3 = new JPanel(null);
        p3.setBorder(BorderFactory.createTitledBorder("Phong Doi"));
        p3.setBounds(50, 270, 700, 125);
        add(p3);
        int c = 1;
        for (JButton i : DOI) {
            i = new JButton(String.valueOf(c++));
            p3.add(i);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showInputDialog(null, "thang ngu");
                }
            });
        }
        p3.setLayout(new GridLayout(2, 7, 10, 10));
        // khoi tao p4 va dat ten panel
        p4 = new JPanel(null);
        p4.setBorder(BorderFactory.createTitledBorder("Phong Don"));
        p4.setBounds(50, 425, 700, 180);
        int d = 1;
        for (JButton i : DON) {
            i = new JButton(String.valueOf(d++));
            p4.add(i);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showInputDialog(null, "thang ngu");
                }
            });
        }
        
        
        p4.setLayout(new GridLayout(3, 7, 10, 10));
        add(p4);
        b1 = new JButton("Doi Mat Khau");
        b2 = new JButton("Khoa So");
        b3 = new JButton("Doanh Thu Trong Ngay");
        b4 = new JButton("Dat Phong");
        b5 = new JButton("Dang Xuat");
        b1.setBounds(1100,20,180,80);
        b2.setBounds(1100,140,180,80);
        b3.setBounds(1100,260,180,80);
        b4.setBounds(1100,380,180,80);
        b5.setBounds(1100,500,180,80);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
    }

    public static void main(String[] args) {
        new homePage();

    }
}
