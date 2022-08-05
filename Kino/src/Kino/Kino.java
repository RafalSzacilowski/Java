package Kino;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Kino {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> kina = new ArrayList<>();
        kina.add("Cinema-City");
        kina.add("Multikino");

        String[][] filmy = new String[2][3];
        filmy[0][0] = "Matrix";
        filmy[0][1] = "Avatar";
        filmy[0][2] = "Shrek";
        filmy[1][0] = "Piraci z Karaibów";
        filmy[1][1] = "Król Lew";
        filmy[1][2] = "Władca Pierścieni";

        ArrayList<Character> dozwoloneZnaki = new ArrayList<>();
        dozwoloneZnaki.add('q');
        dozwoloneZnaki.add('w');
        dozwoloneZnaki.add('e');
        dozwoloneZnaki.add('r');
        dozwoloneZnaki.add('t');
        dozwoloneZnaki.add('y');
        dozwoloneZnaki.add('u');
        dozwoloneZnaki.add('i');
        dozwoloneZnaki.add('o');
        dozwoloneZnaki.add('p');
        dozwoloneZnaki.add('a');
        dozwoloneZnaki.add('s');
        dozwoloneZnaki.add('d');
        dozwoloneZnaki.add('f');
        dozwoloneZnaki.add('g');
        dozwoloneZnaki.add('h');
        dozwoloneZnaki.add('j');
        dozwoloneZnaki.add('k');
        dozwoloneZnaki.add('l');
        dozwoloneZnaki.add('z');
        dozwoloneZnaki.add('x');
        dozwoloneZnaki.add('c');
        dozwoloneZnaki.add('v');
        dozwoloneZnaki.add('b');
        dozwoloneZnaki.add('n');
        dozwoloneZnaki.add('m');

        double cenaBiletu = 18.00;

        int idKina;
        int idFilmu;
        int iloscOsob;
        String imie;

        while (true) {
            try {
                System.out.println("Lista Kin");
                System.out.println("-------------------------");
                for (int i = 0; i < kina.size(); i++) {
                    System.out.println("ID: " + i + " Kino: " + kina.get(i));
                }
                System.out.println("Podaj id Kina: ");
                idKina = scanner.nextInt();
                System.out.println("Wybrano kino " + kina.get(idKina));
                scanner.nextLine();
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Zły indeks kina");
                System.out.println();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Uzywaj liczb");
                System.out.println();
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Wybrałeś kino " + kina.get(idKina));
                System.out.println("Lista filmów dla kina : " + kina.get(idKina));
                System.out.println("---------------------------");
                for (int i = 0; i < 3; i++) {
                    System.out.println("ID: " + i + "Film: " + filmy[idKina][i]);
                }
                System.out.println("Podaj id filmu");
                idFilmu = scanner.nextInt();
                System.out.println("Wybrano film " + filmy[idKina][idFilmu]);
                scanner.nextLine();
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Zły indeks filmu");
                System.out.println();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Uzywaj liczb");
                System.out.println();
                scanner.nextLine();
            }
        }

        while (true) {
            try {

                System.out.println("Podaj ilosc osob: ");
                iloscOsob = scanner.nextInt();
                scanner.nextLine();
                if (iloscOsob > 0) {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Uzywaj liczb");
                System.out.println();
                scanner.nextLine();
            }
        }

        while (true) {
            boolean znalaz = false;
            System.out.println("Podaj Imie: ");
            imie = scanner.nextLine().toLowerCase();

            for (int i = 0; i < imie.length(); i++) {
                for (Character x : dozwoloneZnaki) {
                    if (imie.charAt(i) == x) {
                        znalaz = true;
                        break;
                    } else {
                        znalaz = false;
                    }
                }
                if (!znalaz) {
                    break;
                }
            }

            if (znalaz) {
                break;
            }

        }
        System.out.println("Podsumowanie: ");
        System.out.println("----------------------");
        System.out.println("Imie: " + imie.toUpperCase());
        System.out.println("Kino: " + kina.get(idKina));
        System.out.println("Film: " + filmy[idKina][idFilmu]);
        System.out.println("Liczba osób: " + iloscOsob);
        System.out.println("Koszt biletów:" + (cenaBiletu * iloscOsob));


    }

}
