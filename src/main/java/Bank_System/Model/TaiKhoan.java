package Bank_System.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class TaiKhoan {
    public static final SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
    private static int demSoTaiKhoan = 0;
    private String soTaiKhoan;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String queQuan;
    private String soCCCD;
    private Double soTienGui;
    private Date ngayTaoTaiKhoan;
    private static final Scanner scanner = new Scanner(System.in);


    {
        ngayTaoTaiKhoan = new Date();
        soTaiKhoan = String.format("%s%04d", d.format(this.ngayTaoTaiKhoan.getTime()).replace("/", ""), ++demSoTaiKhoan);

    }

    public TaiKhoan() {
    }

    public TaiKhoan(String ten, double tien) {
        this.hoTen = ten;
        this.soTienGui = tien;
    }

    public TaiKhoan(String ten, String gioiTinh, String queQuan, Date ngaySinh, String cccd, double tien) {
        this.hoTen = ten;
        this.setGioiTinh(gioiTinh);
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.soCCCD = cccd;
        this.soTienGui = tien;
    }

    public void RutTienNganHang(double tien) {
        if (this.isNgayDaoHan()) {
            if (this.soTienGui >= tien) {
                this.soTienGui -= tien;
            }
        }
    }

    public void GuiTienNganHang(double tien) {
        System.out.print("Số tiền bạn muốn gửi là: ");
        tien = scanner.nextDouble();
        //check dieu kien nap tien nho hon 50.000vnd và ngày đáo hạn
        if (tien >= 50000) {
            if (this.isNgayDaoHan()) {
                this.soTienGui += tien;
                System.out.println("Bạn vừa nạp " + soTienGui + " VNĐ vào tài khoản");
            }
        } else {
            System.out.println("Số tiền gửi không hợp lệ");
        }

    }

    public boolean isNgayDaoHan() {
        return true;
    }

    public double TinhTienLai() {
        return (this.soTienGui * 0.002) / 12;
    }


    @Override
    public String toString() {
        return String.format("\nSố tài khoản: %s\nHọ và tên khách hàng: %s\nSố CCCD: %s\nQuê quán: %s\nNgày sinh: %s\nGiới tính: %s\nSố tiền: %,10.0f VNĐ\nNgày tạo tài khoản: %s\n",
                this.soTaiKhoan, this.hoTen, this.soCCCD, this.queQuan, d.format(this.ngaySinh), this.getGioiTinh(), this.soTienGui, d.format(this.ngayTaoTaiKhoan));
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


    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
