package Solution;

import Model.Bill;
import Model.Menu;
import global.Global;

import java.util.ArrayList;
import java.util.List;

public class FindId {
    private final Global global = Global.getInstance();
    public Menu findMenuID(int id){
        for(Menu menu: global.menuList){
            if(menu.getId()==id){
                return menu;
            }
        }
        return null;
    }
    public Bill findBillID(int id){
        for(Bill bill: global.billList){
            if(bill.getId()==id){
                return bill;
            }
        }
        return null;
    }
}
