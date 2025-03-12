package global;

import Model.Bill;
import Model.Menu;

import java.util.ArrayList;
import java.util.List;

public class Global {
    private static Global instance;
    public List<Menu> menuList ;
    public List<Bill> billList;
    public Global(){
        menuList = new ArrayList<>();
        billList = new ArrayList<>();
    }
    public static Global getInstance() {
        if (instance == null) {
            instance = new Global();
        }
        return instance;
    }
}
