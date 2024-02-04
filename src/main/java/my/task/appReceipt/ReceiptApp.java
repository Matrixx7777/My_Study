package my.task.appReceipt;

import java.util.*;

public class ReceiptApp {

    private static final List<Receipt> receipts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a receipt");
            System.out.println("2. Generate a report");
            System.out.println("3. Finish");

            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    addReceipt(scanner);
                    break;
                case 2:
                    generateReport();
                    break;
                case 3:
                    System.out.println("End");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("The incorrect choice. Try again");
            }
        }
    }

    private static void addReceipt(Scanner scanner) {
        System.out.print("Receipt number: ");
        String number = scanner.next();

        System.out.print("Net worth: ");
        double net = scanner.nextDouble();

        System.out.print("VAT rate (%): ");
        double vat = scanner.nextDouble();

        Receipt paragon = new Receipt(number, net, vat);
        receipts.add(paragon);

        System.out.println("Added a receipt " + number);
    }

    private static void generateReport() {
        if (receipts.isEmpty()) {
            System.out.println("There is a lack of receipts. Add receipts before generating the report.");
            return;
        }

        double netSum = 0;
        Map<Double, Double> sumaVat = new HashMap<>();

        for (Receipt receipt : receipts) {
            netSum += receipt.getNetWorth();

            double vatValue = receipt.getNetWorth() * (receipt.getVATrate() / 100);
            sumaVat.put(receipt.getVATrate(), sumaVat.getOrDefault(receipt.getVATrate(), 0.0) + vatValue);
        }

        System.out.printf("Report:" + "\nNet worth: %.2f\n", netSum);
        System.out.println("\nBreakdown of VAT:");

        for (Map.Entry<Double, Double> entry : sumaVat.entrySet()) {
            System.out.printf("- Rate %.0f%%: %.2f\n", entry.getKey(), entry.getValue());
        }

        System.out.printf("\nGross value: %.2f\n", netSum + sumaVat.values().stream().mapToDouble(Double::doubleValue).sum());
    }
}