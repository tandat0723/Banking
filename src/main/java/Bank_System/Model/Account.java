package Bank_System.Model;

import java.util.Scanner;

public class Account {
    private String username;
    private String password;

    private static final Scanner scanner = new Scanner(System.in);

    public Account(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    public void NhapThongTin() {
        System.out.println("--------ĐĂNG NHẬP TÀI KHOẢN---------");
        System.out.print("Tài khoản: ");
        username = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        password = scanner.nextLine().replace("[a-z][A-Z][0-9]", "*");
    }

    @Override
    public String toString() {
        return String.format("\nThông tin tài khoản\nTên tài khoản: %s\nMật khẩu: %s\n", this.username, this.password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
