package Bank_System;

import Bank_System.Model.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class QuanLyTaiKhoanNganHang {
    private List<TaiKhoan> list = new ArrayList<>();

    public void ThemTaiKhoan(TaiKhoan taiKhoan) {
        this.list.add(taiKhoan);
    }

    public void ShowTienLai(){
        this.list.forEach(taiKhoan -> System.out.printf("\n-------------------\nSố tiền lãi\nTài khoản: %s\nTên chủ tài khoản: %s\nTiền lãi hiện có là: %,8.0f VNĐ", taiKhoan.getSoTaiKhoan(), taiKhoan.getHoTen(), taiKhoan.TinhTienLai()));
    }

    public void Show(){
        this.list.forEach(taiKhoan -> System.out.println(taiKhoan));
    }

    public List<TaiKhoan> getList() {
        return list;
    }

    public void setList(List<TaiKhoan> list) {
        this.list = list;
    }
}
