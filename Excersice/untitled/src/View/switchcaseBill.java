package View;

import Controller.BillController;
import Repository.BillRepository;

public class switchcaseBill {
    BillRepository billRepository = new BillRepository();
    private final BillController bill = new BillController(billRepository);

    public void bill(int choice) {
        switch (choice) {
            case 1:
                bill.viewBill();
                break;
            case 2:
                bill.add();
                break;
            case 3:
                bill.delete();
                break;
            case 4:
                bill.save();
                break;
            case 5:
                bill.load();break;
            default:
                System.out.println("Don't exists the choice");
        }
    }
}
