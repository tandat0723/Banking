package Bank_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---------------------------------------------------------------");
            System.out.println("---------------QUẢN LÝ TÀI KHOẢN NGÂN HÀNG---------------------");
            System.out.println("1. Tạo tài khoản ngân hàng.");
            System.out.println("2. Đăng nhập tài khoản.");
            System.out.println("0. Thoát khỏi chương trình!");
            System.out.print("Mời quý khách chọn: ");
            do {
                choice = scanner.nextInt();
                if (choice < 0 || choice >= 4)
                    System.out.print("Yêu cầu không hợp lệ. Mời bạn chọn lại: ");
            } while (choice < 0 || choice >= 4);
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    QuanLyTaiKhoanNganHang quanLyTaiKhoanNganHang = new QuanLyTaiKhoanNganHang();
                }
                break;
                case 2: {
                    QuanLyAccount quanLyDangNhap = new QuanLyAccount();
                }
                break;
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
