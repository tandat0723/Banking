package Bank_System;

import Bank_System.Model.TaiKhoan;

import java.util.Date;
import java.util.Scanner;

public class TaiKhoanKhongKyHan extends TaiKhoan {
    private static final Scanner scanner = new Scanner(System.in);

    public TaiKhoanKhongKyHan(String ten, double tien) {
        super(ten, tien);
    }

    public TaiKhoanKhongKyHan(String ten, String gioiTinh, String queQuan, Date ngaySinh, String cccd, double tien) {
        super(ten, gioiTinh, queQuan, ngaySinh, cccd, tien);
    }

    @Override
    public void RutTienNganHang(double tien) {
        super.RutTienNganHang(tien);
    }

    @Override
    public void GuiTienNganHang(double tien) {
        super.GuiTienNganHang(tien);
    }

    @Override
    public double TinhTienLai() {
        return super.TinhTienLai();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
