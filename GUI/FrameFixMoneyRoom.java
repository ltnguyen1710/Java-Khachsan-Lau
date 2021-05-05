package GUI;
import BLL.BLLRoom;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrameFixMoneyRoom extends JFrame {

    private BLLRoom bllroom = new BLLRoom();
    private String room[] ={"VIP","FAMILY","COUPLE","SINGLE"}; 
    private JComboBox cb = new JComboBox(room);
    private JLabel ro,l1;
    private JTextField t1;
    private JButton b1;

    FrameFixMoneyRoom() {
        DisPlay();
    }

    private void DisPlay() {
        setLayout(new FlowLayout());
        
        setBounds(470, 250, 300, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ro = new JLabel("ROOM");
        l1 = new JLabel("PRICE");
        t1 = new JTextField();
        t1.setPreferredSize(new Dimension(200,30));
        cb.setPreferredSize(new Dimension(200,30));
        b1 = new JButton("   OK   ",new ImageIcon("C:\\Users\\Nghia\\Documents\\imageDoAn\\checked.png"));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null,bllroom.changedGia(""+cb.getSelectedItem(),Integer.parseInt(t1.getText())));

                }catch (NullPointerException b){
                    JOptionPane.showMessageDialog(null,"PHẢI ĐIỀN ĐẦY ĐỦ THÔNG TIN");
                }
            }
        });
        add(ro);
        add(cb);
        add(l1);
        add(t1);
        add(b1);
        setVisible(true);
        setResizable(false); // khong cho thu nho man hinh
    }

    public static void main(String[] args) {
        new FrameFixMoneyRoom();
    }
}
