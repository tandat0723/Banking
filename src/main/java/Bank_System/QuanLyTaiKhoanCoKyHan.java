package Bank_System;

import Bank_System.Connect.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class QuanLyTaiKhoanCoKyHan {
    private List<TaiKhoanCoKyHan> dsTaiKhoanCoKyHan = new ArrayList<>();

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

    private Date NgaySinh() {
        System.out.print("Nhập ngày sinh: ");
        int day = scanner.nextInt();
        System.out.print("\nNhập tháng: ");
        int month = scanner.nextInt();
        System.out.print("\nNhập năm: ");
        int year = scanner.nextInt();
        Date d = new Date(day, month, year);
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

    public void Them(TaiKhoanCoKyHan taiKhoanCoKyHan){
        this.getDsTaiKhoanCoKyHan().add(taiKhoanCoKyHan);
    }

    public void ThemTaiKhoanCoKyHan() throws SQLException {
        SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
        String ten = NhapTen();
        String cccd = NhapCCCD();
        String queQuan = NhapQueQuan();
        String gioiTinh = NhapGioiTinh();
        double tienGui = NhapSoTien();
        KyHan kyHan = NhapKyhan();
        TaiKhoanCoKyHan taiKhoanCoKyHan = new TaiKhoanCoKyHan(ten, gioiTinh, queQuan, cccd, tienGui, kyHan);
        this.getDsTaiKhoanCoKyHan().add(taiKhoanCoKyHan);
        System.out.println("Có muốn lưu không?");
        System.out.print("Lựa chọn của bạn(Y/N): ");
        if(scanner.nextLine().equalsIgnoreCase("Y")){
            SaveData(taiKhoanCoKyHan);
        }
    }

    public void XoaTaiKhoan() throws SQLException {
        System.out.print("Nhập ID tài khoản muốn xóa:");
        int delete = scanner.nextInt();
        scanner.nextLine();
        JDBC con = new JDBC();
        String sql = "DELETE FROM taikhoancokyhan WHERE (id = ?);";
        PreparedStatement ps = con.getConnection().prepareStatement(sql);
        ps.setInt(1,delete);
        ps.execute();
        System.out.println("Xóa thành công!!");

        ps.execute("ALTER TABLE taikhoancokyhan DROP id;");
        ps.execute("ALTER TABLE taikhoancokyhan AUTO_INCREMENT = 1;");
        ps.execute("ALTER TABLE taikhoancokyhan ADD id int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;");
        System.out.println("Đã cập nhật lại ID!");
        ps.close();
        con.close();
    }

    public List<TaiKhoanCoKyHan> TraCuuTaiKhoan(String taiKhoan) {
        List<TaiKhoanCoKyHan> search = new ArrayList<>();
        for (TaiKhoanCoKyHan tk : this.getDsTaiKhoanCoKyHan())
            if (tk.getHoTen().contains(taiKhoan))
                search.add(tk);
        return search;
    }

    public void TraCuuThongTin() throws SQLException {
        scanner.nextLine();
        JDBC connect = new JDBC();
        System.out.print("Nhập từ khóa: ");
        String result = scanner.nextLine();
        String sql = String.format("SELECT * from taikhoancokyhan where name like '%s';", "%" + result + "%");
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

    public void HienThi(List<TaiKhoanCoKyHan> taiKhoan) {
        System.out.println("\nThông tin tài khoản không kỳ hạn");
        System.out.printf("%20s", "Tên chủ tài khoản");
        System.out.printf("%20s", "Số tài khoản");
        System.out.printf("%20s", "Số tiền");
        for (TaiKhoanCoKyHan tk: taiKhoan){
            System.out.printf("%20s", tk.getHoTen());
            System.out.printf("%20s", tk.getSoTaiKhoan());
            System.out.printf("%20s", tk.getSoTienGui());
        }
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
        System.out.printf("%20s", "KỲ HẠN");
        while (result.next()) {
            System.out.printf("\n%5d", result.getInt("id"));
            System.out.printf("%20s", result.getString("name"));
            System.out.printf("%20s", result.getString("sex"));
            System.out.printf("%20s", result.getDate("day_of_birth"));
            System.out.printf("%20s", result.getString("home_town"));
            System.out.printf("%20s", result.getString("identifier_number"));
            System.out.printf("%20s", result.getString("account_number"));
            System.out.printf("%20s", result.getDate("account_creation_date"));
            System.out.printf("%20s", result.getDouble("price"));
            System.out.printf("%20s", result.getString("kyhan"));
        }
        result.close();
        ps.close();
        connect.close();
    }


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
                case 2 -> XoaTaiKhoan();
                case 3 -> {
                    TaiKhoan taiKhoan = new TaiKhoanCoKyHan();
                    taiKhoan.ChucNang();
                }
                case 4 -> {
                    System.out.print("Tra cứu thông tin tài khoản không kỳ hạn hiện tại hay Database?\n1. List hiện tại\n2. Trong database\nLựa chọn của bạn: ");
                    if (scanner.nextInt() == 1) {
                        scanner.nextLine();
                        System.out.println("Nhập tên tài khoản cần tìm kiếm: ");
                        quanLyTaiKhoanCoKyHan.HienThi(quanLyTaiKhoanCoKyHan.TraCuuTaiKhoan(scanner.nextLine()));
                    } else
                        TraCuuThongTin();
                }
                case 5 -> {
                    //sắp xếp
                }
                case  6 ->{
                    HienThi(getDsTaiKhoanCoKyHan());
                    HienThiData();
                }
                default -> {
                    break;
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
        System.out.println("Mở khoản không kỳ hạn thành công.");
    }
    public void Show() {
        this.dsTaiKhoanCoKyHan.forEach(System.out::println);
    }

    public void HienThiTienLai() {
        this.dsTaiKhoanCoKyHan.forEach(taiKhoan -> System.out.printf("\n-------------------\nSỐ TIỀN LÃI\n\nTài khoản: %s\nTên chủ tài khoản: %s\nTiền lãi hiện có là: %,8.0f VNĐ", taiKhoan.getSoTaiKhoan(), taiKhoan.getHoTen(), taiKhoan.TinhTienLai()));
    }

    public List<TaiKhoanCoKyHan> getDsTaiKhoanCoKyHan() {
        return dsTaiKhoanCoKyHan;
    }

    public void setDsTaiKhoanCoKyHan(List<TaiKhoanCoKyHan> dsTaiKhoanCoKyHan) {
        this.dsTaiKhoanCoKyHan = dsTaiKhoanCoKyHan;
    }
}

