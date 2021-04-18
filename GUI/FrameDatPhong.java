package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FrameDatPhong extends JFrame {

    private JButton b1, b2, b3, b4, b5, b6, b7, b8;
    private JLabel l1, l2, l4, l5, l6, l7, l8, l9, total;
    private JLabel SoPDon = new JLabel("2");
    private JLabel SoPDoi = new JLabel("3");
    private JLabel SoPGD = new JLabel("4");
    private JLabel SoPVIP = new JLabel("5");
    private JLabel GiaSingle = new JLabel("0000");
    private JLabel GiaCouple = new JLabel("0000");
    private JLabel GiaFamily = new JLabel("0000");
    private JLabel GiaVIP = new JLabel("0000");
    public JTextField from1, to1;
    JRadioButton r1, r2;
    ButtonGroup bg = new ButtonGroup();

    FrameDatPhong() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Dat Phong");
        setResizable(false);
        setBounds(270, 20, 700, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // tao 1 panel add 25 panel vao 1 panel
        JPanel pt = new JPanel(new GridLayout(6, 5));
        pt.setBounds(100, 100, 500, 400);
        // ten danh nghiep
        JLabel title = new JLabel("Khach San Lau");
        title.setFont(new Font(null, Font.CENTER_BASELINE, 20));
        title.setBounds(290, 10, 200, 30);
        JLabel dayNow = new JLabel("Ngay: " + java.time.LocalDate.now().toString());
        dayNow.setBounds(310, 35, 100, 20);
        // tao 2 label va 2 text de nhap ngay vao.
        JLabel from = new JLabel("From");
        JLabel to = new JLabel("to");
        from.setBounds(220, 60, 40, 20);
        from1 = new JTextField();
        from1.setBounds(260, 60, 100, 20);
        from1.setToolTipText("dd/MM/YYYY");
        to.setBounds(360, 60, 20, 20);
        to1 = new JTextField();
        to1.setBounds(380, 60, 100, 20);
        to1.setToolTipText("dd/MM/YYYY");
        JPanel p1 = new JPanel();
        p1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p3 = new JPanel();
        p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p4 = new JPanel();
        p4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p5 = new JPanel();
        p5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p6 = new JPanel();
        p6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p7 = new JPanel();
        p7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p8 = new JPanel();
        p8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p9 = new JPanel();
        p9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p10 = new JPanel();
        p10.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p11 = new JPanel();
        p11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p12 = new JPanel();
        p12.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p13 = new JPanel();
        p13.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p14 = new JPanel();
        p14.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p15 = new JPanel();
        p15.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p16 = new JPanel();
        p16.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p17 = new JPanel();
        p17.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p18 = new JPanel();
        p18.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p19 = new JPanel();
        p19.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p20 = new JPanel();
        p20.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p21 = new JPanel();
        p21.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p22 = new JPanel();
        p22.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p23 = new JPanel();
        p23.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p24 = new JPanel();
        p24.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p25 = new JPanel();
        p25.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        l1 = new JLabel("Loai Phong", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\home.png"), JLabel.CENTER);
        l2 = new JLabel("So Phong", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\one.png"), JLabel.CENTER);
        l4 = new JLabel("Gia", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\pricing.png"), JLabel.CENTER);
        l5 = new JLabel("Chon Phong", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\room.png"), JLabel.CENTER);
        l6 = new JLabel("Don", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\single.png"), JLabel.CENTER);
        l7 = new JLabel("Doi", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\couple.png"), JLabel.CENTER);
        l8 = new JLabel("Gia Dinh", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\family.png"), JLabel.CENTER);
        l9 = new JLabel("V.I.P", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\vip.png"), JLabel.CENTER);
        // create label add in panel
        p1.add(l1);
        p2.add(l2);
        p4.add(l4);
        p5.add(l5);
        p6.add(l6);
        p7.add(SoPDon);
        p11.add(l7);
        p12.add(SoPDoi);
        p16.add(l8);
        p17.add(SoPGD);
        p21.add(l9);
        p22.add(SoPVIP);
        p9.add(GiaSingle);
        p14.add(GiaCouple);
        p19.add(GiaFamily);
        p24.add(GiaVIP);
        b1 = new JButton("Chon", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\plus.png"));
        p10.add(b1);
        b3 = new JButton("Chon", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\plus.png"));
        p15.add(b3);
        b5 = new JButton("Chon", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\plus.png"));
        p20.add(b5);
        b7 = new JButton("Chon", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\plus.png"));
        p25.add(b7);
        r1 = new JRadioButton("Tien Mat");
        r1.setBounds(120, 400, 100, 30);
        r2 = new JRadioButton("Master Card");
        JPanel tt = new JPanel();
        tt.setBorder(BorderFactory.createTitledBorder(null,"Hinh Thuc Thanh Toan",TitledBorder.CENTER,TitledBorder.CENTER,null,new Color(255, 64, 0)));
        tt.setBounds(400, 435, 200, 50);
        bg.add(r1);
        bg.add(r2);
        total = new JLabel("Tong Tien: ");
        total.setBounds(100, 440, 250, 30);
        JButton DP = new JButton("DAT NGAY");
        DP.setBounds(100, 500, 500, 40);
        DP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormCustomer();
            }

        });
        add(DP);
        add(title);
        add(dayNow);
        add(from);
        add(from1);
        add(to);
        add(to1);
        add(total);
        add(tt);
        add(pt);
        tt.add(r1);
        tt.add(r2);
        pt.add(p1);
        pt.add(p2);
        pt.add(p4);
        pt.add(p5);
        pt.add(p6);
        pt.add(p7);
        pt.add(p9);
        pt.add(p10);
        pt.add(p11);
        pt.add(p12);
        pt.add(p14);
        pt.add(p15);
        pt.add(p16);
        pt.add(p17);
        pt.add(p19);
        pt.add(p20);
        pt.add(p21);
        pt.add(p22);
        pt.add(p24);
        pt.add(p25);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameDatPhong();
    }
}
