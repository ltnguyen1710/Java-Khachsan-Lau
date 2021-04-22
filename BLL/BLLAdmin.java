package BLL;

import DAL.DALAdmin;
import GUI.HomePageAdmin;
import javax.swing.JOptionPane;

public class BLLAdmin {
    DALAdmin ad = new DALAdmin();

    public BLLAdmin() {

    }

    public boolean Checklog(String tk, String mk) {
        if (ad.checkLogin(tk, mk)) {
            return true;
        }

        return false;
    }

}
