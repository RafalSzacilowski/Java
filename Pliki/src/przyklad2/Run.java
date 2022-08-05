package przyklad2;


import java.io.IOException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws IOException {

        String sciezka = "C:\\Pliki\\src\\przyklad2\\J38.txt";
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();


        while (true) {

            System.out.println("1-dodaj, 2-pokaz, 3-usun, 4-zmien, 5-wyszukaj, 6-koniec");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                System.out.println("Podaj imie: ");
                String imie = scanner.nextLine();
                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                System.out.println("Podaj wyplata: ");
                String wyplata = scanner.nextLine();

                company.dodaj(sciezka, imie, nazwisko, wyplata);


            } else if (menu == 2) {
                company.pokaz(sciezka);

            } else if (menu == 3) {
                System.out.println("Podaj nazwisko:");
                String nazwisko = scanner.nextLine();
                company.usun(sciezka, nazwisko);

            } else if (menu == 4) {
                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                System.out.println("Podaj nowe imie: ");
                String noweImie = scanner.nextLine();
                System.out.println("Podaj nowe nazwisko: ");
                String noweNazwisko = scanner.nextLine();
                company.zmien(sciezka, nazwisko, noweImie, noweNazwisko);


            } else if (menu == 5) {
                System.out.println("Podaj fraze: ");
                String fraza = scanner.nextLine();
                company.wyszukaj(sciezka, fraza);

            } else if (menu == 6) {
                break;
            }

        }

    }
}
