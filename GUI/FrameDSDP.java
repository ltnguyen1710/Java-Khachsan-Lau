package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FrameDSDP extends JFrame {

    private JLabel title, CMND1, RentDay1, NameCus, IDStaff, RentDayTT, Deposit, Total, PayDay;
    private JPanel p;
    private JTextField CMND, RentDay;
    private JRadioButton r1, r2;
    private JButton tim, TT, Del;
    private ButtonGroup bg = new ButtonGroup();
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);
    private JTable tb1 = new JTable();
    private DefaultTableModel model1 = new DefaultTableModel();
    private JScrollPane sp1 = new JScrollPane(tb1);

    FrameDSDP() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Danh Sach Dat Phong");
        setResizable(false); // khong cho thu nho man hinh
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SACH DAT PHONG");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        CMND1 = new JLabel("CMND Khach: ");
        CMND1.setBounds(300, 100, 120, 30);
        CMND = new JTextField();
        CMND.setBounds(420, 100, 120, 30);
        RentDay1 = new JLabel("Ngay Dat: ");
        RentDay1.setBounds(540, 100, 100, 30);
        RentDay = new JTextField();
        RentDay.setBounds(640, 100, 150, 30);
        tim = new JButton("TIM", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        tim.setBounds(800, 100, 80, 30);
        tb.setModel(model);
        model.addColumn("CMND Khach");
        model.addColumn("ID NV");
        model.addColumn("Ngay Dat");
        model.addColumn("Ngay Tra");
        model.addColumn("Phong So");
        model.addColumn("Tien Coc");
        model.addColumn("Gia");
        sp.setBounds(50, 150, 800, 470);

        p = new JPanel(null);
        p.setBounds(870, 160, 320, 400);
        p.setBorder(BorderFactory.createTitledBorder(null, "Thanh Toan",
                TitledBorder.CENTER, TitledBorder.CENTER, new Font("Brush Script Std", Font.PLAIN, 20), new Color(255, 77, 77)));
        NameCus = new JLabel("CMND Khach : ");
        NameCus.setBounds(10, 10, 400, 30);
        IDStaff = new JLabel("ID NV: " + "");
        IDStaff.setBounds(10, 40, 400, 30);
        RentDayTT = new JLabel("Ngay Dat Phong: ");
        RentDayTT.setBounds(10, 70, 400, 30);
        PayDay = new JLabel("Ngay Tra Phong: ");
        PayDay.setBounds(10, 100, 400, 30);
        tb1.setModel(model1);
        model1.addColumn("So phong");
        model1.addColumn("Gia");
        sp1.setBounds(10, 130, 300, 200);
        Deposit = new JLabel("Da Thanh Toan:  Tien Cọc");
        Deposit.setBounds(10, 330, 400, 30);
        Total = new JLabel("Thanh Toan:  Tổng tiền - tiền cọc");
        Total.setBounds(10, 360, 400, 30);
        r1 = new JRadioButton("Tien Mat");
        r2 = new JRadioButton("Master Card");
        bg.add(r1);
        bg.add(r2);
        JPanel tt = new JPanel();
        tt.setBorder(BorderFactory.createTitledBorder(null, "Hinh Thuc Thanh Toan", TitledBorder.CENTER, TitledBorder.CENTER, null, new Color(255, 64, 0)));
        tt.setBounds(990, 570, 200, 50);
        tt.add(r1);
        tt.add(r2);
        TT = new JButton("Thanh Toan");
        TT.setBounds(870, 630, 320, 40);
        TT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TTActionListener(e);
            }
        });
        p.add(NameCus);
        p.add(IDStaff);
        p.add(RentDayTT);
        p.add(PayDay);
        p.add(sp1);
        p.add(Deposit);
        p.add(Total);
        Del = new JButton("XOA");
        Del.setBounds(385, 630, 80, 40);
        add(title);
        add(sp);
        add(CMND1);
        add(CMND);
        add(RentDay1);
        add(RentDay);
        add(tim);
        add(p);
        add(tt);
        add(TT);
        add(Del);

        tb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        tb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void tableMouseClicked(MouseEvent e) {
        int i = tb.getSelectedRow();
        if (i >= 0) {
            NameCus.setText(NameCus.getText() + tb.getModel().getValueAt(i, 0).toString());
            IDStaff.setText(IDStaff.getText() + tb.getModel().getValueAt(i, 1).toString());
            RentDayTT.setText(RentDayTT.getText() + tb.getModel().getValueAt(i, 2).toString());
            PayDay.setText(PayDay.getText() + tb.getModel().getValueAt(i, 3).toString());

            //sp1.setText(tb.getModel().getValueAt(i, 4).toString()); lay id phong gia tien
            Deposit.setText(Deposit.getText() + tb.getModel().getValueAt(i, 5).toString());
            Total.setText(Total.getText() + tb.getModel().getValueAt(i, 6).toString());
        }
    }

    private void DeleteActionListener(ActionEvent e) {
        int yes = JOptionPane.showConfirmDialog(null, "Ban Co that su muon xoa ?",
                null, JOptionPane.YES_NO_OPTION);
        int i = tb.getSelectedRow();
        if (yes == JOptionPane.YES_OPTION) {
            model.removeRow(i);
            //// xoa tren sql o day lun
        }
    }

    private void TTActionListener(ActionEvent e) {
        
    }

    public static void main(String[] args) {
        new FrameDSDP();
    }
}
