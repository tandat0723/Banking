package Bank_System.Model;

public class Role {
    private int id;
    private String name;

    public Role(String ten) {
        this.name = ten;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
