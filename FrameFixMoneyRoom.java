package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class FrameFixMoneyRoom extends JFrame {

    private String room[] ={"V.I.P","FAMILY","COUPLE","SINGLE"}; 
    private JComboBox cb = new JComboBox(room);
    private JLabel ro,l1;
    private JTextField t1;
    private JButton b1,b2;

    FrameFixMoneyRoom() {
        DisPlay();
    }

    private void DisPlay() {
        setLayout(new FlowLayout());
        
        setBounds(470, 250, 300, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ro = new JLabel("ROOM");
        l1 = new JLabel("PRICE");
        t1 = new JTextField();
        t1.setPreferredSize(new Dimension(200,30));
        cb.setPreferredSize(new Dimension(200,30));
        b1 = new JButton("   OK   ");
        b2 = new JButton("CANCEL");
        add(ro);
        add(cb);
        add(l1);
        add(t1);
        add(b1);
        add(b2);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameFixMoneyRoom();
    }
}
