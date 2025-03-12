package View;

import Controller.MenuController;
import Repository.MenuRepository;

public class switchcaseMenu {
    private final MenuRepository menuRepository = new MenuRepository();
    private final MenuController menu = new MenuController(menuRepository);
    public void food(int choice){
        switch (choice){
            case 1:
                menu.view();break;
            case 2:
                menu.add();break;
            case 3:
                menu.delete();break;
            case 4:
                menu.update();break;
            default:
                System.out.println("Don't exists the choice");
        }
    }
}
