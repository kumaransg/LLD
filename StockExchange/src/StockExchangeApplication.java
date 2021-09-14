import model.SellOrder;
import service.StockExchangeService;
import service.StockExchangeServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class StockExchangeApplication {
    public static void main(String[] args) {

        // inputs provide in the code,
        StockExchangeService service = new StockExchangeServiceImpl();
        ArrayList<SellOrder> list = new ArrayList<>();
//        getSellOrderFromFile(list);
        service.addSellOrder("#1","BAC",240.12,100, LocalTime.now());
        service.addSellOrder("#2","BAC",237.45,90, LocalTime.now());
        service.addSellOrder("#6","BAC",236.00,50, LocalTime.now());


        service.matchAndExecuteBuyOrder("#3","BAC",238.10,110,LocalTime.now());
        service.matchAndExecuteBuyOrder("#4","BAC",237.80 ,10,LocalTime.now());
        service.matchAndExecuteBuyOrder("#5","BAC",237.80 ,40,LocalTime.now());

    }

    private static void getSellOrderFromFile(ArrayList<SellOrder> list) throws FileNotFoundException {
        File ordersFile = new File("data.txt");
        Scanner scanner = new Scanner(ordersFile);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            String orderId = data[0];
            LocalTime time = LocalTime.parse(data[1]);
            String stock = data[2];
            String type = data[3];
            Double price = Double.parseDouble(data[4]);
            int quantity = Integer.parseInt(data[5]);
            if (type.equals("buy")) {
                // call the respective function
            }
            if (type.equals("sell")) {
                // call the respective function
            }
        }
    }
}
