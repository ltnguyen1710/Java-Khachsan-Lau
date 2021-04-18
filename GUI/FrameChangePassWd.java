/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameChangePassWd extends JFrame {

    private JLabel l1, l2, l3;
    private JTextField t1, t2, t3;
    private JButton b;

    FrameChangePassWd() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Change Password");
        
        setResizable(false);
        setBounds(450, 210, 300, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        l1 = new JLabel("Mat Khau cu :");
        l2 = new JLabel("Mat Khau moi:");
        l3 = new JLabel("Nhap Lai Mat Khau:");
        t1 = new JPasswordField();
        t2 = new JPasswordField();
        t3 = new JPasswordField();
        b = new JButton("Xac Nhan", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\checked.png"));
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
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
        setVisible(true);
    }
}
