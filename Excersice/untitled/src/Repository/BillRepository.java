package Repository;

import Interface.IBill;
import Model.Bill;
import Model.Menu;
import Solution.CheckNumber;
import Solution.FindId;
import file.FileManager;
import global.Global;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BillRepository extends Bill implements IBill {
    private final Global global = Global.getInstance();
    private final CheckNumber cn = new CheckNumber();
    private final FindId fd = new FindId();

    @Override
    public void add() {
        if(!global.menuList.isEmpty()){
            Bill bill = new Bill();
            for (Menu menu: global.menuList) {
                System.out.println(menu);
            }
            System.out.print("Enter the id: ");
            int id = cn.checkNumber();
            Menu menuItem = fd.findMenuID(id);
            if(menuItem != null){
                    bill.setId(NextId++);
                    String type = menuItem.getType();
                    String name = menuItem.getName();
                    int price = (int) menuItem.getPrice();
                    bill.setType(type);
                    bill.setPrice(price);
                    bill.setName(name);
                    System.out.print("Enter quantity: ");
                    int quantity = cn.checkNumber();
                    bill.setCount(quantity);
                    total = (price * quantity);
                    bill.setTotal(total);
                    global.billList.add(bill);
            }
            else {
                System.out.println("Cant find id "+id);
            }
        }
        else {
            System.out.println("Menu is Empty");
        }
    }

    @Override
    public void viewBill() {
        if(global.billList.isEmpty()){
            System.out.println("Bill is empty");
        }
        else{
            for (Bill bill : global.billList){
                System.out.println(bill.toString());
            }
        }
    }

    @Override
    public void delete() {
        if(global.billList.isEmpty()){
            System.out.println("Bill is empty");
        }
        else {
            viewBill();
            System.out.println("Enter the id to delete (0 to exti): ");
            int id = cn.checkNumber();
            if(id == 0){
                System.out.println("Back to bill");
                return;
            }
            Bill toRemove = fd.findBillID(id);
            if(toRemove != null){
                global.billList.remove(toRemove);
            }
            else {
                System.out.println("Cant find id "+id);
            }
        }
    }
    @Override
    public void save() {
        FileManager fm = new FileManager();
        if(global.billList.isEmpty()){
            System.out.println("📭 Bill is empty");
        }
        else {
            viewBill();
            System.out.println("Save bill");
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String fileName = "bill_"+timeStamp+".txt";
            fm.save(fileName, global.billList);
            global.billList.clear();
        }
    }
    public void load() {
        FileManager fm = new FileManager();
        System.out.println("\uD83D\uDCC3 Loading files...");

        // Lấy tất cả các file có tên bắt đầu bằng "bill_" và kết thúc bằng ".txt"
        File dir = new File("."); // Thư mục hiện tại
        File[] files = dir.listFiles((d, name) -> name.startsWith("bill_") && name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("😥 No bill files found!");
            return;
        }
        Arrays.sort(files, Comparator.comparingLong(File::lastModified));
        for (File file : files) {
            System.out.println("📋 Loading from file: " + file.getName());
            fm.load(file.getName(), global.billList);
            System.out.print("\n");
        }
        global.billList.clear();
        System.out.println("✅ All bills loaded successfully!");
        System.out.println("Enter to exit");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Exiting...");
    }
}
