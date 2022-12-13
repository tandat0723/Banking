package Bank_System;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaiKhoan {
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

    public TaiKhoan() {}

    public TaiKhoan(String ten, double tien) {
        this.hoTen = ten;
        this.soTienGui = tien;
    }

    public TaiKhoan(String ten, String gioiTinh, String queQuan, String cccd, double tien) {
        this.hoTen = ten;
        this.setGioiTinh(gioiTinh);
        this.queQuan = queQuan;
        this.soCCCD = cccd;
        this.soTienGui = tien;
    }

    public void RutTienNganHang(double tien) {
        if (this.isNgayDaoHan())
            if (this.soTienGui >= tien)
                this.soTienGui -= tien;
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
        } else
            System.out.println("Số tiền gửi không hợp lệ");
    }

    public boolean isNgayDaoHan() {
        return true;
    }

    public double TinhTienLai() {
        return (this.soTienGui * 0.002) / 12;
    }

    @Override
    public String toString() {
        return String.format("\nSố tài khoản: %s\nHọ và tên khách hàng: %s\nSố CCCD: %s\nQuê quán: %s\nGiới tính: %s\nSố tiền: %,10.0f VNĐ\nNgày tạo tài khoản: %s\n",
                this.soTaiKhoan, this.hoTen, this.soCCCD, this.queQuan, this.getGioiTinh(), this.soTienGui, d.format(this.ngayTaoTaiKhoan));
    }

    public void ChucNang() {
        int choice;
        do {
            System.out.println("\nChức năng");
            System.out.println("1. Tính tiền lãi.");
            System.out.println("2. Gửi tiền.");
            System.out.println("3. Rút tiền.");
            System.out.println("0. Trở về.");
            System.out.print("\nChọn chức năng: ");
            do{
                choice = scanner.nextInt();
                if (choice < 0 || choice > 3)
                    System.out.print("Yêu cầu không hợp lệ.\nChọn lại: ");
            } while (choice < 0 || choice > 3);

            switch (choice) {
                case 1 -> {
                    TinhTienLai();
                }
                case 2 -> {
                    GuiTienNganHang(getSoTienGui());
                }
                case 3 -> {
                    RutTienNganHang(getSoTienGui());
                }
                default -> {
                    break;
                }
            }
        } while (choice > 0);

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
