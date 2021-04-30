/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.DALBangdoanhthu;
import DTO.Bangdoanhthu;
import java.util.Vector;
/**
 *
 * @author Holakaka
 */
public class BLLBangdoanhthu {
    DALBangdoanhthu DALbdt=new DALBangdoanhthu();
       public int getDthu() {
       return DALbdt.getDthu();
    }
     
    public int getTienmat() {
        return DALbdt.getTienmat();
    }

    public int getVisa() {
        return DALbdt.getVisa();
    }
    public  Vector<Bangdoanhthu> getBangdoanhthu(){
            Vector<Bangdoanhthu> bangdoanhthu = new Vector();
            bangdoanhthu=DALbdt.getBangdoanhthu();
            return bangdoanhthu;
    }
 
}
