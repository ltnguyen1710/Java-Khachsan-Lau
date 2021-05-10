/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLLStaff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameChangePassWd extends JFrame {

    String taikhoan;
    Login log = new Login();
    BLLStaff BLLstaff = new BLLStaff();
    private JLabel l1, l2, l3;
    public JTextField t1, t2, t3;
    private JButton b;

    FrameChangePassWd() {
        DisPlay();
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    private void DisPlay() {
        setTitle("Thay đổi Mật Khẩu");

        setResizable(false);
        setBounds(450, 210, 300, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        l1 = new JLabel("Mật khẩu cũ:");
        l2 = new JLabel("Mật khẩu mới:");
        l3 = new JLabel("Nhập lại mật khẩu:");
        t1 = new JPasswordField();
        t2 = new JPasswordField();
        t3 = new JPasswordField();
        b = new JButton("Xác Nhận", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\checked.png"));
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, BLLstaff.ChangedPassStaff(Integer.parseInt(taikhoan), t1.getText(), t2.getText(), t3.getText()));

                }catch (NullPointerException b){
                    JOptionPane.showMessageDialog(null,"PHẢI ĐIỀN ĐẦY ĐỦ THÔNG TIN");
                }
            }

        });
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b);
        l1.setBounds(45, 0, 200, 30);
        t1.setBounds(45, 35, 200, 30);
        l2.setBounds(45, 70, 200, 30);
        t2.setBounds(45, 105, 200, 30);
        l3.setBounds(45, 140, 200, 30);
        t3.setBounds(45, 175, 200, 30);
        b.setBounds(70, 220, 150, 30);

    }
    
}
