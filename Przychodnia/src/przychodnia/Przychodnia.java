package przychodnia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Przychodnia extends PrzychodniaController {
    Scanner scanner = new Scanner(System.in);
    String nazwa;
    String miasto;

    public Przychodnia() {
        start();
    }

    public Przychodnia(String nawzwa, String miasto) {
        this.nazwa = nawzwa;
        this.miasto = miasto;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nawzwa) {
        this.nazwa = nawzwa;
    }

    public String getMiasto() {
        return this.miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void start() {


        while (true) {
            try {
                System.out.println("1 - Przychodnia  |  2 - Pacjent  |  3 - Koniec");
                int menu = scanner.nextInt();
                scanner.nextLine();

                if (menu == 1) {
                        System.out.println("1 - Dodaj przychodnie  |  2 - Dodaj pacjenta  |  3 - Lista przychodni  |  4 - Lista Pacjentow w przychodni");
                        menu = scanner.nextInt();
                        scanner.nextLine();
                        if (menu == 1) {
                            System.out.println("Podaj nazwe przychodni: ");
                            String nazwa = scanner.nextLine();
                            System.out.println("Podaj miasto przychodni: ");
                            String miasto = scanner.nextLine();
                            dodajPrzychodnie(nazwa, miasto);

                        } else if (menu == 2) {
                            System.out.println("Podaj przychodnie: ");
                            String nazwa = scanner.nextLine();
                            System.out.println("Podaj Imie: ");
                            String imie = scanner.nextLine();
                            System.out.println("Podaj Nazwisko: ");
                            String nazwisko = scanner.nextLine();

                            dodajPacjenta(nazwa, imie, nazwisko);

                        } else if (menu == 3) {
                            listaPrzychodni();

                        } else if (menu == 4) {
                            System.out.println("Podaj przychodnie");
                            String nazwa = scanner.nextLine();
                            listaPacjentow(nazwa);
                        }


                } else if (menu == 2) {
                    System.out.println("1 - Dodaj chorobę  |  2 - Lista chorob");
                    menu = scanner.nextInt();
                    scanner.nextLine();
                    if (menu == 1) {
                        System.out.println("Podaj Przychodnie: ");
                        String nazwa = scanner.nextLine();
                        System.out.println("Podaj nazwisko: ");
                        String nazwisko = scanner.nextLine();
                        System.out.println("Podaj chorobe: ");
                        String choroba = scanner.nextLine();

                        dodajChorobe(nazwa, nazwisko, choroba);

                    } else if (menu == 2) {
                        System.out.println("Podaj przychodnie: ");
                        String nazwa = scanner.nextLine();
                        System.out.println("Podaj nazwisko: ");
                        String nazwisko = scanner.nextLine();
                        listaChorob(nazwa, nazwisko);
                    }


                } else if (menu == 3) {
                    break;
                }


            }catch (InputMismatchException e){
                System.out.println("Podaj liczbe");
                scanner.nextLine();
            }
        }
    }
}





