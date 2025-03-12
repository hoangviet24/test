package View;
import Solution.CheckNumber;

public class SwitchCaseMain {
    CheckNumber cn = new CheckNumber();
    ViewManager manager = new ViewManager();
    switchcaseManager switchcaseManager = new switchcaseManager();
    public void switchcase() {
        while (true) {
            manager.Manager();
            int choice = cn.checkNumber();
            if (choice == 0) {
                System.out.println("Programing is shutdown");
                break;
            }
            switchcaseManager.manager(choice);
        }
    }

}
