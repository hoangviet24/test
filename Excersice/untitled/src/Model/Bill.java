package Model;
import global.Global;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Bill {
    private static final long serialVersionUID = 1L;
    private int Id;
    private final Global global = Global.getInstance();
    protected Menu menu = new Menu();
    private String name = menu.getName();
    private String type = menu.getType();
    private LocalDateTime orderDate = LocalDateTime.now();
    protected int count;
    protected int total;
    protected int price ;
    protected static int NextId = 1;
    public Bill(){}
    public Bill(int Id,String type,String name,LocalDateTime orderDate,int count,int total,int price){
        this.Id = NextId;
        this.type = type;
        this.name= name;
        this.orderDate = orderDate;
        this.count = count;
        this.total = total;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" + "Id=" + Id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", orderDate=" + orderDate +
                ", count=" + count +
                ", total=" + total +
                ", price=" + price +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<Menu> getMenuList() {
        return global.menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.global.menuList = menuList;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
