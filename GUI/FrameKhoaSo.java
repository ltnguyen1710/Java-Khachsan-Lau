/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLLBangdoanhthu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrameKhoaSo extends JFrame {

    private JLabel l1, l2, l3, l4, l5;
    private JButton b1, b2;
    private BLLBangdoanhthu BLLbd = new BLLBangdoanhthu();

    FrameKhoaSo() {
        
        DisPLay();
        
    }

    private void DisPLay() {
        setTitle("Khoa So");

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
        b1 = new JButton("IN", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\printer.png"));
        b2 = new JButton("KHOA SO", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\lock.png"));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Them action 
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Them action 
            }
        });
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
        l1.setBounds(50, 80, 200, 30);
        l2.setBounds(50, 110, 200, 30);
        l3.setBounds(50, 140, 200, 30);
        l4.setBounds(50, 170, 200, 30);
        l5.setBounds(50, 200, 200, 30);
        b1.setBounds(70, 250, 120, 40);
        b2.setBounds(190, 250, 120, 40);
    }

    public void setSoDuDau(int t) {
        l1.setText("Số dư đầu:        " + t);
        int soducuoica=t+BLLbd.getDthu();
        l2.setText("Doanh Thu Ngay: "+BLLbd.getDthu());
        l3.setText("Tien Mat: "+BLLbd.getTienmat());
        l4.setText("VISA: "+BLLbd.getVisa());
        l5.setText("Du Cuoi Ca: "+soducuoica);
        
    }

    public void setDTNgay(Date t) {
        l2.setText(l2.getText() + t);
    }

    public void setTienMat(int t) {
        l3.setText(l3.getText() + t);
    }

    public void setMasterCard(int t) {
        l4.setText(l4.getText() + t);
    }

    public void setDuCuoiCa(int t) {
        l5.setText(l5.getText() + t);
    }

}
