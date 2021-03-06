package GUI;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BLL.BLLBangdoanhthu;
import DTO.Bangdoanhthu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setTitle("Danh sách doanh thu");
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SÁCH DOANH THU");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        l1 = new JLabel("Nhập ngày doanh thu");
        l1.setBounds(350, 100, 200, 30);
        t1 = new JTextField();
        t1.setBounds(500, 100, 200, 30);
        tim = new JButton("Tìm", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        tim.setBounds(710, 100, 80, 30);
        tim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t1.getText().equals("")) {
                    int row = tb.getRowCount();
                    for (int i = row; i > 0; i--) {
                        model.removeRow(0);
                    }
                    for (Bangdoanhthu i : bangdoanhthu) {
                        if (i.getNgay().equals(t1.getText())) {
                            model.addRow(new Object[]{
                                i.getNgay(), i.getTienmat(), i.getVisa(), i.getDthu()
                            });
                        } else {
                            JOptionPane.showMessageDialog(null, "Dữ Liệu không phù hợp");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu không tồn tại");
                }
            }
        });
        tb.setModel(model);
        model.addColumn("NGÀY");
        model.addColumn("TIỀN MẶT");
        model.addColumn("VISA");
        model.addColumn("DOANH THU NGÀY");
        sp.setBounds(200, 170, 900, 500);
        add(title);
        add(sp);
        add(l1);
        add(t1);
        add(tim);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public void xuatdanhsach() {

        bangdoanhthu = BLLbdt.getBangdoanhthu();
        int row = tb.getRowCount();
        for (int i = row; i > 0; i--) {
            model.removeRow(0);
        }
        for (Bangdoanhthu i : bangdoanhthu) {

            model.addRow(new Object[]{
                i.getNgay(), i.getTienmat(), i.getVisa(), i.getDthu()
            });
        }
    }

}
