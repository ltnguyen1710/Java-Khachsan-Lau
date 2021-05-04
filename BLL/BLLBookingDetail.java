/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DTO.BookingDetail;
import DAL.DALBookingDetail;
import java.util.Vector;
/**
 *
 * @author Utech
 */
public class BLLBookingDetail {
    private DALBookingDetail DALbd=new DALBookingDetail();
    private Vector<BookingDetail>bdList=new Vector();
    public Vector<BookingDetail> getbdList(){
        bdList=DALbd.getbookingdetaillist();
        return bdList;
    }
    public void setDetailtrasau(String cmnd, String ngaydat, String phuongthuc,int gia,String ngaytra,String idphong) {
        DALbd.setDetailtrasau(cmnd, ngaydat, phuongthuc,gia,ngaytra,idphong);
    }
    public void huy(String ngaydat,String cmnd,String idphong){
        DALbd.huy(ngaydat, cmnd, idphong);
    }
    
}
