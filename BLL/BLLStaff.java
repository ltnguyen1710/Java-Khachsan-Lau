package BLL;

import DAL.DALStaff;
import javax.swing.JOptionPane;

public class BLLStaff {

    public BLLStaff() {

    }
    DALStaff dstaff = new DALStaff();

    public boolean ChecklogStaff(String tk, String mk) {
        if (dstaff.checkLogin(tk, mk)) {
            return true;
        }
        return false;
    }

    public boolean ChangedPassStaff(int idStaff, String oldPass, String newPass1, String newPass2) {
        if (dstaff.checkMK(oldPass) == false) {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng");
        } else if (newPass2.equals(newPass1) == false) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới không khớp");
        } else if (dstaff.changedPass(idStaff, newPass2)) {
            JOptionPane.showMessageDialog(null, "Đổi thành công");
        }
        return false;
    }
}
