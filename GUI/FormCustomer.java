package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FormCustomer extends JFrame {

    private JLabel CMND, title, FullName, Date, sex;
    private JButton add,done;
    private JTextField Name, Date1, ID1;
    private JRadioButton Nam, Nu;
    private ButtonGroup bg = new ButtonGroup();

    FormCustomer() {
        DisPlay();
    }

    private void DisPlay() {
        setTitle("Form Customer");
        setResizable(false); // khong cho thu nho man hinh
        setLayout(null);
        setBounds(320,200,600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title = new JLabel("THONG TIN KHACH HANG");
        title.setBounds(100,0,400,60);
        title.setFont(new Font(null,Font.BOLD,30));
        CMND = new JLabel("CMND");
        CMND.setBounds(60,70,50,30);
        ID1 = new JTextField();
        ID1.setBounds(100,70,150,30);
        FullName = new JLabel("Ho & Ten");
        FullName.setBounds(260,70,100,30);
        Name = new JTextField();
        Name.setBounds(330,70,200,30);
        Date = new JLabel("Ngay Sinh");
        Date.setBounds(30,110,80,30);
        Date1 = new JTextField();
        Date1.setBounds(100,110,200,30);
        sex = new JLabel("Gioi tinh");
        sex.setBounds(320,110,90,30 );
        Nam = new JRadioButton("Nam");
        Nam.setBounds(380,110,70,30);
        Nu = new JRadioButton("Nu");
        Nu.setBounds(450,110,80,30);
        bg.add(Nam);
        bg.add(Nu);
        add = new JButton("ADD",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\addition.png"));
        add.setBounds(280,160,100,30);
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AddActionPerformed(e);
            }
            
        });
        done = new JButton("DONE",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\thumb-ups.png"));
        done.setBounds(390,160,100,30);
        done.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DoneActionPerformed(e);
            }
            
        });
        add(add);
        add(done);
        add(Nam);
        add(Nu);
        add(title);
        add(CMND);
        add(ID1);
        add(Name);
        add(Date);
        add(Date1);
        add(sex);
        add(FullName);
        setVisible(true);
    }
    
    private void AddActionPerformed(ActionEvent e){

        Name.setText(null);
         
    }
    
    private void DoneActionPerformed(ActionEvent e){
        
    }
    public static void main(String [] args){
        new FormCustomer();
    }
}
