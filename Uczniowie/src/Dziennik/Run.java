package Dziennik;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Uczen> listaUczniów = new ArrayList<>();


        while (true) {

            boolean znalazl = false;
            System.out.println("D-dodaj, P-pokaz, O-dodaj ocene uczniowi, W-wyswietl oceny ucznia, S- najwieksza srednia, K-koniec");
            String menu = scanner.nextLine().toUpperCase();

            if (menu.equals("D")) {
                System.out.println("Podaj imie: ");
                String imie = scanner.nextLine();
                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();

                Uczen uczen = new Uczen(imie, nazwisko);
                listaUczniów.add(uczen);

                System.out.println("Dodano ucznia pomyślnie");
            } else if (menu.equals("P")) {
                if (listaUczniów.size() > 0) {
                    for (Uczen x : listaUczniów) {
                        System.out.println("Imie: " + x.imie + " Nazwisko: " + x.nazwisko);
                    }
                } else {
                    System.out.println("Nie dodano zadnego ucznia.");
                }
            } else if (menu.equals("O")) {
                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                for (Uczen x : listaUczniów) {
                    if (x.nazwisko.equals(nazwisko)) {
                        System.out.println("Dodaj ocene: ");
                        int ocena = scanner.nextInt();
                        scanner.nextLine();
                        x.oceny.add(ocena);
                        znalazl = true;
                        System.out.println("Dodano ocene pomyślnie.");
                        break;
                    }

                }
                if (znalazl == false) {
                    System.out.println("Nie znaleziono ucznia");
                }

            } else if (menu.equals("W")) {
                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                for (Uczen x : listaUczniów) {
                    if (x.nazwisko.equals(nazwisko)) {
                        znalazl = true;
                        System.out.println(x.imie + " " + x.nazwisko);
                        System.out.print("Oceny: ");
                        if (x.oceny.size() > 0) {
                            for (int y : x.oceny) {
                                System.out.print(y + " ");
                            }
                            System.out.println();
                            break;
                        } else {
                            System.out.println("Brak ocen.");
                            break;
                        }
                    }
                }
                if (znalazl == false) {
                    System.out.println("Nie znaleziono ucznia");
                }
            } else if (menu.equals("K")) {
                break;
            } else if (menu.equals("S")) {

                double srednia = 0;
                String najlepszyUczen = " ";
                double najwieksza = 0;
                if (listaUczniów.size() > 0) {
                    for (Uczen x : listaUczniów) {
                        if (x.oceny.size() > 0) {
                            znalazl = true;
                            double sumaOcen = 0;
                            for (int y : x.oceny) {
                                sumaOcen += y;
                            }
                            srednia = sumaOcen / x.oceny.size();
                            if (srednia > najwieksza) {

                                najwieksza = srednia;
                                najlepszyUczen = x.imie + " " + x.nazwisko;
                            }
                        }else {
                            System.out.println("Uczniowie nie maja ocen");
                            continue;
                        }
                    }
                } else {
                    System.out.println("Nie ma uczniow");
                    continue;
                }
                if (znalazl == true) {
                    System.out.println("Uczeń z najlepsza srednia to: " + najlepszyUczen + " z srednia: " + najwieksza);
                }
            }
        }
    }
}
