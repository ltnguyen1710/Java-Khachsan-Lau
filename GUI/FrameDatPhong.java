package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import BLL.BLLRoom;
import BLL.BLLBookingDetail;
import BLL.BLLCustomer;
import DTO.Room;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import BLL.BLLStaff;
import DTO.Customer;

public class FrameDatPhong extends JFrame {

    private JPanel p1, p2;
    public JTextField from1, to1;
    private JRadioButton r1, r2;
    private JLabel CMND, InforCus, FullName, Date, sex, InforRoo, NameCus, IDStaff, RentDay, PayDay, RooAndPri, Deposit, Total;
    private JButton Find, DatCoc, TToan;
    private JTextField Name, Date1, ID1;
    private JRadioButton Nam, Nu;
    private ButtonGroup bg = new ButtonGroup();
    private ButtonGroup bg1 = new ButtonGroup();
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);
    private JTable tb1 = new JTable();
    private DefaultTableModel model1 = new DefaultTableModel();
    private JScrollPane sp1 = new JScrollPane(tb1);
    private String SoPhong;
    private BLLRoom bllroom = new BLLRoom();
    private Vector<Room> phongtrong = new Vector();
    private BLLStaff bllstaff = new BLLStaff();
    private BLLCustomer bllcus = new BLLCustomer();

    FrameDatPhong() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Dat Phong");
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel title = new JLabel("Khach San Lau");
        title.setFont(new Font(null, Font.CENTER_BASELINE, 20));
        title.setBounds(560, 10, 200, 30);
        JLabel dayNow = new JLabel("Ngay: " + java.time.LocalDate.now().toString());
        dayNow.setBounds(570, 35, 100, 20);
        // tao 2 label va 2 text de nhap ngay vao.
        JLabel from = new JLabel("From");
        JLabel to = new JLabel("to");
        from.setBounds(500, 60, 40, 20);
        from1 = new JTextField();
        from1.setBounds(540, 60, 100, 30);
        from1.setToolTipText("YYYY-MM-dd");
        from1.setText(java.time.LocalDate.now().toString());
        to.setBounds(640, 60, 20, 20);
        to1 = new JTextField();
        to1.setBounds(660, 60, 100, 30);
        to1.setToolTipText("YYYY-MM-dd");
        to1.setText(java.time.LocalDate.now().toString());
        Find = new JButton("Tim");
        Find.setBounds(770, 60, 80, 30);

        p1 = new JPanel(null);
        p1.setBounds(0, 100, 500, 120);
        p1.setBorder(BorderFactory.createTitledBorder(null, "Thong tin Khach Hang",
                TitledBorder.CENTER, TitledBorder.CENTER, new Font("Brush Script Std", Font.PLAIN, 20), new Color(255, 77, 77)));
        CMND = new JLabel("CMND");
        CMND.setBounds(10, 30, 50, 30);
        ID1 = new JTextField();
        ID1.setBounds(60, 30, 150, 30);
        FullName = new JLabel("Ho & Ten");
        FullName.setBounds(210, 30, 100, 30);
        Name = new JTextField();
        Name.setBounds(290, 30, 180, 30);
        Date = new JLabel("Ngay Sinh");
        Date.setBounds(10, 70, 80, 30);
        Date1 = new JTextField();
        Date1.setBounds(90, 70, 180, 30);
        sex = new JLabel("Gioi tinh");
        sex.setBounds(270, 70, 90, 30);
        Nam = new JRadioButton("Nam");
        Nam.setBounds(340, 70, 70, 30);
        Nu = new JRadioButton("Nu");
        Nu.setBounds(410, 70, 80, 30);
        InforRoo = new JLabel("Cac phong chua duoc thue");
        InforRoo.setBounds(50, 230, 400, 50);
        InforRoo.setFont(new Font("Brush Script Std", Font.PLAIN, 20));
        tb.setModel(model);
        model.addColumn("So phong");
        model.addColumn("Loai phong");
        model.addColumn("Gia");
        sp.setBounds(5, 280, 500, 400);
        p2 = new JPanel(null);
        p2.setBounds(600, 100, 320, 400);
        p2.setBorder(BorderFactory.createTitledBorder(null, "Chi Tiet Dat Phong",
                TitledBorder.CENTER, TitledBorder.CENTER, new Font("Brush Script Std", Font.PLAIN, 20), new Color(255, 77, 77)));
        NameCus = new JLabel("Ho&Ten Khach : " + FullName.getText());
        NameCus.setBounds(10, 10, 400, 30);
        IDStaff = new JLabel("ID NV: " + "");
        IDStaff.setBounds(10, 40, 400, 30);
        RentDay = new JLabel("Ngay Dat Phong: " + from1.getText());
        RentDay.setBounds(10, 70, 400, 30);
        PayDay = new JLabel("Ngay Tra Phong: " + to1.getText());
        PayDay.setBounds(10, 100, 400, 30);
        tb1.setModel(model1);
        model1.addColumn("So phong");
        model1.addColumn("Gia");
        sp1.setBounds(10, 130, 300, 200);
        //RooAndPri = new JLabel("So Phong"+SoPhong);
        //RooAndPri.setBounds(10,130,400,60);
        Deposit = new JLabel("Tien Coc: " + "");
        Deposit.setBounds(10, 330, 400, 30);
        Total = new JLabel("Tong Tien: ");
        Total.setBounds(10, 360, 400, 30);
        r1 = new JRadioButton("Tien Mat");
        r2 = new JRadioButton("Master Card");
        JPanel tt = new JPanel();
        tt.setBorder(BorderFactory.createTitledBorder(null, "Hinh Thuc Thanh Toan", TitledBorder.CENTER, TitledBorder.CENTER, null, new Color(255, 64, 0)));
        tt.setBounds(710, 510, 200, 50);
        DatCoc = new JButton("Dat Coc");
        DatCoc.setBounds(600, 570, 320, 40);
        Find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                               
                phongtrong = bllroom.getPhongtrong(from1.getText(), to1.getText());   
                int row = tb.getRowCount();
                int row1 = tb1.getRowCount();   
                for (int i = row; i > 0; i--) {
                    model.removeRow(0);
                }
                for (int i = row1; i > 0; i--) {
                    model1.removeRow(0);
                }
                Name.setText("");
                Date1.setText("");
                for (Room i : phongtrong) {
                    model.addRow(new Object[]{
                        i.getID(), i.getType(), i.getPrice()
                    });
                }
            }
        });
        DatCoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CMND.getText().equalsIgnoreCase("") || FullName.getText().equalsIgnoreCase("") || Date.getText().equalsIgnoreCase("") || (!Nam.isSelected() && !Nu.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Phai nhap du thong tin khach hang");
                    return;
                }
                if (model1.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Chua chon phong!");
                    return;
                }
                String gioitinh = (Nam.isSelected() ? "Nam" : "Nu");
                String str = "";
                int Tong = 0;
                for (int i = 0; i < model1.getRowCount(); i++) {
                    str += tb1.getModel().getValueAt(i, 0);
                    if (i + 1 < model1.getRowCount()) {
                        str += ",";
                    }
                    Tong += Integer.parseInt(tb1.getModel().getValueAt(i, 1).toString());

                }
                String idnhanvien = JOptionPane.showInputDialog("Nhap ma nhan vien: ");
                if (!bllstaff.checkStaff(Integer.parseInt(idnhanvien))) {
                    JOptionPane.showMessageDialog(null, "Ma nhan vien khong ton tai!");
                    return;
                }
                if (!r1.isSelected() && !r2.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Chon phuong thuc thanh toan!");
                    return;
                }
                String phuongthuc = (r1.isSelected() ? "Tien mat" : "Master Card");
                NameCus.setText("Ho&Ten Khach : " + Name.getText());
                RentDay.setText("Ngay Dat Phong: " + from1.getText());
                PayDay.setText("Ngay Tra Phong: " + to1.getText());
                Total.setText("Tong Tien: " + Tong);
                IDStaff.setText("ID NV: " + idnhanvien);
                String sotienkhachtra = JOptionPane.showInputDialog("Nhap so tien khach tra: ");
                int sotientra = Integer.parseInt(sotienkhachtra);
                if (Tong / 2 > sotientra) {
                    JOptionPane.showMessageDialog(null, "So tien coc phai lon hon hoac bang nua tong tien!");
                    return;
                }
                Customer cus = new Customer(ID1.getText(), Name.getText(), gioitinh, Date1.getText());
                bllcus.addCus(cus);
                Deposit.setText("Tien Coc: " + sotientra);
                bllroom.datphong(str, ID1.getText(), Integer.parseInt(idnhanvien), from1.getText(), to1.getText(), Tong, Integer.parseInt(sotienkhachtra), phuongthuc);
                for (int i = 0; i < model1.getRowCount(); i++) {
                    bllroom.setTinhtrang(Integer.parseInt(tb1.getModel().getValueAt(i, 0).toString()));
                }
                JOptionPane.showMessageDialog(null, "Dat coc thanh cong");
            }
        });
        tb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tb.getSelectedRow();
                if (i >= 0) {
                    model1.addRow(new Object[]{
                        tb.getModel().getValueAt(i, 0).toString(), tb.getModel().getValueAt(i, 2).toString()
                    });
                    model.removeRow(i);
                }
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
        bg1.add(r1);
        bg1.add(r2);
        tt.add(r1);
        tt.add(r2);
        bg.add(Nam);
        bg.add(Nu);
        p1.add(Nam);
        p1.add(Nu);
        p1.add(CMND);
        p1.add(ID1);
        p1.add(Name);
        p1.add(Date);
        p1.add(Date1);
        p1.add(sex);
        p1.add(FullName);
        add(title);
        add(dayNow);
        add(from);
        add(from1);
        add(to);
        add(to1);
        add(Find);
        add(p1);
        add(InforRoo);
        add(sp);
        p2.add(NameCus);
        p2.add(IDStaff);
        p2.add(RentDay);
        p2.add(PayDay);
        p2.add(sp1);
        p2.add(Deposit);
        p2.add(Total);
        add(tt);
        add(p2);
        add(DatCoc);

    }

    public static void main(String[] args) {
        new FrameDatPhong().setVisible(true);
    }
}
