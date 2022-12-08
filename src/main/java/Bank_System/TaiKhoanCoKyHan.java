package Bank_System;


import Bank_System.Model.TaiKhoan;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TaiKhoanCoKyHan extends TaiKhoan {
    private KyHan kyHan;
    private Calendar ngayDaohan;

    private static final Scanner scanner = new Scanner(System.in);

    private String NhapTen() {
        System.out.println("Tên chủ tài khoản: ");
        return scanner.nextLine();
    }

    private String NhapGioiTinh() {
        System.out.println("Giới tính: ");
        return scanner.nextLine();
    }

    private double NhapTien() {
        System.out.println("Số tiền gửi: ");
        double tien = scanner.nextDouble();
        scanner.nextLine();
        return tien;
    }

    private String NgaySinh() {
        System.out.println("Ngày sinh: ");

        return scanner.nextLine();
    }


    public TaiKhoanCoKyHan(String ten, double tien, KyHan kyhan) {
        super(ten, tien);
        this.kyHan = kyhan;
        this.ngayDaohan = this.kyHan.TinhNgayDaoHan(new GregorianCalendar());
    }

    public TaiKhoanCoKyHan(String ten, String gioiTinh, String queQuan, Date ngaySinh, String cccd, double tien, KyHan kyhan) {
        super(ten, gioiTinh, queQuan, ngaySinh, cccd, tien);
        this.kyHan = kyhan;
        this.ngayDaohan = this.kyHan.TinhNgayDaoHan(new GregorianCalendar());
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
        return this.kyHan.TinhLai(this.getSoTienGui());
    }

    @Override
    public String toString() {
        return String.format("--------------------------------\nTài khoản có kỳ hạn\n%sKỳ hạn: %s\nNgày đáo hạn: %s\n",
                super.toString(), this.kyHan, d.format(this.ngayDaohan.getTime()));
    }

    public KyHan getKyHan() {
        return kyHan;
    }

    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }

    public Calendar getNgayDaohan() {
        return ngayDaohan;
    }

    public void setNgayDaohan(Calendar ngayDaohan) {
        this.ngayDaohan = ngayDaohan;
    }
}
