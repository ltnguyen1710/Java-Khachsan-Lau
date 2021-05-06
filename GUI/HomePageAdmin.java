package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BLL.BLLStaff;
import DTO.Staff;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class HomePageAdmin extends JFrame {

    private JButton DX, ADD, FIX, FIX1, Find, Del, DSKH, DSDT,cl;
    private JLabel name1, ID1, Day1, sex, date1, title, passwd1;
    private JRadioButton Nam, Nu;
    private JPanel addNV, p2;
    private String gt[] = {"Nam", "Nu"};
    private JComboBox cb = new JComboBox(gt);
    private JTextField name, ID, Day, date, passwd;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);
    private BLLStaff bllsta = new BLLStaff();
    private Vector<Staff> stalist = new Vector();
    RevenueInDay RID = new RevenueInDay();

    public HomePageAdmin() {
        DisPlay();
        xuatdanhsach();
    }

    private void DisPlay() {
        setLayout(null);
        setTitle("Admin");

        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ///
        addNV = new JPanel();
        addNV.setBounds(5, 100, 300, 400);
        addNV.setBorder(BorderFactory.createTitledBorder("ADD OR FIX STAFF"));
        name1 = new JLabel("Ho & Ten Nhan Vien");
        ID1 = new JLabel("ID Nhan Vien");
        Day1 = new JLabel("Ngay Bat Dau Lam");
        name = new JTextField();
        name.setPreferredSize(new Dimension(290, 30));
        ID = new JTextField();
        ID.setPreferredSize(new Dimension(290, 30));
        Day = new JTextField();
        Day.setPreferredSize(new Dimension(290, 30));
        Day.setText(java.time.LocalDate.now().toString());
        sex = new JLabel("Gioi Tinh");
        cb.setPreferredSize(new Dimension(190, 30));
        date1 = new JLabel("Ngay Sinh");
        date = new JTextField();
        date.setPreferredSize(new Dimension(190, 30));
        passwd1 = new JLabel("Mat Khau");
        passwd = new JTextField();
        passwd.setPreferredSize(new Dimension(190, 30));
        ADD = new JButton("Them", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\add.png"));
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ID.getText().equals("") || name.getText().equals("") || Day.getText().equals("") || date.getText().equals("") || passwd.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Chưa nhập đủ thông tin!");
                    return;
                }
                Staff sta = new Staff();
                sta.setId(Integer.parseInt(ID.getText()));
                sta.setTen(name.getText());
                sta.setNgayvaolam(Day.getText());
                sta.setNgaysinh(date.getText());
                sta.setMatkhau(passwd.getText());
                sta.setGioitinh(gt[cb.getSelectedIndex()]);
                JOptionPane.showMessageDialog(null, bllsta.addStaff(sta));
                xuatdanhsach();
            }
        });
        FIX = new JButton("Sua", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\edit.png"));
        FIX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, bllsta.FixStaff(Integer.parseInt(ID.getText()), passwd.getText(), name.getText(), cb.getSelectedItem().toString(), date.getText(), Day.getText()));
                xuatdanhsach();
            }

        });
        Find = new JButton("Tim", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        Find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = JOptionPane.showInputDialog(null, "Nhập ID Nhân Viên");
                if (bllsta.checkStaff(Integer.parseInt(a))) {
                    stalist = bllsta.getVectorSta();
                    for (Staff i : stalist) {
                        if (a.equals(String.valueOf(i.getId()))) {
                            ID.setText(String.valueOf(i.getId()));
                            passwd.setText(i.getMatkhau());
                            name.setText(i.getTen());
                            date.setText(i.getNgaysinh());
                            cb.setSelectedItem(i.getGioitinh());
                            Day.setText(i.getNgayvaolam());
                            return;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không Thể Tìm Ra");
                }
            }
        });
        Del = new JButton("Xoa", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\delete.png"));
        Del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, bllsta.DelStaff(Integer.parseInt(ID.getText())));
                xuatdanhsach();
            }
        });
        cl = new JButton("Clear", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\delete.png"));
        cl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearActionListener(e);
            }
        });
        addNV.add(ID1);
        addNV.add(ID);
        addNV.add(name1);
        addNV.add(name);
        addNV.add(Day1);
        addNV.add(Day);
        addNV.add(sex);
        addNV.add(cb);
        addNV.add(date1);
        addNV.add(date);
        addNV.add(passwd1);
        addNV.add(passwd);
        addNV.add(ADD);
        addNV.add(FIX);
        addNV.add(Find);
        addNV.add(Del);
        addNV.add(cl);
        ///
        title = new JLabel("DANH SACH NHAN VIEN");
        title.setBounds(530, 40, 400, 50);
        title.setFont(new Font(null, Font.BOLD, 30));
        tb.setModel(model);
        model.addColumn("ID Nhan Vien");
        model.addColumn("Mat Khau");
        model.addColumn("Ho&Ten NV");
        model.addColumn("Ngay Sinh");
        model.addColumn("Gioi Tinh");
        model.addColumn("Ngay B.Dau Lam");
        sp.setBounds(350, 100, 700, 500);
        add(sp);
        FIX1 = new JButton("SUA G.TIEN PHONG", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\fix.png"));
        FIX1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameFixMoneyRoom();
            }

        });
        DSKH = new JButton("DS KHACH HANG", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\list.png"));

        DSKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameDSKH();
            }

        });
        DSDT = new JButton("DS DOANH THU ", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\stlist.png"));
        DSDT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!RID.isVisible()) {
                    RID.xuatdanhsach();
                    RID.setVisible(true);
                }
            }
        });
        DX = new JButton("DANG XUAT", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\log-out.png"));
        DX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login().setVisible(true);
            }
        });
        FIX1.setBounds(1100, 100, 180, 90);
        DSKH.setBounds(1100, 250, 180, 90);
        DSDT.setBounds(1100, 400, 180, 90);
        DX.setBounds(1100, 550, 180, 90);
        tb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TableMouseClicked(e);
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
        add(DX);
        add(addNV);
        add(title);
        add(FIX1);
        add(DSDT);
        add(DSKH);
        setVisible(true);
    }

    public void xuatdanhsach() {
        stalist = bllsta.getVectorSta();
        int row = tb.getRowCount();
        for (int i = row; i > 0; i--) {
            model.removeRow(0);
        }
        for (Staff i : stalist) {
            model.addRow(new Object[]{
                i.getId(), i.getMatkhau(), i.getTen(), i.getNgaysinh(), i.getGioitinh(), i.getNgayvaolam()
            });
        }

    }

    private void ClearActionListener(ActionEvent e) {
        ID.setEnabled(true);
        ID.setText(null);
        passwd.setText(null);
        name.setText(null);
        Day.setText(java.time.LocalDate.now().toString());
    }

    private void TableMouseClicked(MouseEvent e) {
        int i = tb.getSelectedRow();
        ID.setEnabled(false);
        if (i >= 0) {
            ID.setText(tb.getModel().getValueAt(i, 0).toString());
            passwd.setText(tb.getModel().getValueAt(i, 1).toString());
            name.setText(tb.getModel().getValueAt(i, 2).toString());
            date.setText(tb.getModel().getValueAt(i, 3).toString());
            cb.setSelectedItem(tb.getModel().getValueAt(i, 4).toString());
            Day.setText(tb.getModel().getValueAt(i, 5).toString());
        }
    }

    public static void main(String[] args) {
        new HomePageAdmin();
    }
}
