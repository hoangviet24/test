package Repository;

import Interface.IMenu;
import Model.Menu;
import Solution.CheckNumber;
import Solution.FindId;
import global.Global;

import java.util.Scanner;

public class MenuRepository extends Menu implements IMenu {
    private final Global global = Global.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final CheckNumber ck = new CheckNumber();
    private final FindId fd = new FindId();
    public void add() {
        Menu menu = new Menu();
        menu.setId(NextId++);
        System.out.print("Enter the type: ");
        String type = scanner.nextLine();
        menu.setType(type);
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        menu.setName(name);
        System.out.print("Enter the description: ");
        String des = scanner.nextLine();
        menu.setDes(des);
        System.out.print("Enter the the price: ");
        double price = ck.checkNumber();
        menu.setPrice(price);
        global.menuList.add(menu);
    }
    public void view() {
        if(global.menuList.isEmpty()){
            System.out.println("Menu is empty");
        }
        else{
            for (Menu menu: global.menuList){
                System.out.println(menu.toString());
            }
        }
    }
    public void delete() {
        view();
        if(!global.menuList.isEmpty()){
            System.out.print("Enter the id (0 to exit): ");
            int id = ck.checkNumber();
            if(id == 0){
                System.out.println("back to menu");
                return;
            }
            Menu toRemove = fd.findMenuID(id);
            if(toRemove!=null){
                global.menuList.remove(toRemove);
                System.out.println("Delete successfully");
            }
            else {
                System.out.println("Cannot find the Id object: "+id);
            }
        }
        else {
            System.out.println("back to menu");
        }
    }
    public void update() {
        view();
        if(!global.menuList.isEmpty()){
            System.out.print("Enter the id: ");
            int id = ck.checkNumber();
            Menu menu = fd.findMenuID(id);
            if(menu != null){
                System.out.print("Enter the type: ");
                String type = scanner.nextLine();
                menu.setType(type);
                System.out.print("Enter the name: ");
                String name = scanner.nextLine();
                menu.setName(name);
                System.out.print("Enter the description: ");
                String des = scanner.nextLine();
                menu.setDes(des);
                System.out.print("Enter the price: ");
                double price = ck.checkNumber();
                menu.setPrice(price);
            }
            else {
                System.out.println("Cannot find id: "+id);
            }
        }
        System.out.println("back to menu");
    }
    //Hàm để test
    public void add(String name, String des, double price) {
        Menu menu = new Menu();
        menu.setId(NextId++);
        menu.setName(name);
        menu.setDes(des);
        menu.setPrice(price);
        global.menuList.add(menu);
    }
    public void delete(int id){
        Menu toRemove = fd.findMenuID(id);
        if(toRemove!=null){
            global.menuList.remove(toRemove);
            System.out.println("Delete successfully");
        }
        else {
            System.out.println("Cannot find the Id object: "+id);
        }
    }
    public void update(int id, String name, String des, double price){
        Menu menu = fd.findMenuID(id);
        if(menu != null){
            menu.setName(name);
            menu.setDes(des);
            menu.setPrice(price);
        }
        else {
            System.out.println("Cannot find id: "+id);
        }
    }
}
