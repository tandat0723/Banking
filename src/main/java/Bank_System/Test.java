package Bank_System;

import Bank_System.Model.TaiKhoan;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

//        int choice;
//        do {
//            System.out.println("---------------------------------------------------------------");
//            System.out.println("---------------QUẢN LÝ TÀI KHOẢN NGÂN HÀNG---------------------");
//            System.out.println("1. Tạo tài khoản ngân hàng.");
//            System.out.println("2. Đăng nhập tài khoản.");
//            System.out.println("3. Thoát chương trình.");
//            System.out.print("Mời: ");
//            do {
//                choice = scanner.nextInt();
//                if (choice <= 0 || choice >= 4)
//                    System.out.println("Mời bạn chọn lại!!!");
//            } while (choice <= 0 || choice >= 4);
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//
//                    break;
//                case 2:
//
//                    break;
//                case 3:
//
//                    break;
//                case 4:
//
//                    break;
//            }
//        } while (choice > 0);

        TaiKhoan Tk1 = new TaiKhoanKhongKyHan("Trần Tân Đạt", 2000000);
        Tk1.GuiTienNganHang(900000);
        TaiKhoan Tk2 = new TaiKhoanCoKyHan("Dẹo Phương", 9000000, KyHan.Sáu_Tháng);
        TaiKhoan Tk3 = new TaiKhoanCoKyHan("Định", 10292763, KyHan.Mười_Hai_Tháng);

        QuanLyTaiKhoanNganHang tk = new QuanLyTaiKhoanNganHang();
        tk.ThemTaiKhoan(Tk1);
        tk.ThemTaiKhoan(Tk2);
        tk.ThemTaiKhoan(Tk3);

        tk.Show();
        tk.ShowTienLai();
    }
}
