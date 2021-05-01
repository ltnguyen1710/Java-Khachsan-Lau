
package DTO;

import java.util.Date;


public class Staff {
    //vua them Staff thoi !!!
    private int id;
    private String ten;
    private String ngaysinh;
    private String ngayvaolam;
    private String gioitinh;
    private String taikhoan;
    private String matkhau;

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getNgayvaolam() {
        return ngayvaolam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setNgayvaolam(String ngayvaolam) {
        this.ngayvaolam = ngayvaolam;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }


    public Staff(){
        
    }
}
