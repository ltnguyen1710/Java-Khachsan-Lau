package GUI;

import java.awt.Font;
import javax.swing.*;

public class FrameInformationRoom extends JFrame {

    private JLabel ngayDat, gia, ngayTra;
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
        ngayDat = new JLabel("Ngay Dat: ");
        ngayDat.setBounds(50,60,100,30);
        ngayTra = new JLabel("Ngay tra Phong: ");
        ngayTra.setBounds(50,90,150,30);
        gia = new JLabel("Gia tien Phong: ");
        gia.setBounds(50,120,150,30);
        add(ngayTra);
        add(ID);
        add(ngayDat);
        add(gia);
        setVisible(true);
    }
    public void setNumber(String t){
        ID.setText(t);
    }
    public static void main(String [] args){
        new FrameInformationRoom();
    }
}
