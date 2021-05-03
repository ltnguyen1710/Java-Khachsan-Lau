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
    private int tralan1;
    private int tralan2;

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

    public int getTralan1() {
        return tralan1;
    }

    public void setTralan1(int tralan1) {
        this.tralan1 = tralan1;
    }

    public int getTralan2() {
        return tralan2;
    }

    public void setTralan2(int tralan2) {
        this.tralan2 = tralan2;
    }

    
    
}
