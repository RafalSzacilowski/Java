package KsiazkaTel;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        while (true) {

            System.out.println("1-dodaj, 2-przegladaj, 3-usun, 4-zmien, 5*-wyszukaj, 6-koniec");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                try {
                    System.out.println("Podaj imie:");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko:");
                    String naziwsko = scanner.nextLine();
                    System.out.println("Podaj telefon:");
                    int telefon = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Podaj email:");
                    String email = scanner.nextLine();

                    controller.dodaj(imie, naziwsko, telefon, email);
                } catch (InputMismatchException e) {
                    System.out.println("Tylko numery");
                }

            } else if (menu == 2) {

                controller.pokaz();

            } else if (menu == 3) {

                System.out.println("Podaj nazwisko do usunięcia: ");
                String nazwisko = scanner.nextLine();

                controller.usun(nazwisko);
            } else if (menu == 4) {
                try {


                    System.out.println("Podaj nazwisko do zmiany");
                    String nazwisko = scanner.nextLine();
                    System.out.println("Podaj nowe imię: ");
                    String noweImie = scanner.nextLine();
                    System.out.println("Podaj nowe nazwisko: ");
                    String noweNazwisko = scanner.nextLine();
                    System.out.println("Podaj nowy telefon: ");
                    int nowyTelefon = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Podaj nowy email: ");
                    String nowyEmail = scanner.nextLine();

                    controller.zmien(nazwisko, noweImie, noweNazwisko, nowyTelefon, nowyEmail);
                } catch (InputMismatchException e) {
                    System.out.println("Tylko numery");
                }

            } else if (menu == 5) {
                try {
                    System.out.println("Wyszukaj: ");
                    String fraza = scanner.nextLine();
                    controller.wyszukaj(fraza);


                }catch (InputMismatchException e) {
                    System.out.println("Tylko numery");
                }
            } else if (menu == 6) {
                break;
            }

        }


    }
}
