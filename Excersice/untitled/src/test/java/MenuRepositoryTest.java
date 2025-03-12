package test.java;

import Repository.MenuRepository;
import global.Global;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {
    MenuRepository menuRepository;
    Global global;
    @BeforeEach
    void setUp() {
        menuRepository = new MenuRepository();
        global = Global.getInstance();
        global.menuList.clear();
    }
    @Test
    void TestAdd() {
        String name = "Gà";
        String des = "Gà rán";
        double price = 10000;
        menuRepository.add(name, des, price);
        assertEquals(1, global.menuList.size());
        assertEquals(name, global.menuList.get(0).getName());
        assertEquals(des, global.menuList.get(0).getDes());
        assertEquals(price, global.menuList.get(0).getPrice());
    }
    @Test
    void testDel(){
        String name = "Gà";
        String des = "Gà rán";
        double price = 10000;
        menuRepository.add(name, des, price);
        int id = 1;
        menuRepository.delete(id);
        assertTrue(global.menuList.isEmpty());
    }
    @Test
    void testUpdate(){
        String name = "Gà";
        String des = "Gà rán";
        double price = 10000;
        menuRepository.add(name, des, price);
        String newName = "Bò";
        String newDes = "Bò nướng";
        double newPrice = 20000;
        menuRepository.update(1, newName, newDes, newPrice);
        assertEquals(newName, global.menuList.get(0).getName());
        assertEquals(newDes, global.menuList.get(0).getDes());
        assertEquals(newPrice, global.menuList.get(0).getPrice());
    }
}