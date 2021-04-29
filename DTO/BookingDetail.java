/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Utech
 */
public class BookingDetail {
    private int iddatphong;
    private String idphong;
    private int idkhach;
    private int idnhanvien;
    private Date ngaydat;
    private Date ngaytra;
    private int gia;
    private int datra;
    private String ThanhToan;

    public int getIddatphong() {
        return iddatphong;
    }

    public void setIddatphong(int iddatphong) {
        this.iddatphong = iddatphong;
    }

    public String getIdphong() {
        return idphong;
    }

    public void setIdphong(String idphong) {
        this.idphong = idphong;
    }

    public int getIdkhach() {
        return idkhach;
    }

    public void setIdkhach(int idkhach) {
        this.idkhach = idkhach;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public Date getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(Date ngaydat) {
        this.ngaydat = ngaydat;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getDatra() {
        return datra;
    }

    public void setDatra(int datra) {
        this.datra = datra;
    }
    public void setThanhToan(String ThanhToan){
        this.ThanhToan=ThanhToan;
    }
    public String getThanhToan(){
        return ThanhToan;
    }
}
