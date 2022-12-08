package Bank_System;

import Bank_System.Model.TaiKhoan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyTaiKhoanNganHang {
    private List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private String NhapTen() {
        System.out.println("\nNhập họ và tên chủ tài khoản: ");
        return scanner.nextLine();
    }

    private String NhapGioiTinh() {
        System.out.println("Giới tính: ");
        return scanner.nextLine();
    }

    private String NhapQueQuan() {
        System.out.println("Quê quán: ");
        return scanner.nextLine();
    }

    private String NhapCCCD() {
        System.out.println("Số CCCD: ");
        return scanner.nextLine();
    }

    private double NhapSoTien() {
        System.out.println("Số tiền gửi: ");
        return scanner.nextDouble();
    }


    public void ThemTaiKhoan(TaiKhoan taiKhoan) {
        this.dsTaiKhoan.add(taiKhoan);
    }

    public void XoaTaiKhoan(TaiKhoan taiKhoan) {
        this.dsTaiKhoan.remove(taiKhoan);
    }

    public void ShowTienLai() {
        this.dsTaiKhoan.forEach(taiKhoan -> System.out.printf("\n-------------------\nSố tiền lãi\nTài khoản: %s\nTên chủ tài khoản: %s\nTiền lãi hiện có là: %,8.0f VNĐ", taiKhoan.getSoTaiKhoan(), taiKhoan.getHoTen(), taiKhoan.TinhTienLai()));
    }

    public void MenuQuanLyTaiKhoan() {
        int choice;
        QuanLyTaiKhoanNganHang quanLyTaiKhoanNganHang = new QuanLyTaiKhoanNganHang();
        do {
            System.out.println("------------- QUẢN LÝ TÀI KHOẢN NGÂN HÀNG --------------");
            System.out.println("1. Mở tài khoản có kỳ hạn(đảm bảo tài khoản chính còn tối thiểu 50.000VNĐ).");
            System.out.println("2. Tính tiền lãi.");
            System.out.println("3. Gửi tiền");
            System.out.println("4. Rút tiền");
            System.out.println("5. ");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } while ()
    }

    public void Show() {
        this.dsTaiKhoan.forEach(taiKhoan -> System.out.println(taiKhoan));
    }

    public List<TaiKhoan> getDsTaiKhoan() {
        return dsTaiKhoan;
    }

    public void setDsTaiKhoan(List<TaiKhoan> dsTaiKhoan) {
        this.dsTaiKhoan = dsTaiKhoan;
    }
}
