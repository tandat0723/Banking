package Bank_System.Model;

public class Account {
    private String username;
    private String password;

    public Account(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    @Override
    public String toString() {
        return String.format("\nThông tin tài khoản\nTên tài khoản: %s\nMật khẩu: %s\n",this.username,this.password);
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
