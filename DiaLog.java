package DesginDoAn;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class DiaLog {

    final static String DATE_FORMAT = "dd-MM-yyyy";
    JFrame f1, f2, f3, f4;

    DiaLog() {
        FrameDatPhong();
    }

    public void FramePassword() {
        f1 = new JFrame("Change Password");
        f1.setVisible(true);
        f1.setResizable(false);
        f1.setBounds(450, 210, 300, 2);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l1 = new JLabel("Mat Khau cu :");
        JLabel l2 = new JLabel("Mat Khau moi:");
        JLabel l3 = new JLabel("Nhap Lai Mat Khau:");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JButton b = new JButton("Xac Nhan");
        f1.add(l1);
        f1.add(t1);
        f1.add(l2);
        f1.add(t2);
        f1.add(l3);
        f1.add(t3);
        f1.add(b);
        l1.setBounds(45, 0, 200, 30);
        t1.setBounds(45, 35, 200, 30);
        l2.setBounds(45, 70, 200, 30);
        t2.setBounds(45, 105, 200, 30);
        l3.setBounds(45, 140, 200, 30);
        t3.setBounds(45, 175, 200, 30);
        b.setBounds(100, 220, 100, 30);
    }

    public void FrameKhoaSo() {
        f2 = new JFrame("Khoa So");
        f2.setVisible(true);
        f2.setResizable(false);
        f2.setBounds(450, 100, 400, 500);
        f2.setLayout(null);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Khach San Lau");
        JLabel date = new JLabel();
        JLabel l1 = new JLabel("So Du Dau: ");
        JLabel l2 = new JLabel("Doanh Thu Ngay: ");
        JLabel l3 = new JLabel("Tien Mat: ");
        JLabel l4 = new JLabel("VISA: ");
        JLabel l5 = new JLabel("Du Cuoi Ca: ");
        JButton b1 = new JButton("IN");
        JButton b2 = new JButton("DONG");
        f2.add(title);
        f2.add(date);
        f2.add(l1);
        f2.add(l2);
        f2.add(l3);
        f2.add(l4);
        f2.add(l5);
        f2.add(b1);
        f2.add(b2);
        title.setBounds(110, 5, 250, 50);
        title.setFont(new Font(null, Font.BOLD, 20));
        date.setText("20/10/2021");
        date.setBounds(150, 40, 140, 40);
        l1.setBounds(50, 80, 150, 30);
        l2.setBounds(50, 110, 150, 30);
        l3.setBounds(50, 140, 150, 30);
        l4.setBounds(50, 170, 150, 30);
        l5.setBounds(50, 200, 150, 30);
        b1.setBounds(90, 250, 100, 40);
        b2.setBounds(190, 250, 100, 40);

    }

    public void FrameDatPhong() {
        f3 = new JFrame("Dat Phong");
        f3.setVisible(true);
        //f3.setResizable(false);
        f3.setBounds(270, 20, 700, 600);
        f3.setLayout(null);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // tao 1 panel add 25 panel vao 1 panel
        JPanel pt = new JPanel(new GridLayout(6, 5));
        pt.setBounds(100, 100,500, 400);
        // ten danh nghiep
        JLabel title = new JLabel("Khach San Lau");
        title.setFont(new Font(null, Font.CENTER_BASELINE, 20));
        title.setBounds(300, 10,200, 30);
        JLabel dayNow = new JLabel("Ngay: "+java.time.LocalDate.now().toString());
        dayNow.setBounds(320,35,100,20);
        // tao 2 label va 2 text de nhap ngay vao.
        JLabel from = new JLabel("From");
        JLabel to = new JLabel("to");
        from.setBounds(250,60,40,20);
        JTextField from1 = new JTextField("dd/MM/YYYY");
        from1.setBounds(290,60,100,20);
        to.setBounds(390,60,20,20);
        JTextField to1 = new JTextField("dd/MM/YYYY");
        to1.setBounds(410,60,100,20);
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
        JPanel p10 = new JPanel(null);
        p10.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p11 = new JPanel();
        p11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p12 = new JPanel();
        p12.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p13 = new JPanel();
        p13.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p14 = new JPanel();
        p14.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p15 = new JPanel(null);
        p15.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p16 = new JPanel();
        p16.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p17 = new JPanel();
        p17.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p18 = new JPanel();
        p18.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p19 = new JPanel();
        p19.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p20 = new JPanel(null);
        p20.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p21 = new JPanel();
        p21.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p22 = new JPanel();
        p22.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p23 = new JPanel();
        p23.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p24 = new JPanel();
        p24.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel p25 = new JPanel(null);
        p25.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel l1 = new JLabel("Loai Phong");
        JLabel l2 = new JLabel("So Nguoi");
        JLabel l3 = new JLabel("Dich Vu");
        JLabel l4 = new JLabel("Gia");
        JLabel l5 = new JLabel("So Luong");
        JLabel l6 = new JLabel("Phong Don");
        JLabel l7 = new JLabel("Phong Doi");
        JLabel l8 = new JLabel("Phong Gia Dinh");
        JLabel l9 = new JLabel("Phong V.I.P");
        // create label add in panel
        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);
        p5.add(l5);
        p6.add(l6);
        p11.add(l7);
        p16.add(l8);
        p21.add(l9);
        String DichVu[] = {"Tron Goi", "Di Chuyen", "An Uong", "Khong"};
        JComboBox cb = new JComboBox(DichVu);
        JComboBox cb1 = new JComboBox(DichVu);
        JComboBox cb2 = new JComboBox(DichVu);
        JComboBox cb3 = new JComboBox(DichVu);
        p8.add(cb);
        p13.add(cb1);
        p18.add(cb2);
        p23.add(cb3);
        JLabel Single = new JLabel("Single");
        JLabel Family = new JLabel("Family");
        JLabel Couple = new JLabel("Couple");
        JLabel VIP = new JLabel("V.I.P");
        p9.add(Single);
        p14.add(Couple);
        p19.add(Family);
        p24.add(VIP);
        JButton b1 = new JButton("-");
        b1.setBounds(5,30,45,30);
        JLabel SLSingle = new JLabel("0",JLabel.CENTER);
        SLSingle.setBounds(43,10,10,10);
        JButton b2 = new JButton("+");
        b2.setBounds(50,30,45,30);
        p10.add(SLSingle);
        p10.add(b2);
        p10.add(b1);
        JButton b3 = new JButton("+");
        b3.setBounds(50,30,45,30);
        JLabel SLCouple = new JLabel("0");
        SLCouple.setBounds(43,10,10,10);
        JButton b4 = new JButton("-");
        b4.setBounds(5,30,45,30);
        p15.add(SLCouple);
        p15.add(b4);
        p15.add(b3);       
        JButton b5 = new JButton("+");
        b5.setBounds(50,30,45,30);
        JLabel SLFamily = new JLabel("0");
        SLFamily.setBounds(43,10,10,10);
        JButton b6 = new JButton("-");
        b6.setBounds(5,30,45,30);
        p20.add(SLFamily);
        p20.add(b6);
        p20.add(b5);       
        JButton b7 = new JButton("+");
        b7.setBounds(50,30,45,30);
        JLabel SLVIP = new JLabel("0");
        SLVIP.setBounds(43,10,10,10);
        JButton b8 = new JButton("-");
        b8.setBounds(5,30,45,30);
        p25.add(SLVIP);
        p25.add(b8);
        p25.add(b7);
        JRadioButton r1 = new JRadioButton("Tien Mat");
        r1.setBounds(120,400,100,30);
        JRadioButton r2 = new JRadioButton("Master Card");
        ButtonGroup bg = new ButtonGroup();
        JPanel tt = new JPanel();
        tt.setBorder(BorderFactory.createTitledBorder("Hinh Thuc Thanh Toan"));
        tt.setBounds(400,435,200,50);
        bg.add(r1);bg.add(r2);
        JLabel total = new JLabel("Tong Tien: ");
        total.setBounds(100,440,250,30);
        JButton DP = new JButton("DAT NGAY");
        DP.setBounds(100,500,500,40);
        f3.add(DP);
        f3.add(title);
        f3.add(dayNow);
        f3.add(from);
        f3.add(from1);
        f3.add(to);
        f3.add(to1);
        f3.add(total);
        f3.add(tt);
        f3.add(pt);
        tt.add(r1);
        tt.add(r2);
        pt.add(p1);
        pt.add(p2);
        pt.add(p3);
        pt.add(p4);
        pt.add(p5);
        pt.add(p6);
        pt.add(p7);
        pt.add(p8);
        pt.add(p9);
        pt.add(p10);
        pt.add(p11);
        pt.add(p12);
        pt.add(p13);
        pt.add(p14);
        pt.add(p15);
        pt.add(p16);
        pt.add(p17);
        pt.add(p18);
        pt.add(p19);
        pt.add(p20);
        pt.add(p21);
        pt.add(p22);
        pt.add(p23);
        pt.add(p24);
        pt.add(p25);

    }

    public void FrameInformationRoom(){
        
    }
    
    public boolean IsDateVaild(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public void DongHo(JLabel labelClock){
        try {
            while (true) {
                Calendar calendar = Calendar.getInstance();
                String hour = (calendar.getTime().getHours() > 9) ? 
                        "" + calendar.getTime().getHours() + ""
                        : "0" + calendar.getTime().getHours();
                String minute = (calendar.getTime().getMinutes() > 9) ? 
                        "" + calendar.getTime().getMinutes() + ""
                        : "0" + calendar.getTime().getMinutes();
                String second = (calendar.getTime().getSeconds() > 9) ? 
                        "" + calendar.getTime().getSeconds() + ""
                        : "0" + calendar.getTime().getSeconds();
                labelClock.setText(hour + ":" + minute + ":" + second);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new DiaLog();
    }
}
