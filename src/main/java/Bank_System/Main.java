package Bank_System;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean checkIn = false;
        do {
            System.out.println("\n-----------------------------------------------------------------------");
            System.out.println("--------------------- QUẢN LÝ TÀI KHOẢN NGÂN HÀNG ---------------------");
            System.out.println("1. Tạo tài khoản khách hàng.");
            System.out.println("2. Đăng nhập tài khoản.");
            System.out.println("3. Tài khoản không kỳ hạn.");
            System.out.println("4. Tài khoản có kỳ hạn.");
            System.out.println("0. Thoát khỏi chương trình!");
            System.out.print("\nMời quý khách chọn: ");
            do {
                choice = scanner.nextInt();
                if (choice < 0 || choice > 4)
                    System.out.print("Yêu cầu không hợp lệ.\nChọn lại: ");
            } while (choice < 0 || choice > 4);
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    QuanLyAccount quanLyAccount = new QuanLyAccount();
                    quanLyAccount.MenuQuanLyAccount();
                }
                case 2: {
                    QuanLyAccount quanLyAccount = new QuanLyAccount();
                    quanLyAccount.DangNhap();
                    checkIn = true;
                    break;
                }
                case 3: {
                    if(checkIn != true){
                        System.out.println("\nBạn hãy đăng nhập trước");
                        break;
                    } else {
                        QuanLyTaiKhoanKhongKyHan quanLyTaiKhoanNganHang = new QuanLyTaiKhoanKhongKyHan();
                        quanLyTaiKhoanNganHang.MenuQuanLyTaiKhoan();
                    }
                }
                case 4: {
                    if(checkIn != true){
                        System.out.println("\nBạn hãy đăng nhập trước");
                        break;
                    } else {
                        QuanLyTaiKhoanCoKyHan quanLyTaiKhoanCoKyHan = new QuanLyTaiKhoanCoKyHan();
                        quanLyTaiKhoanCoKyHan.MenuQuanLyTaiKhoanCoKyHan();
                    }
                }
                default: {
                    int tick;
                    System.out.println("\n-------------------------\nBạn chắc chắn muốn thoát?");
                    System.out.println("Chọn (1) để quay lại.");
                    System.out.println("Chọn (2) để thoát.");
                    System.out.print("Mời quý khách chọn: ");
                    tick = scanner.nextInt();
                    scanner.nextLine();

                    if (tick == 1) {
                        break;
                    } else {
                        System.out.println("Thoát!!");
                        return;
                    }
                }
            }
        } while (true);
    }
}
