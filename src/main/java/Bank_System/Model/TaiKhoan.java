package Bank_System.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TaiKhoan {
    public static final SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
    private static int demSoTaiKhoan = 0;
    private String soTaiKhoan;
    private String hoTen;
    private Boolean gioiTinh;
    private Date ngaySinh;
    private String queQuan;
    private String soCCCD;
    private double soTienGui;
    private Date ngayTaoTaiKhoan;

    {
        ngayTaoTaiKhoan = new Date();
        soTaiKhoan = String.format("%s%04d", d.format(this.ngayTaoTaiKhoan.getTime()).replace("/",""), ++demSoTaiKhoan);

    }

    public TaiKhoan(String ten, double tien) {
        this.hoTen = ten;
        this.soTienGui = tien;
    }

    public void RutTienNganHang(double tien){
        if(this.isNgayDaoHan() == true){
            if(this.soTienGui >= tien){
                this.soTienGui -= tien;
            }
        }
    }

    public void GuiTienNganHang(double tien){
        if(this.isNgayDaoHan() == true){
            this.soTienGui += tien;
        }
    }

    public boolean isNgayDaoHan(){
        return true;
    }

    public double TinhTienLai(){
        return (this.soTienGui*0.002)/12;
    }


    @Override
    public String toString() {
        return String.format("\nSố tài khoản: %s\nHọ và tên khách hàng: %s\nSố CCCD: %s\nQuê quán: %s\nNgày sinh: %s\nGiới tính: %s\nSố tiền: %,10.0f VNĐ\nNgày tạo tài khoản: %s\n",
                this.soTaiKhoan, this.hoTen, this.soCCCD, this.queQuan, this.ngaySinh, this.gioiTinh, this.soTienGui, d.format(this.ngayTaoTaiKhoan));
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public Date getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(Date ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }


    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
