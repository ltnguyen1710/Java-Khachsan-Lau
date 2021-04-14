package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HomePageAdmin extends JFrame {

    private JButton DX, ADD, FIX, FIX1, DS;
    private JLabel name1, ID1, Day1, sex, date1, title;
    private JRadioButton Nam, Nu;
    private JPanel addNV, p2;
    private String gt[] = {"Nam", "Nu"};
    private JComboBox cb = new JComboBox(gt);
    private JTextField name, ID, Day, date;
    private JTable tb = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sp = new JScrollPane(tb);

    HomePageAdmin() {
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
        ID1 = new JLabel("ID");
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
        ADD = new JButton("ADD");
        FIX = new JButton("FIX");
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
        addNV.add(ADD);
        addNV.add(FIX);
        ///
        title = new JLabel("DANH SACH NHAN VIEN");
        title.setBounds(530, 40, 400, 50);
        title.setFont(new Font(null, Font.BOLD, 30));
        tb.setModel(model);
        model.addColumn("ID");
        model.addColumn("Ho&Ten NV");
        model.addColumn("Ngay Sinh");
        model.addColumn("Gioi Tinh");
        model.addColumn("Ngay Lam");
        sp.setBounds(400, 100, 600, 500);
        add(sp);
        FIX1 = new JButton("FIX MONEY ROOM");
        FIX1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameFixMoneyRoom();
            }
            
        });
        DS = new JButton("LIST CUSTOMER");
        
        DS.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameDSKH();
            }
            
        });
        DX = new JButton("LOGOUT");
        DX.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            new Login();
        }
        });
        FIX1.setBounds(1100, 100, 180, 80);
        DS.setBounds(1100, 300, 180, 80);
        DX.setBounds(1100, 500, 180, 80);
        add(DX);
        add(addNV);
        add(title);
        add(FIX1);
        add(DS);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePageAdmin();
    }
}
