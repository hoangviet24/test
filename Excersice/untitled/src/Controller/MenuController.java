package Controller;
import Repository.MenuRepository;
public class MenuController  {
    private final MenuRepository menuRepository;
    public MenuController(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }
    public void add() {
        menuRepository.add();
    }
    public void view() {
        menuRepository.view();
    }
    public void delete() {
        menuRepository.delete();
    }
    public void update() {
        menuRepository.update();
    }
}
