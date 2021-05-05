package GUI;

import java.awt.Font;
import javax.swing.*;

public class FrameInformationRoom extends JFrame {

    private JLabel Ten,ngayDat, gia, ngayTra;
    private JLabel ID = new JLabel();

    FrameInformationRoom() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Thong Tin Phong");
        setLayout(null);
        setResizable(false);
        setBounds(450, 100, 400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ID.setFont(new Font(null,Font.BOLD,30));
        ID.setBounds(70,0,300,50);
        Ten = new JLabel("Ten Khach Hang: ");
        Ten.setBounds(50,60,300,30);
        ngayDat = new JLabel("Ngay Dat: ");
        ngayDat.setBounds(50,90,300,30);
        ngayTra = new JLabel("Ngay tra Phong: ");
        ngayTra.setBounds(50,120,300,30);
        gia = new JLabel("Gia tien Phong: ");
        gia.setBounds(50,150,300,30);
        add(Ten);
        add(ngayTra);
        add(ID);
        add(ngayDat);
        add(gia);
    }
    public void setNumber(String t){
        ID.setText("Phong So: "+t);
    }
    public void setTen(String t){
        Ten.setText(Ten.getText() + t);
    }
    public void setNgayDat(String t){
        ngayDat.setText(ngayDat.getText() + t);
    }
    public void setngayTra(String t){
        ngayTra.setText(ngayTra.getText()+ t);
    }
    public void setGia(String t){
        gia.setText(gia.getText()+ t);
    }
}
