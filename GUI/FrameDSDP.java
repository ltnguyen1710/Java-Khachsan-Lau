package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import BLL.BLLBookingDetail;
import DTO.BookingDetail;
import java.util.Vector;
import BLL.BLLRoom;

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
    private BLLBookingDetail bllbd = new BLLBookingDetail();
    private Vector<BookingDetail> bdlist = new Vector();
    private BLLRoom bllroom = new BLLRoom();
    private String cmnd = "", ngaydat = "", ngaytra = "", idphong = "", ngaynhan = "";
    private String splits[];

    FrameDSDP() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Danh Sách Đặt Phòng");
        setResizable(false); // khong cho thu nho man hinh
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("DANH SÁCH ĐẶT PHÒNG");
        title.setBounds(320, 0, 700, 60);
        title.setFont(new Font(null, Font.BOLD, 50));
        CMND1 = new JLabel("CMND Khách: ");
        CMND1.setBounds(300, 100, 120, 30);
        CMND = new JTextField();
        CMND.setBounds(420, 100, 120, 30);
        RentDay1 = new JLabel("Ngày Đặt: ");
        RentDay1.setBounds(540, 100, 100, 30);
        RentDay = new JTextField();
        RentDay.setBounds(640, 100, 150, 30);
        tim = new JButton("TÌM", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        tim.setBounds(800, 100, 80, 30);
        tim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String c = CMND.getText();
                String b = RentDay.getText();
                if (!c.equals("") && !b.equals("")) {

                    int row = tb.getRowCount();
                    for (int a = row; a > 0; a--) {
                        model.removeRow(0);
                    }
                    bdlist = bllbd.getbdList();
                    for (BookingDetail i : bdlist) {
                        if (c.equals(i.getIdkhach()) && b.equals(i.getNgaydat().toString())) {
                            model.addRow(new Object[]{i.getIdkhach(), i.getIdnhanvien(), i.getNgaydat(), i.getNgaynhan(), i.getNgaytra(), i.getIdphong(), i.getTralan1(), i.getGia()});
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ Liệu Không Phù Hợp");
                }
            }
        });
        tb.setModel(model);
        model.addColumn("CMND Khách");
        model.addColumn("ID NV");
        model.addColumn("Ngày Đặt");
        model.addColumn("Ngày Nhận Phòng");
        model.addColumn("Ngày Trả");
        model.addColumn("Phòng số");
        model.addColumn("Tiền Cọc");
        model.addColumn("Giá");
        sp.setBounds(10, 150, 900, 470);
        p = new JPanel(null);
        p.setBounds(920, 160, 320, 400);
        p.setBorder(BorderFactory.createTitledBorder(null, "Thanh Toan",
                TitledBorder.CENTER, TitledBorder.CENTER, new Font("Brush Script Std", Font.PLAIN, 20), new Color(255, 77, 77)));
        NameCus = new JLabel("CMND Khách : ");
        NameCus.setBounds(10, 10, 400, 30);
        IDStaff = new JLabel("ID NV: " + "");
        IDStaff.setBounds(10, 40, 400, 30);
        RentDayTT = new JLabel("Ngày Đặt Phòng: ");
        RentDayTT.setBounds(10, 70, 400, 30);
        PayDay = new JLabel("Ngày Trả Phòng: ");
        PayDay.setBounds(10, 100, 400, 30);
        tb1.setModel(model1);
        model1.addColumn("Số Phòng");
        model1.addColumn("Giá");
        sp1.setBounds(10, 130, 300, 200);
        Deposit = new JLabel("Đã Thanh Toán:");
        Deposit.setBounds(10, 330, 400, 30);
        Total = new JLabel("Thanh Toán:");
        Total.setBounds(10, 360, 400, 30);
        r1 = new JRadioButton("Tiền Mặt");
        r2 = new JRadioButton("Master Card");
        bg.add(r1);
        bg.add(r2);
        JPanel tt = new JPanel();
        tt.setBorder(BorderFactory.createTitledBorder(null, "Hình Thức Thanh Toán", TitledBorder.CENTER, TitledBorder.CENTER, null, new Color(255, 64, 0)));
        tt.setBounds(1040, 570, 200, 50);
        tt.add(r1);
        tt.add(r2);
        TT = new JButton("Thanh Toán");
        TT.setBounds(920, 630, 320, 40);
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
        Del = new JButton("Hủy Phòng", new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\x-button.png"));
        Del.setBounds(365, 630, 150, 40);
        Del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HuyActionListener(e);
                }catch(Exception a){
                    JOptionPane.showMessageDialog(null,"Dữ Liệu Không Phù Hợp");
                }

            }
        });
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
    }

    public void xuatdanhsach() {
        bdlist = bllbd.getbdList();
        int row = tb.getRowCount();
        for (int i = row; i > 0; i--) {
            model.removeRow(0);
        }
        for (BookingDetail i : bdlist) {
            model.addRow(new Object[]{
                i.getIdkhach(), i.getIdnhanvien(), i.getNgaydat(), i.getNgaynhan(), i.getNgaytra(), i.getIdphong(), i.getTralan1(), i.getGia()
            });
        }
    }

    private void tableMouseClicked(MouseEvent e) {
        int i = tb.getSelectedRow();
        if (i >= 0) {
            idphong = tb.getModel().getValueAt(i, 5).toString();
            cmnd = tb.getModel().getValueAt(i, 0).toString();
            ngaydat = tb.getModel().getValueAt(i, 2).toString();
            ngaynhan = tb.getModel().getValueAt(i, 3).toString();
            NameCus.setText("CMND Khách: " + tb.getModel().getValueAt(i, 0).toString());
            IDStaff.setText("ID NV: " + tb.getModel().getValueAt(i, 1).toString());
            RentDayTT.setText("Ngày Đặt: " + tb.getModel().getValueAt(i, 3).toString());
            PayDay.setText("Ngày Trả: " + tb.getModel().getValueAt(i, 4).toString());
            splits = tb.getModel().getValueAt(i, 5).toString().split(",");
            int row = tb1.getRowCount();
            for (int j = row; j > 0; j--) {
                model1.removeRow(0);
            }
            for (int j = 0; j < splits.length; j++) {
                String gia = bllroom.getGia(Integer.parseInt(splits[j])) + "";
                model1.addRow(new Object[]{
                    splits[j], gia
                });
            }
            Deposit.setText("Tiền Cọc: " + tb.getModel().getValueAt(i, 6).toString());
            Total.setText("Giá: " + tb.getModel().getValueAt(i, 7).toString());
        }
    }

    private void HuyActionListener(ActionEvent e) {
        int gia = 0;
        String phuongthuc = "";
        if (NameCus.getText().equals("CMND Khách: ")) {
            JOptionPane.showMessageDialog(null, "Chọn khách Hàng cần Hủy");
            return;
        }
        int yes = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn hủy ?",
                null, JOptionPane.YES_NO_OPTION);
        int i = tb.getSelectedRow();
        if (yes == JOptionPane.YES_OPTION) {
            if (ngaydat.equals(java.time.LocalDate.now().toString()) && !ngaydat.equals(ngaynhan)) {
                bllbd.huy(ngaynhan, cmnd, idphong);
            } else {
                gia = Integer.parseInt(tb.getModel().getValueAt(i, 6).toString());
                bllbd.huy(cmnd, ngaynhan, phuongthuc, gia, idphong);
            }
            for (int j = 0; j < splits.length; j++) {
                bllroom.setTinhtrang(Integer.parseInt(splits[j]));
            }
            model.removeRow(i);
            JOptionPane.showMessageDialog(null, "Hủy phòng thành công!");
        }
    }

    private void TTActionListener(ActionEvent e) {
        int gia = 0;
        String phuongthuc = "";
        if (cmnd.equals("") || ngaynhan.equals("") || (!r1.isSelected() && !r2.isSelected())) {
            JOptionPane.showMessageDialog(null, "Chọn khách cần thanh toán!!!!");
            return;
        }
        int i = tb.getSelectedRow();
        phuongthuc = (r1.isSelected() ? r1.getText() : r2.getText());
        gia = Integer.parseInt(tb.getModel().getValueAt(i, 6).toString());
        bllbd.setDetailtrasau(cmnd, ngaynhan, phuongthuc, gia, idphong);
        xuatdanhsach();
        for (int j = 0; j < splits.length; j++) {
            bllroom.setTinhtrang(Integer.parseInt(splits[j]));
        }
        int row = tb1.getRowCount();
        for (int j = row; j > 0; j--) {
            model1.removeRow(0);
        }
        NameCus.setText("CMND Khách: ");
    }

}
