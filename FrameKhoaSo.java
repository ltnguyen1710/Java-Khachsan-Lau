/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesginDoAn;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameKhoaSo extends JFrame {

    private JLabel l1, l2, l3, l4, l5;
    private JButton b1, b2;

    FrameKhoaSo() {
        DisPLay();
    }

    private void DisPLay() {
        setTitle("Khoa So");
        setVisible(true);
        setResizable(false);
        setBounds(450, 100, 400, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel title = new JLabel("Khach San Lau");
        JLabel date = new JLabel(java.time.LocalDate.now().toString());
        l1 = new JLabel("So Du Dau: ");
        l2 = new JLabel("Doanh Thu Ngay: ");
        l3 = new JLabel("Tien Mat: ");
        l4 = new JLabel("VISA: ");
        l5 = new JLabel("Du Cuoi Ca: ");
        b1 = new JButton("IN");
        b2 = new JButton("DONG");
        add(title);
        add(date);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(b1);
        add(b2);
        title.setBounds(110, 5, 250, 50);
        title.setFont(new Font(null, Font.BOLD, 20));
        date.setBounds(150, 40, 140, 40);
        l1.setBounds(50, 80, 150, 30);
        l2.setBounds(50, 110, 150, 30);
        l3.setBounds(50, 140, 150, 30);
        l4.setBounds(50, 170, 150, 30);
        l5.setBounds(50, 200, 150, 30);
        b1.setBounds(90, 250, 100, 40);
        b2.setBounds(190, 250, 100, 40);
    }
}