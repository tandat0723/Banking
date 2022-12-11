package Bank_System;

import Bank_System.Connect.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class QuanLyTaiKhoanKhongKyHan {
    private List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private String NhapTen() {
        System.out.print("Nhập họ và tên chủ tài khoản: ");
        return scanner.nextLine();
    }

    private String NhapGioiTinh() {
        System.out.print("Giới tính: ");
        return scanner.nextLine();
    }

    private String NhapQueQuan() {
        System.out.print("Quê quán: ");
        return scanner.nextLine();
    }

    private String NhapCCCD() {
        System.out.print("Số CCCD: ");
        return scanner.nextLine();
    }

    private double NhapSoTien() {
        System.out.print("Số tiền gửi: ");
        return scanner.nextDouble();
    }

    private GregorianCalendar NgaySinh() {
        System.out.print("Nhập ngày sinh: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nNhập tháng: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nNhập năm: ");
        int year = scanner.nextInt();
        GregorianCalendar d = new GregorianCalendar(day, month, year);
        scanner.nextLine();
        return d;
    }

    public void ThemTaiKhoanKhongKyHan() throws SQLException {
        SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
        String ten = NhapTen();
        String cccd = NhapCCCD();
        String queQuan = NhapQueQuan();
        String gioiTinh = NhapGioiTinh();
        double tienGui = NhapSoTien();
        GregorianCalendar ngaySinh = NgaySinh();
        TaiKhoan taiKhoan = new TaiKhoan(ten, ngaySinh, gioiTinh, queQuan, cccd, tienGui);
        this.dsTaiKhoan.add(taiKhoan);
        System.out.println("Có muốn lưu xuống database không?");
        System.out.print("Lựa chọn của bạn(Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            SaveData(taiKhoan);
        }
    }

    public void XoaTaiKhoan(TaiKhoan taiKhoan) {
        this.dsTaiKhoan.remove(taiKhoan);
    }

    public void HienThiTienLai() {
        this.dsTaiKhoan.forEach(taiKhoan -> System.out.printf("\n-------------------\nSố tiền lãi\nTài khoản: %s\nTên chủ tài khoản: %s\nTiền lãi hiện có là: %,8.0f VNĐ", taiKhoan.getSoTaiKhoan(), taiKhoan.getHoTen(), taiKhoan.TinhTienLai()));
    }

    public void HienThiData() throws SQLException {
        System.out.println("\nHiển thị danh sách tài khoản ngân hàng");
        JDBC connect = new JDBC();
        String sql = "SELECT * FROM profile;";
        PreparedStatement ps = connect.getConnection().prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        System.out.printf("\n%5s", "ID");
        System.out.printf("%20s", "TÊN");
        System.out.printf("%20s", "GIỚI TÍNH");
        System.out.printf("%20s", "NGÀY SINH");
        System.out.printf("%20s", "QUÊ QUÁN");
        System.out.printf("%20s", "SỐ CCCD");
        System.out.printf("%20s", "SỐ TÀI KHOẢN");
        System.out.printf("%20s", "NGÀY TẠO TÀI KHOẢN");
        System.out.printf("%20s", "TIỀN GỬI");
        while (result.next()) {
            System.out.printf("\n%5d", result.getInt("id"));
            System.out.printf("%20s", result.getLong("name"));
            System.out.printf("%20s", result.getLong("sex"));
            System.out.printf("%20s", result.getLong("day_of_birth"));
            System.out.printf("%20s", result.getLong("home_town"));
            System.out.printf("%20s", result.getLong("identifier_number"));
            System.out.printf("%20s", result.getLong("account_number"));
            System.out.printf("%20s", result.getLong("account_creation_date"));
            System.out.printf("%20s", result.getLong("price"));
        }
        result.close();
        ps.close();
        ;
        connect.close();
    }

    public List<TaiKhoan> TraCuuTaiKhoan(String taiKhoan) {
        List<TaiKhoan> search = new ArrayList<>();
        for (TaiKhoan tk : this.dsTaiKhoan)
            if (tk.getHoTen().contains(taiKhoan))
                search.add(tk);
        return search;
    }

    public void TraCuuThongTin() throws SQLException {
        scanner.nextLine();
        JDBC connect = new JDBC();
        System.out.print("Nhập từ khóa: ");
        String result = scanner.nextLine();
        String sql = String.format("SELECT * from taikhoankhongkyhan where name like '%s';", "%" + result + "%");
        PreparedStatement ps = connect.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        System.out.printf("\n%5s%15s%20s%20s\n", "id", "Tên TK", "Số tài khoản", "Số tiền");
        while (rs.next()) {
            System.out.printf("%5d", rs.getInt("id"));
            System.out.printf("%15s", rs.getString("name"));
            System.out.printf("%20s", rs.getString("account_creation_date"));
            System.out.printf("%20s", rs.getDouble("price"));
        }
        rs.close();
        ps.close();
        connect.close();
    }

    public void HienThi(List<TaiKhoan> taiKhoan) {
        System.out.println("\nThông tin tài khoản không kỳ hạn");
        System.out.printf("%20s", "Tên chủ tài khoản");
        System.out.printf("%20s", "Số tài khoản");
        System.out.printf("%20s", "Số tiền");
            for (TaiKhoan tk: taiKhoan){
                System.out.printf("%20s", tk.getHoTen());
                System.out.printf("%20s", tk.getSoTaiKhoan());
                System.out.printf("%20s", tk.getSoTienGui());
        }
    }

    public void ChonChucNang() {
        ChonChucNang();
    }

    public void MenuQuanLyTaiKhoan() throws SQLException {
        int choice;
        QuanLyTaiKhoanKhongKyHan quanLyTaiKhoanKhongKyHan = new QuanLyTaiKhoanKhongKyHan();
        do {
            System.out.println("\n------------- QUẢN LÝ TÀI KHOẢN NGÂN HÀNG KHÔNG KỲ HẠN --------------");
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
            switch (choice) {
                case 1 -> ThemTaiKhoanKhongKyHan();
                case 2 -> {}
                case 3 -> ChonChucNang();
                case 4 -> {
                    System.out.print("Tra cứu thông tin tài khoản không kỳ hạn hiện tại hay Database?\n1. List hiện tại\n2. Trong database\nLựa chọn của bạn: ");
                    if (scanner.nextInt() == 1) {
                        scanner.nextLine();
                        System.out.println("Nhập tên tài khoản cần tìm kiếm: ");
                        quanLyTaiKhoanKhongKyHan.HienThi(quanLyTaiKhoanKhongKyHan.TraCuuTaiKhoan(scanner.nextLine()));
                    } else
                        TraCuuThongTin();
                }
                case 5 -> {
                    //săp xep tai khoan
                }
                case 6 -> {
                    HienThi(dsTaiKhoan);
                    HienThiData();
                }
                default -> {
                    System.out.print("\nBạn có chắc muốn trở lại?" + "\nLựa chọn của bạn là (Y/N):");
                    String tl = scanner.nextLine();
                    if (tl.toUpperCase().contains("N"))
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
        String sql = "INSERT INTO `bankdb`.`profile`(`name`, `sex`, `home_town`, `identifier_number`, `price`) VALUES(?,?,?,?,?);";
        PreparedStatement ps = connect.getConnection().prepareStatement(sql);
        ps.setString(1, taiKhoan.getHoTen());
        ps.setString(2, taiKhoan.getGioiTinh());
        ps.setString(3, taiKhoan.getQueQuan());
        ps.setString(4, taiKhoan.getSoCCCD());
        ps.setDouble(5, taiKhoan.getSoTienGui());
        ps.execute();
        ps.close();
        connect.close();
        System.out.println("Thêm tài khoản thành công!");
    }

    public void Show() {
        this.dsTaiKhoan.forEach(taiKhoan -> System.out.println(taiKhoan));
    }

    public List<TaiKhoan> getDsTaiKhoan() {
        return dsTaiKhoan;
    }

    public void setDsTaiKhoan(List<TaiKhoan> dsTaiKhoan) {
        this.dsTaiKhoan = dsTaiKhoan;
    }
}
