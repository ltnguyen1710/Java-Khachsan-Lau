/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DALRoom;
import DTO.Room;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author Utech
 */
public class BLLRoom {

    DALRoom DALroom = new DALRoom();

    public String getTinhtrang(int sophong) {
        if (DALroom.getTinhtrang(sophong)) {
            return "Trong";
        }
        return "Da thue";
    }

    public Vector<Room> getRooms() {
        Vector<Room> rooms = new Vector();
        rooms = DALroom.getRooms();
        return rooms;
    }

    /* public void setPhongDathue(int sophong){
        DALroom.setPhongdathue(sophong);
    }
    public void setPhongtrong(int sophong){
        DALroom.setPhongtrong(sophong);
    }*/
    public void setTinhtrang(int sophong) {
        DALroom.setTinhtrang(sophong);
    }

    public Vector<Room> getPhongtrong(String ngaydat, String ngaytra) {
        Vector<Room> rooms = new Vector();
        rooms = DALroom.getPhongtrong(ngaydat, ngaytra);

        return rooms;
    }

    public void datphong(String idphong, String idkhach, int idnhanvien, String ngaydat, String ngaynhan, String ngaytra, int gia, int datra, String phuongthuc) {
        DALroom.datphong(idphong, idkhach, idnhanvien, ngaydat, ngaynhan, ngaytra, gia, datra, phuongthuc);
    }

    public int getGia(int sophong) {
        return DALroom.getGia(sophong);
    }
}
