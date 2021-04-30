package GUI;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BLL.BLLBangdoanhthu;
import DTO.Bangdoanhthu;
import java.util.Vector;

public class RevenueInDay extends JFrame {

    private JLabel title, l1;
    private JButton tim;
    private JTextField t1;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);
    BLLBangdoanhthu BLLbdt = new BLLBangdoanhthu();
    Vector<Bangdoanhthu> bangdoanhthu = new Vector();

    RevenueInDay() {
        DisPlay();
        
    }

    private void DisPlay() {
        setTitle("Danh Sach Doanh Thu");
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SACH DOANH THU");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        l1 = new JLabel("Nhap Ngay Doanh Thu");
        l1.setBounds(350, 100, 200, 30);
        t1 = new JTextField();
        t1.setBounds(500, 100, 200, 30);
        tim = new JButton("TIM", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        tim.setBounds(710, 100, 80, 30);
        tb.setModel(model);
        model.addColumn("NGÀY");
        model.addColumn("TIỀN MẶT");
        model.addColumn("VISA");
        model.addColumn("DOANH THU NGÀY");
        bangdoanhthu = BLLbdt.getBangdoanhthu();
        for (Bangdoanhthu i : bangdoanhthu) {

            model.addRow(new Object[]{
                i.getNgay(), i.getTienmat(), i.getVisa(), i.getDthu()
            });
        }
        sp.setBounds(200, 170, 900, 500);
        add(title);
        add(sp);
        add(l1);
        add(t1);
        add(tim);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public void dumamay() {
        
        System.out.println(bangdoanhthu);
    }

    public static void main(String[] args) {
        new RevenueInDay();
    }
}
