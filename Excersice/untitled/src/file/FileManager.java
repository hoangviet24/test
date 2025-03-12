package file;

import Model.Bill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileManager {
    public void save(String fileName, List<Bill> billList) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        try (FileWriter fileWriter = new FileWriter(fileName,true)) {
            for (Bill bill : billList) {
                fileWriter.write("["+bill.getId() + ", "
                        + bill.getType()+", "
                        + bill.getName() + ", "
                        + bill.getOrderDate().format(dateTimeFormatter) + ", "
                        + bill.getCount() + ", "
                        + bill.getTotal() + ", "
                        + bill.getPrice() +"]"
                        + "\n");
            }
            System.out.println("Bills saved to TXT file!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(String fileName, List<Bill> billList) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("[","").replace("]","").trim();
                String[] data = line.split(",");
                if (data.length == 7) {
                    int id = Integer.parseInt(data[0].trim());
                    String itemName = data[1].trim();
                    String type = data[2].trim();
                    LocalDateTime dateTime = LocalDateTime.parse(data[3].trim(), dateTimeFormatter);
                    int quantity = Integer.parseInt(data[4].trim());
                    int total = Integer.parseInt(data[5].trim());
                    int price = Integer.parseInt(data[6].trim());
                    Bill bill = new Bill(id, type,itemName, dateTime, quantity, total, price);
                    billList.add(bill);
                    System.out.println("Load successfully: " + bill);
                }
                else {
                    System.out.println("Invalid data: " + line);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
