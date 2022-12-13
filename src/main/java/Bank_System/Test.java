package Bank_System;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        TaiKhoan Tk1 = new TaiKhoan("Đạt", 200000000);
//        Tk1.GuiTienNganHang(1);
//        TaiKhoanCoKyHan Tk2 = new TaiKhoanCoKyHan("Phương", 90000000, KyHan.Sáu_Tháng);
//        TaiKhoanCoKyHan Tk3 = new TaiKhoanCoKyHan("Định", 100000000, KyHan.Mười_Hai_Tháng);
        QuanLyTaiKhoan tk = new QuanLyTaiKhoan();
        tk.Them(Tk1);
        tk.Show();
        tk.HienThiTienLai();

//        QuanLyTaiKhoanCoKyHan quanLyTaiKhoanCoKyHan = new QuanLyTaiKhoanCoKyHan();
//        quanLyTaiKhoanCoKyHan.Them(Tk2);
//        quanLyTaiKhoanCoKyHan.Them(Tk3);
//
//
//
//        quanLyTaiKhoanCoKyHan.Show();
//        quanLyTaiKhoanCoKyHan.HienThiTienLai();

    }
}
