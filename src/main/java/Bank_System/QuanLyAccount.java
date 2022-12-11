package Bank_System;

import Bank_System.Connect.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyAccount {
    private List<Account> listAccount = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private Long NhapUserName() {
        System.out.print("Nhập username: ");
        return scanner.nextLong();
    }

    private Long NhapPassWord() {
        System.out.print("Nhập mật khẩu: ");
        long pw = (int)(Math.random()*(999999-100000+1)+100000);
//        System.out.print("Nhập lại mật khẩu: ");
//        long pw1 = scanner.nextLong();
//        scanner.nextLine();
//        if(pw != pw1){
//            System.out.print("Mật khẩu khác nhau!!!\nNhập lại: ");
//        }
        return pw;
    }

    public void ThemAccount() throws SQLException {
        Long user = NhapUserName();
        Long pass = NhapPassWord();
        scanner.nextLine();
        Account account = new Account(user, pass);
        this.listAccount.add(account);
        System.out.println("Có muốn lưu xuống database không?");
        System.out.print("Lựa chọn của bạn(Y/N): ");
        if(scanner.nextLine().equalsIgnoreCase("Y")){
            SaveData(account);
        }
    }

    public void XoaAccount() throws SQLException {
        System.out.print("Nhập ID tài khoản muốn xóa:");
        int delete = scanner.nextInt();
        scanner.nextLine();
        JDBC connect = new JDBC();
        String sql = "DELETE FROM account WHERE (id = ?);";
        PreparedStatement ps = connect.getConnection().prepareStatement(sql);
        ps.setInt(1,delete);
        ps.execute();
        System.out.println("\nXóa tài khoản thành công!!");

        //update info id
        ps.execute("ALTER TABLE account DROP id;");
        ps.execute("ALTER TABLE account AUTO_INCREMENT = 1;");
        ps.execute("ALTER TABLE account ADD id int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;");
        System.out.println("Đã cập nhật lại thông tin!");
        ps.close();
        connect.close();
    }

    public void HienThi(List<Account> accounts) {
        System.out.println("--------- TÀI KHOẢN ---------");
        System.out.printf("\n%15s","Tên tài khoản");
        System.out.printf("%15s","Mật khẩu");
        for(Account a: accounts) {
            System.out.printf("\n%15s",a.getUsername());
            System.out.printf("%15s",a.getPassword());
        }
    }

    public void SaveData(Account account) throws SQLException {
        JDBC connect  = new JDBC();
        String sql ="INSERT INTO `bankdb`.`account`(`username`, `password`) VALUES(?,?);";
        PreparedStatement ps = connect.getConnection().prepareStatement(sql);
        ps.setLong(1,account.getUsername());
        ps.setLong(2, account.getPassword());
        ps.execute();
        ps.close();;
        connect.close();
        System.out.println("Thêm tài khoản người dùng thành công!");
    }

    public void HienThiThongTinDataBase() throws SQLException {
        System.out.println("\nHiển thị danh sách tài khoản");
        JDBC connect = new JDBC();
        String sql = "SELECT * FROM account;";
        PreparedStatement ps = connect .getConnection().prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        System.out.printf("\n%5s","ID");
        System.out.printf("%20s","Username");
        System.out.printf("%20s","Password");
        while (result.next()) {
            System.out.printf("\n%5d",result.getInt("id"));
            System.out.printf("%20s",result.getLong("username"));
            System.out.printf("%20s",result.getLong("password"));
        }
        result.close();
        ps.close();;
        connect.close();
    }

    public void DoiMatKhau() throws SQLException {
        JDBC conn = new JDBC();
        System.out.print("Nhập mật khẩu mới: ");
        long newPass = scanner.nextLong();
        scanner.nextLine();
        String sql = "UPDATE account SET password = \""+newPass+"\" WHERE ID = ?;";
        PreparedStatement ps = conn.getConnection().prepareStatement(sql);
        System.out.print("Nhập ID tài khoản: ");
        ps.setInt(1,scanner.nextInt());
        scanner.nextLine();
        ps.executeUpdate();
        ps.close();
        conn.close();
        System.out.println("\nĐã cập nhật!!");
    }

    public void DangNhap() throws SQLException {
        JDBC conn = new JDBC();
        System.out.println("---------- Đăng nhập tài khoản ----------");
        System.out.print("Username: ");
        long user = scanner.nextLong();
        System.out.print("Password: ");
        long pass = scanner.nextLong();
        scanner.nextLine();
        String sql = String.format("SELECT * from account where username like '%s' && password like '%s';","%"+user+"%","%"+pass+"%");
        PreparedStatement ps = conn.getConnection().prepareStatement(sql);
        ps.execute();
        ps.close();
        conn.close();
        System.out.println("Đăng nhập thành công!!!");
    }

    public void MenuQuanLyAccount() throws SQLException {
        int choice;
        do {
            System.out.println("\n---------------------- QUẢN LÝ DỊCH VỤ ----------------------");
            System.out.println("1. Thêm tài khoản.");
            System.out.println("2. Xóa tài khoản.");
            System.out.println("3. Hiển thị thông tin danh sách tài khoản.");
            System.out.println("4. Đổi mật khẩu");
            System.out.println("0. Lưu dữ liệu và trở về.");
            System.out.print("\nMời chọn chức năng: ");

            do {
                choice = scanner.nextInt();
                if (choice < 0 || choice > 4)
                    System.out.print("Yêu cầu không hợp lệ!!\nChọn lại: ");
            } while (choice < 0 || choice > 4);
            scanner.nextLine();

            switch (choice) {
                case 1 ->{
                    ThemAccount();
                }
                case 2 -> {
                    XoaAccount();
                }
                case 3 -> {
                    HienThiThongTinDataBase();
                }
                case 4 -> {
                    DoiMatKhau();
                }
                default -> {
                    System.out.print("\nBạn có chắc muốn trở lại?" + "\nLựa chọn của bạn là (Y/N):");
                    String tl = scanner.nextLine();
                    if(tl.toUpperCase().contains("N"))
                        choice = 1;
                    else {
                        System.out.println("\n<-- Trở về\n");
                    }
                }
            }
        } while(choice> 0);
    }
}
