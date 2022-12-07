package Bank_System;


import Bank_System.Model.TaiKhoan;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TaiKhoanCoKyHan extends TaiKhoan {
    private KyHan kyHan;
    private Calendar ngayDaohan;


    public TaiKhoanCoKyHan(String ten, double tien, KyHan kyhan) {
        super(ten, tien);
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
