package dziennik;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        ArrayList<Uczen> listaUczniow = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            boolean znalaz = false;

            System.out.println("Wybierz opcję menu: D-dodaj ucznia, P-pokaz uczniow wraz z ocenami, O - dodaj ocene uczniowi, U - usun ucznia, " +
                    "M - modyfikuj ucznia, K - koniec");
            String dec = scanner.nextLine().toUpperCase();

            if (dec.equals("D")) {

                System.out.println("Podaj Imie:");
                String imie = scanner.nextLine();

                System.out.println("Podaj Nazwisko: ");
                String nazwisko = scanner.nextLine();

                Uczen uczen = new Uczen(imie, nazwisko);
                listaUczniow.add(uczen);
                System.out.println("Dodano pomyslnie");

            } else if (dec.equals("P")) {

                for (Uczen x : listaUczniow) {
                    System.out.println(x);

                    if (x.getOceny().size() > 0) {
                        System.out.println("Oceny: " + x.getOceny());
                        System.out.println("Srednia: " + x.sredniaOcen());
                    }
                }


            } else if (dec.equals("O")) {
                System.out.println("Podaj nazwisko ucznia: ");
                String nazwisko = scanner.nextLine();
                for (Uczen x : listaUczniow) {
                    if (x.getNazwisko().equals(nazwisko)) {
                        znalaz = true;
                        System.out.println("Podaj ocene: ");
                        int ocena = scanner.nextInt();
                        scanner.nextLine();
                        x.dodajOcene(ocena);
                        System.out.println("Dodano ocene");
                        break;
                    }
                }
                if (znalaz == false) {
                    System.out.println("Nie znaleziono ucznia");
                }

            } else if (dec.equals("U")) {
                System.out.println("Podaj nazwisko ucznia: ");
                String nazwisko = scanner.nextLine();
                for (Uczen x : listaUczniow) {
                    if (x.getNazwisko().equals(nazwisko)) {
                        znalaz = true;
                        listaUczniow.remove(x);
                        System.out.println("Usunieto pomyslnie");
                        break;
                    }
                }
                if (znalaz == false) {
                    System.out.println("Nie znaleziono ucznia");
                }


            } else if (dec.equals("M")) {
                System.out.println("Podaj nazwisko ucznia: ");
                String nazwisko = scanner.nextLine();
                String noweImie;
                String noweNazwisko;
                for (Uczen x : listaUczniow) {
                    if (x.getNazwisko().equals(nazwisko)) {
                        znalaz = true;
                        System.out.println("podaj nowe imie:");
                        noweImie = scanner.nextLine();

                        System.out.println("Podaj nowe nazwisko");
                        noweNazwisko = scanner.nextLine();

                        x.setImie(noweImie);
                        x.setNazwisko(noweNazwisko);

                        System.out.println("Zmodyfikowano pomyslnie");
                        break;
                    }
                    if (znalaz == true) {
                        break;
                    }
                }
                if (znalaz == false) {
                    System.out.println("Nie znaleziono ucznia");
                }


            } else if (dec.equals("K")) {
                System.out.println("Koniec działania programu");
                break;
            } else {
                System.out.println("Nierozpoznana opcja menu");
            }
        }
    }
}
