package Solution;

import java.util.Scanner;

public class CheckNumber {
    Scanner sc = new Scanner(System.in);
    public int checkNumber() {
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                sc.nextLine();  // Xóa dòng thừa
                return number;
            }
            System.out.println("The number is invalid. Please try again.");
            sc.nextLine();  // Xóa dữ liệu sai
        }
    }
}

