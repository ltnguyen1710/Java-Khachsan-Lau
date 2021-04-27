package BLL;

import DAL.DALStaff;
import javax.swing.JOptionPane;

public class BLLStaff {

    public BLLStaff() {

    }
    DALStaff dstaff = new DALStaff();

    public boolean ChecklogStaff(int tk, String mk) {
       return dstaff.checkLogin(tk, mk);
    }

    public String ChangedPassStaff(int idStaff, String oldPass, String newPass1, String newPass2) {
        if (dstaff.checkMKS(oldPass) == false) {
            return "Mật khẩu cũ không đúng";
            
        } else if (newPass2.equals(newPass1) == false) {
            return "Mật khẩu mới không khớp";

        } else {
            dstaff.changedPass(idStaff, newPass2);
            return "Đổi mật khẩu thành công";
        }    
    }
    public boolean checkStaff(int idstaff){
        return dstaff.checkStaff(idstaff);
    }
}
