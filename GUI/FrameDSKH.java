package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BLL.BLLCustomer;
import java.awt.event.MouseEvent;
import DTO.Customer;
import java.awt.event.MouseListener;
import java.util.Vector;

public class FrameDSKH extends JFrame {

    private JLabel title, l1, name1, CMND1, sex, date1;
    private String sex1[] = {"Nam", "Nu"};
    private JComboBox cb = new JComboBox(sex1);
    private JPanel p;
    private JTextField t1, name, CMND, date;
    private JButton tim, FIX, De,rs;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);
    private BLLCustomer BLLCus = new BLLCustomer();

    FrameDSKH() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Danh sách khách hàng");
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SÁCH KHÁCH HÀNG");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        l1 = new JLabel("CMND Khach Hang");
        l1.setBounds(380, 100, 200, 30);
        t1 = new JTextField();
        t1.setBounds(500, 100, 200, 30);
        tim = new JButton("TIM", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        tim.setBounds(720, 100, 120, 30);
        rs = new JButton("");
        rs.setBounds(850, 100, 80,30);
        rs.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DSKH1();
            }
        });
        tim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BLLCus.checkID(t1.getText())) {
                    try {
                        int row1 = tb.getRowCount();
                        for (int i = row1; i > 0; i--) {
                            model.removeRow(0);
                        }
                        String a = t1.getText();
                        Vector<Customer> DS = new Vector<Customer>();
                        DS = BLLCus.getCustomerlist();
                        for (Customer i : DS) {
                            if (a.equals(i.getID())) {
                                model.addRow(new Object[]{
                                    i.getID(), i.getName(), i.getSex(), i.getDate()});
                                return;
                            }
                        }
                    } catch (Exception ev) {
                        JOptionPane.showMessageDialog(null, "Lỗi");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không tồn tại");
                }
            }
        });
        tb.setModel(model);
        model.addColumn("CMND");
        model.addColumn("Họ và Tên");
        model.addColumn("Ngày Sinh");
        model.addColumn("Giới Tính");
        sp.setBounds(50, 170, 800, 500);
        add(title);
        add(sp);
        add(l1);
        add(t1);
        add(tim);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        p = new JPanel(null);
        p.setBounds(900, 170, 310, 200);
        p.setBorder(BorderFactory.createTitledBorder("FIX & DELETE CUSTOMER"));
        CMND1 = new JLabel("CMND");
        CMND1.setBounds(5, 20, 90, 30);
        CMND = new JTextField();
        CMND.setBounds(100, 20, 200, 30);
        name1 = new JLabel("Full Name");
        name1.setBounds(5, 50, 90, 30);
        name = new JTextField();
        name.setBounds(100, 50, 200, 30);
        sex = new JLabel("Sex");
        sex.setBounds(5, 80, 90, 30);
        cb.setBounds(100, 80, 100, 30);
        date1 = new JLabel("Date");
        date1.setBounds(5, 110, 90, 30);
        date = new JTextField();
        date.setBounds(100, 110, 200, 30);
        FIX = new JButton("SỬA");
        FIX.setBounds(70, 150, 100, 30);
        FIX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, BLLCus.FixCus(CMND.getText(), name.getText(), cb.getSelectedItem().toString(), date.getText()));
                    DSKH1();
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });
        De = new JButton("XÓA");
        De.setBounds(180, 150, 100, 30);
        De.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, BLLCus.DelCus(CMND.getText()));
                    CMND.setText(null);
                    name.setText(null);
                    date.setText(null);
                    DSKH1();
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });
        tb.addMouseListener(new MouseListener() {
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
        add(p);
        p.add(name1);
        p.add(name);
        p.add(CMND1);
        p.add(CMND);
        p.add(sex);
        p.add(cb);
        p.add(date1);
        p.add(date);
        p.add(FIX);
        p.add(De);
        add(rs);
        DSKH();
        setVisible(true);
    }

    private void tableMouseClicked(MouseEvent e) {
        int i = tb.getSelectedRow();
        CMND.setEnabled(false);
        if (i >= 0) {
            CMND.setText(tb.getModel().getValueAt(i, 0).toString());
            name.setText(tb.getModel().getValueAt(i, 1).toString());
            cb.setSelectedItem(tb.getModel().getValueAt(i, 2).toString());
            date.setText(tb.getModel().getValueAt(i, 3).toString());
        }
    }

    private void DSKH() {
        Vector<Customer> DS = new Vector<Customer>();
        DS = BLLCus.getCustomerlist();
        for (Customer i : DS) {
            model.addRow(new Object[]{
                i.getID(), i.getName(), i.getSex(), i.getDate()});
        }
    }

    private void DSKH1() {
        int row1 = tb.getRowCount();
        for (int i = row1; i > 0; i--) {
            model.removeRow(0);
        }
        Vector<Customer> DS = new Vector<Customer>();
        DS = BLLCus.getCustomerlist();
        for (Customer i : DS) {
            model.addRow(new Object[]{
                i.getID(), i.getName(), i.getSex(), i.getDate()});
        }
    }

    public static void main(String[] args) {
        new FrameDSKH();
    }
}
