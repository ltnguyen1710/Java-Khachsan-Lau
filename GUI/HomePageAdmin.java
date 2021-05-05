package GUI;

import BLL.BLLRoom;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HomePageAdmin extends JFrame {
    
    private BLLRoom bllroom = new BLLRoom();
    private JButton DX, ADD, FIX, FIX1,Find,Del,DSKH,DSDT;
    private JLabel name1, ID1, Day1, sex, date1, title,passwd1;
    private JRadioButton Nam, Nu;
    private JPanel addNV, p2;
    private String gt[] = {"Nam", "Nu"};
    private JComboBox cb = new JComboBox(gt);
    private JTextField name, ID, Day, date,passwd;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);

    public HomePageAdmin() {
        DisPlay();
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
        sex = new JLabel("Gioi Tinh");
        cb.setPreferredSize(new Dimension(190, 30));
        date1 = new JLabel("Ngay Sinh");
        date = new JTextField();
        date.setPreferredSize(new Dimension(190, 30));
        passwd1= new JLabel("Mat Khau");
        passwd = new JTextField();
        passwd.setPreferredSize(new Dimension(190, 30));
        ADD = new JButton("Them",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\add.png"));
        FIX = new JButton("Sua",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\edit.png"));
        Find = new JButton("Tim",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\loupe.png"));
        Del = new JButton("Xoa",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\delete.png"));
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
        FIX1 = new JButton("SUA G.TIEN PHONG",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\fix.png"));
        FIX1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameFixMoneyRoom();
                
            }
            
        });
        DSKH = new JButton("DS KHACH HANG",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\list.png"));
        
        DSKH.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameDSKH();
            }
            
        });
        DSDT = new JButton("DS D.THU THANG",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\stlist.png"));
        DSDT.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
        });
        DX = new JButton("DANG XUAT",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\log-out.png"));
        DX.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            new Login();
        }
        });
        FIX1.setBounds(1100, 100, 180, 90);
        DSKH.setBounds(1100, 250, 180, 90);
        DSDT.setBounds(1100,400,180,90);
        DX.setBounds(1100,550, 180, 90);
        add(DX);
        add(addNV);
        add(title);
        add(FIX1);
        add(DSDT);
        add(DSKH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePageAdmin();
    }
}
