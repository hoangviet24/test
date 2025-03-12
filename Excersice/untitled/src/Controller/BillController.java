package Controller;
import Repository.BillRepository;
public class BillController  {
    private final BillRepository billRepository;
    public BillController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    public void add() {
        billRepository.add();
    }
    public void viewBill() {
       billRepository.viewBill();
    }

    public void delete() {
       billRepository.delete();
    }
    public void save() {
        billRepository.save();
    }

    public void load() {
       billRepository.load();
    }
}
