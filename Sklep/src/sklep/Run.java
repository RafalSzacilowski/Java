package sklep;

import java.util.HashMap;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> sklep = new HashMap<>();
        sklep.put("woda", 2.52);
        sklep.put("sok", 1.55);
        sklep.put("chleb", 3.55);
        sklep.put("cola", 4.55);

        Koszyk koszyk = new Koszyk();

        System.out.println("Witaj w sklepie ABC");

        while (true) {
            System.out.println("1 - dodaj produkt, 2 - pokaz zawartosc koszyka , 3 - usun produkt, 4 - kasa/koniec");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                System.out.println("Podaj nazwe produktu");
                String produkt = scanner.nextLine();
                if (sklep.containsKey(produkt)) {
                    System.out.println("Podaj ilosc " + produkt + ": ");
                    int ilosc = scanner.nextInt();
                    scanner.nextLine();
                    koszyk.dodajProdukt(produkt, ilosc);
                } else {
                    System.out.println("Nie ma takiego produktu");
                }

            } else if (menu == 2) {
                for (String x : koszyk.zakupy.keySet()) {
                    System.out.println("Produkt: " + x + " Ilość: " + koszyk.zakupy.get(x));
                }

            } else if (menu == 3) {
                System.out.println("Podaj nazwe produktu ktory chesz usunąć");
                String nazwa = scanner.nextLine();
                if (koszyk.zakupy.containsKey(nazwa)) {
                    System.out.println("Podaj ilosc do usuniecia: ");
                    int iloscUs = scanner.nextInt();
                    koszyk.usunProdukt(nazwa, iloscUs);
                } else {
                    System.out.println("Nie masz takiego produktu w koszyku");
                }
            } else if (menu == 4) {
                double doZaplaty = 0;
                System.out.println("PARAGON:");
                for (String x : koszyk.zakupy.keySet()) {
                    double wartosc = koszyk.zakupy.get(x) * sklep.get(x);
                    wartosc *= 100;
                    wartosc = Math.round(wartosc);
                    wartosc /= 100;
                    doZaplaty = doZaplaty + wartosc;
                    System.out.println("Produkt: " + x + " Ilosc: " + koszyk.zakupy.get(x) + " Cena: " + sklep.get(x) + " Wartosc: " + wartosc + " PLN");
                }
                System.out.println("RAZEM DO ZAPLATY: " + doZaplaty + " PLN");
                break;
            }
        }
    }
}

