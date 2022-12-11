package Bank_System;

import java.util.Scanner;

public class Account {
    private Long username;
    private Long password;

    private static final Scanner scanner = new Scanner(System.in);

    public Account(Long user, Long pass) {
        this.username = user;
        this.password = pass;
    }

    @Override
    public String toString() {
        return String.format("\nThông tin tài khoản\nTên tài khoản: %s\nMật khẩu: %s\n", this.username, this.password);
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }
}
