


package QUANLYSINHVIEN;

public class SinhVien {
    String mssv;
    String hoten;
    String malop;
    double diemlt;
    double diemth;
    
    SinhVien(String mssv, String hoten, String malop, double diemlt, double diemth){
        this.mssv=mssv;
        this.hoten=hoten;
        this.malop=malop;
        this.diemlt=diemlt;
        this.diemth=diemth;
                
    }
    SinhVien(String mssv){
        this.mssv=mssv;
    }
    void setMssv(String mssv){
        this.mssv=mssv;
    }
    public String getMssv(){
        return mssv;
    }
    void setHoten(String hoten){
        this.hoten=hoten;
    }
    public String getHoten(){
        return hoten;
    }    
    void setMalop (String malop){
        this.malop=malop;
    }
    public String getMalop (){
        return malop;
    } 
    void setDiemlt (double diemlt){
        this.diemlt=diemlt;
    }
    public double getDiemlt(){
        return diemlt;
    }
    void setDiemth (double diemth){
        this.diemth=diemth;
    }
    public double getDiemth(){
        return diemth;
    }
    public double diemTB(){
        return (diemth+diemlt)/2;
    }
    public String ketQua(){
        if(diemTB()>=5)
            return "Đậu";
        return "Rớt";
    }
   4 
}
