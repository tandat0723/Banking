package Bank_System;


import Bank_System.Connect.JDBC;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TaiKhoanCoKyHan extends TaiKhoan {
    private KyHan kyHan;
    private Calendar ngayDaohan;

    public TaiKhoanCoKyHan(String ten, double tien, KyHan kyhan) {
        super(ten, tien);
        this.setKyHan(kyhan);
        this.ngayDaohan = this.getKyHan().TinhNgayDaoHan(new GregorianCalendar());
    }

    public TaiKhoanCoKyHan(String ten, GregorianCalendar ngaySinh, String gioiTinh, String queQuan, String cccd, double tien, KyHan kyhan) {
        super(ten, ngaySinh, gioiTinh, queQuan, cccd, tien);
        this.setKyHan(kyhan);
        this.ngayDaohan = this.getKyHan().TinhNgayDaoHan(new GregorianCalendar());
    }

    @Override
    public boolean isNgayDaoHan() {
        Calendar ca = new GregorianCalendar();
        String s = d.format(this.ngayDaohan.getTime());
        String s1 = d.format(ca.getTime());

        return s.equals(s1);
    }

    @Override
    public double TinhTienLai() {
        return this.getKyHan().TinhLai(this.getSoTienGui());
    }

    @Override
    public String toString() {
        return String.format("--------------------------------\nTài khoản có kỳ hạn\n%sKỳ hạn: %s\nNgày đáo hạn: %s\n",
                super.toString(), this.getKyHan(), d.format(this.ngayDaohan.getTime()));
    }

    public void ChucNang() {

    }

    public Calendar getNgayDaohan() {
        return ngayDaohan;
    }

    public void setNgayDaohan(Calendar ngayDaohan) {
        this.ngayDaohan = ngayDaohan;
    }

    public KyHan getKyHan() {
        return kyHan;
    }

    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }
}
