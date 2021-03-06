package BLL;

import DTO.BookingDetail;
import DAL.DALBookingDetail;
import java.util.Vector;

public class BLLBookingDetail {

    private DALBookingDetail DALbd = new DALBookingDetail();
    private Vector<BookingDetail> bdList = new Vector();

    public Vector<BookingDetail> getbdList() {
        bdList = DALbd.getbookingdetaillist();
        return bdList;
    }

    public void setDetailtrasau(String cmnd, String ngaynhan, String phuongthuc, int gia, String idphong) {
        DALbd.setDetailtrasau(cmnd, ngaynhan, phuongthuc, gia, idphong);
    }

    public void huy(String cmnd, String ngaynhan, String phuongthuc, int gia, String idphong) {
        DALbd.huy(cmnd, ngaynhan, phuongthuc, gia, idphong);
    }

    public void huy(String ngaynhan, String cmnd, String idphong) {
        DALbd.huy(ngaynhan, cmnd, idphong);
    }

    public BookingDetail thongtinphong(int sophong, String today) {
        return DALbd.thongtinphong(sophong, today);
    }

}
