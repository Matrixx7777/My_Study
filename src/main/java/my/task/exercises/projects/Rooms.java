package my.task.exercises.projects;

import java.util.Locale;
import java.util.Scanner;

public class Rooms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        System.out.println("[ SKLEP POKOJE I FARBY ] \nPodaj liczbe pokoi wieksza od 0");
        int numberRoom = sc.nextInt();

        System.out.println("Podaj cene za litr farby wieksza badz rowna 10");
        double pricePerPaint = sc.nextDouble();

        Rooms rooms = new Rooms();
        rooms.method(numberRoom, pricePerPaint);
    }

    public void method(int numberRoom, double pricePerPaint){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        double literOfPaint;
        double roomArea = 0;
        int workHours;
        double pricePerHour;
        double totalPaintCost;
        double totalMoney;

        if(numberRoom >= 0 && pricePerPaint >= 10){

            for(int i = 1; i <= numberRoom; i++){

                System.out.println("Podaj wysokosc w " + i + " pokoju w metrach");
                double high = sc.nextDouble();

                while(high <= 0){
                    System.out.println("ZLE! Podaj wysokosc wieksza niz 0 w " + i + " pokoju w metrach");
                    high = sc.nextDouble();
                }

                System.out.println("Podaj dlugosc w " + i + " pokoju w metrach");
                double length = sc.nextDouble();

                while(length <= 0) {
                    System.out.println("ZLE! Podaj dlugosc wieksza niz 0 w " + i + " pokoju w metrach");
                    length = sc.nextDouble();
                }

                System.out.println("Podaj szerokosc w " + i + " pokoju w metrach");
                double width = sc.nextDouble();

                while(width <= 0){
                    System.out.println("ZLE! Podaj szerokosc wieksza niz 0 w " + i + " pokoju w metrach");
                    width = sc.nextDouble();
                }

                roomArea = 2*(width*length+length*high+high*width);
            }

            System.out.print("\n------------------------------------------\n");
            System.out.println("Laczna liczba metrow kwadratowych pokoi wynosi ");
            System.out.format("%.2f%n", roomArea);

            literOfPaint = roomArea/15;

            System.out.print("\nWynik litrow farby wynosi ");
            System.out.format("%.2f%n",literOfPaint);

            workHours = (int)literOfPaint * 3;

            System.out.print("\nWynik godzin pracy wynosi " + workHours);

            totalPaintCost = literOfPaint * pricePerPaint;

            System.out.println("\nKoszt calkowity farby wynosi ");
            System.out.format("%.2f%n",totalPaintCost);

            pricePerHour = workHours * 25;

            System.out.print("\nOplata za calkowita prace wynosi ");
            System.out.format("%.2f%n",pricePerHour);

            totalMoney = totalPaintCost + pricePerHour;

            System.out.print("\nWszystkie koszty calkowitej pracy z oplata farby wynosza ");
            System.out.format("%.2f%n",totalMoney);
            System.out.println("\n------------------------------------------");
        }
        else {
            System.out.println("\nZla liczba. Pokoj musi byc wiekszy od zera\n" +
                    "i cena farby musi byc wieksza badz rowna 10\n" +
                    "\n***************** KONIEC *****************");
        }
    }
}