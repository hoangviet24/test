package Model;
public class Menu {
    private int id;
    private String name;
    private String des;
    private double price;
    private String type;
    protected static int NextId = 1;
    public Menu(){}
    public Menu(int id, String name, String des, double price, String type) {
        this.id = NextId;
        this.name = name;
        this.des = des;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                '}';
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
