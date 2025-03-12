package View;

import Solution.CheckNumber;

public class switchcaseManager {
    private final switchcaseMenu switchcaseFood = new switchcaseMenu();
    private final switchcaseBill switchcaseBill = new switchcaseBill();
    private final CheckNumber cn = new CheckNumber();
    ViewMenu menu = new ViewMenu();
    VIewBill bill = new VIewBill();

    public void manager(int choice){
        switch (choice){
            case 1:
                while (true){
                    menu.Menu();
                    int choiceFood = cn.checkNumber();
                    if(choiceFood == 0){
                        break;
                    }
                    switchcaseFood.food(choiceFood);
                };
                break;
            case 2:
                while (true){
                    bill.Bill();
                    int choiceBill = cn.checkNumber();
                    if(choiceBill == 0){
                        break;
                    }
                    switchcaseBill.bill(choiceBill);
                };
                break;
            default:
                System.out.println("Don't exists the choice");
        }
    }
}
