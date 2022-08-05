package biblioteka;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotekaController extends Biblioteka {
    Scanner scanner = new Scanner(System.in);

    public BibliotekaController() {
        start();
    }

    public void start() {
        Ksiazka ksiazka1 = new Ksiazka("Adam Mickiewicz", "Pan Tadeusz");
        listaKsiazek.add(ksiazka1);
        Ksiazka ksiazka2 = new Ksiazka("Henryk Sienkiewicz", "Potop");
        listaKsiazek.add(ksiazka2);
        Ksiazka ksiazka3 = new Ksiazka("Boleslaw Prus", "Lalka");
        listaKsiazek.add(ksiazka3);
        Ksiazka ksiazka4 = new Ksiazka("J.K. Rowling", "Harry Potter i komnata tajemnic");
        listaKsiazek.add(ksiazka4);
        Ksiazka ksiazka5 = new Ksiazka("J.K. Rowling", "Harry Potter i kamien filozoficzny");
        listaKsiazek.add(ksiazka5);
        Ksiazka ksiazka6 = new Ksiazka("Andrzej Sapkowski", "Wiedzmin");
        listaKsiazek.add(ksiazka6);


        System.out.println("Podaj imie:");
        String imie = scanner.nextLine();
        System.out.println("Podaj Nazwisko: ");
        String nazwisko = scanner.nextLine();
        Osoba osoba = new Osoba(imie, nazwisko);
        System.out.println(osoba.getImie() + " witaj w naszej bibliotece!");

        while (true) {
            try {
                System.out.println("1 - Wypożycz ksiązkę , 2 - Zwroc ksiazke , 3 - Lista ksiazek niewypozyczonych , 4 - Lista ksiazek wypozyczonych , 5 - Koniec");
                int menu = scanner.nextInt();
                scanner.nextLine();

                if (menu == 1) {
                    System.out.println("Podaj tytuł ksiazki: ");
                    String tytul = scanner.nextLine().toUpperCase();
                    wypozyczKsiazke(tytul);

                } else if (menu == 2) {
                    System.out.println("Podaj tytuł ksiązki: ");
                    String tytul = scanner.nextLine().toUpperCase();
                    przyjmijZwrotKsiazki(tytul);

                } else if (menu == 3) {
                    listaKsiazekNieWypozyczonych();
                } else if (menu == 4) {
                    listaKsiazekWypozyczonych();
                } else if (menu == 5) {
                    System.out.println("Do zobaczenia!");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Nie wpisano liczby");
                scanner.nextLine();
            }
        }

    }
}
