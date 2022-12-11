package Bank_System;

import Bank_System.Connect.JDBC;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class QuanLyTaiKhoanCoKyHan {
    List<TaiKhoanCoKyHan> dsTaiKhoanCoKyHan = new ArrayList<>();

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

    private GregorianCalendar NgaySinh() {
        System.out.println("Nhập ngày sinh: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tháng: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập năm: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        GregorianCalendar d = new GregorianCalendar(day, month, year);
        scanner.nextLine();

        return d;
    }

    private KyHan NhapKyhan() {
        System.out.println("Nhập thông tin kỳ hạn(1 tuần - 1|6|12 tháng): ");
        String s;
        if (scanner.nextLine().equalsIgnoreCase("Tuần")) {
            return KyHan.Một_Tuần;
        } else if (scanner.nextLine().equalsIgnoreCase("Một_Tháng")) {
            return KyHan.Một_Tháng;
        } else if (scanner.nextLine().equalsIgnoreCase("S")) {
            return KyHan.Sáu_Tháng;
        } else {
            return KyHan.Mười_Hai_Tháng;
        }
    }

    public void ThemTaiKhoanCoKyHan() throws SQLException {
        SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
        String ten = NhapTen();
        String cccd = NhapCCCD();
        String queQuan = NhapQueQuan();
        String gioiTinh = NhapGioiTinh();
        double tienGui = NhapSoTien();
        GregorianCalendar ngaySinh = NgaySinh();
        KyHan kyHan = NhapKyhan();
        TaiKhoanCoKyHan taiKhoanCoKyHan = new TaiKhoanCoKyHan(ten, ngaySinh, gioiTinh, queQuan, cccd, tienGui, kyHan);
        this.dsTaiKhoanCoKyHan.add(taiKhoanCoKyHan);
        System.out.println("Có muốn lưu xuống database không?");
        System.out.print("Lựa chọn của bạn(Y/N): ");
        if(scanner.nextLine().equalsIgnoreCase("Y")){
            SaveData(taiKhoanCoKyHan);
        }
    }

    public void XoaTaiKhoan() {}

    public void MenuQuanLyTaiKhoanCoKyHan() throws SQLException {
        int choice;
        QuanLyTaiKhoanCoKyHan quanLyTaiKhoanCoKyHan = new QuanLyTaiKhoanCoKyHan();
        do {
            System.out.println("\n------------- QUẢN LÝ TÀI KHOẢN NGÂN HÀNG CÓ KỲ HẠN --------------");
            System.out.println("1. Mở tài khoản.");
            System.out.println("2. Xóa tài khoản");
            System.out.println("3. Chức năng.");
            System.out.println("4. Tra cứu khách hàng.");
            System.out.println("5. Sắp xếp tài khoản.");
            System.out.println("6. Hiển thị thông tin tài khoản.");
            System.out.println("0. Trở về Menu chính.");
            System.out.print("\nMời chọn chức năng: ");
            do {
                choice = scanner.nextInt();
                if (choice < 0 || choice >= 8)
                    System.out.print("Yêu cầu không hợp lệ.\nChọn lại: ");
            } while (choice < 0 || choice >= 8);
            scanner.nextLine();

            switch (choice){
                case 1 -> ThemTaiKhoanCoKyHan();
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case  6 ->{}
                default -> {
                    System.out.print("\nBạn có chắc muốn trở lại?" + "\nLựa chọn của bạn là (Y/N):");
                    String tl = scanner.nextLine();
                    if(tl.toUpperCase().contains("N"))
                        choice = 4;
                    else {
                        System.out.println("\n<-- Trở về\n");
                    }
                }
            }
        } while (choice > 0);
    }

    public void SaveData(TaiKhoan taiKhoan) throws SQLException {
        JDBC connect = new JDBC();
        SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
        String sql = "INSERT INTO profile (`name`, `sex`, `day_of_birth`, `home_town`, `identifier_number`, `account_number`, `account_creation_date`, `price`) VALUE (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connect.getConnection().prepareStatement(sql);
        ps.setString(1,taiKhoan.getHoTen());
        ps.setString(2, taiKhoan.getGioiTinh());
        ps.setString(3, dmy.format(taiKhoan.getNgaySinh()));
        ps.setString(4, taiKhoan.getQueQuan());
        ps.setString(5, taiKhoan.getSoCCCD());
        ps.setString(6, taiKhoan.getSoTaiKhoan());
        ps.setString(7, dmy.format(taiKhoan.getNgayTaoTaiKhoan()));
        ps.setDouble(8, taiKhoan.getSoTienGui());
        ps.execute();
        ps.close();
        connect.close();
        System.out.println("Mở khoản có kỳ hạn thành công.");
    }

}

