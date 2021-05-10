package GUI;

import java.awt.Font;
import javax.swing.*;

public class FrameInformationRoom extends JFrame {

    private JLabel Ten, ngayDat, ngayTra;
    private JLabel ID = new JLabel();

    FrameInformationRoom() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("THÔNG TIN PHÒNG");
        setLayout(null);
        setResizable(false);
        setBounds(450, 100, 400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ID.setFont(new Font(null, Font.BOLD, 30));
        ID.setBounds(70, 0, 300, 50);
        Ten = new JLabel("Tên Khách Hàng: ");
        Ten.setBounds(50, 60, 300, 30);
        ngayDat = new JLabel("Ngày Nhận Phòng: ");
        ngayDat.setBounds(50, 90, 300, 30);
        ngayTra = new JLabel("Ngày Trả Phòng: ");
        ngayTra.setBounds(50, 120, 300, 30);
        add(Ten);
        add(ngayTra);
        add(ID);
        add(ngayDat);
    }

    public void setNumber(String t) {
        ID.setText("Phòng số: " + t);
    }

    public void setTen(String t) {
        Ten.setText("Tên Khách Hàng: " + t);
    }

    public void setNgayDat(String t) {
        ngayDat.setText("Ngày nhạn phòng: " + t);
    }

    public void setngayTra(String t) {
        ngayTra.setText("Ngày trả Phòng: " + t);
    }
}
