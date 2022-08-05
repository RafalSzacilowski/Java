package hr;

import java.util.Scanner;

public class Firma extends PracownikController {

    Scanner scanner = new Scanner(System.in);
    String nazwaFirmy;

    public Firma(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
        this.menu();
    }

    public void menu() {

        System.out.println("Witaj w fimie " + this.nazwaFirmy);

        while (true) {
            System.out.println("D-dodaj, P-pokaz, U-usun, Z-zmien, K-koniec");
            String menu = scanner.nextLine().toUpperCase();

            if (menu.equals("D")) {
                System.out.println("Podaj imie: ");
                String imie = scanner.nextLine();
                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                System.out.println("wybierz kontrakt dla pracownika: S/E");
                String kontrakt = scanner.nextLine().toUpperCase();
                if (kontrakt.equals("S")) {
                    this.dodajPracownika(imie, nazwisko);

                } else if (kontrakt.equals("E")) {
                    kontrakt = "etat";
                    System.out.println("Podaj pensje pracownika: ");
                    double pensja = scanner.nextDouble();
                    scanner.nextLine();

                    this.dodajPracownika(imie, nazwisko, kontrakt, pensja);
                } else {
                    System.out.println("Wybrano nieporawny kontrakt");
                }

            } else if (menu.equals("P")) {
                this.pokazPracownikow();


            } else if (menu.equals("U")) {

                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                this.usunPracownika(nazwisko, this.znajdz(nazwisko));


            } else if (menu.equals("Z")) {
                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                System.out.println("Podaj pensje: ");
                double pensja = scanner.nextDouble();
                scanner.nextLine();
                this.zmienPracownika(nazwisko, pensja, this.znajdz(nazwisko));

            } else if (menu.equals("K")) {
                break;
            }
        }
    }

}
