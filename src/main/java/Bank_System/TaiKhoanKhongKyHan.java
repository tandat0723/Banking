package Bank_System;

import Bank_System.Model.TaiKhoan;

public class TaiKhoanKhongKyHan extends TaiKhoan {
    public TaiKhoanKhongKyHan(String ten, double tien) {
        super(ten, tien);
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
