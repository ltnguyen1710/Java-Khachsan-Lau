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
import java.io.File;
import java.sql.Date;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrameKhoaSo extends JFrame {

    private JLabel l1, l2, l3, l4, l5;
    private JButton b1;
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
        JLabel title = new JLabel("KHÁCH SẠN LẬU");
        JLabel date = new JLabel(java.time.LocalDate.now().toString());
        l1 = new JLabel("Số Dư Đầu: ");
        l2 = new JLabel("Doanh Thu Ngày: ");
        l3 = new JLabel("Tiền Mặt: ");
        l4 = new JLabel("VISA: ");
        l5 = new JLabel("Dư Cuối Ca: ");
        b1 = new JButton("IN", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\printer.png"));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Them action 
                try {
                    Calendar c = Calendar.getInstance();
                    String localdate = java.time.LocalDate.now().toString();
                    Formatter f = new Formatter("C:\\Users\\Nghia\\Documents\\NetBeansProjects\\" + localdate + ".txt");
                    f.format("NGÀY: %tD%n", c);
                    f.format("DOANH THU: %s\nTIỀN MẶT: %s\nVISA: %s\n", BLLbd.getDthu(), BLLbd.getTienmat(), BLLbd.getVisa());
                    JOptionPane.showMessageDialog(null,"Sổ Đã Khóa");
                    f.close();
                } catch (Exception k) {
                    JOptionPane.showMessageDialog(null, "Lỗi Gòy");
                    System.out.println("Eror");
                }
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
        title.setBounds(110, 5, 250, 50);
        title.setFont(new Font(null, Font.BOLD, 20));
        date.setBounds(150, 40, 140, 40);
        l1.setBounds(50, 80, 200, 30);
        l2.setBounds(50, 110, 200, 30);
        l3.setBounds(50, 140, 200, 30);
        l4.setBounds(50, 170, 200, 30);
        l5.setBounds(50, 200, 200, 30);
        b1.setBounds(70, 250, 200, 40);
    }

    public void setSoDuDau(int t) {
        l1.setText("Số dư đầu:        " + t);
        int soducuoica = t + BLLbd.getDthu();
        l2.setText("Doanh Thu Ngày: " + BLLbd.getDthu());
        l3.setText("Tiền Mặt: " + BLLbd.getTienmat());
        l4.setText("VISA: " + BLLbd.getVisa());
        l5.setText("Dư Cuối Ca: " + soducuoica);

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
