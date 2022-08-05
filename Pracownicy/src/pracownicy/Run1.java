package pracownicy;

import java.util.ArrayList;
import java.util.Scanner;

public class Run1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> listaPracownikow = new ArrayList<Employee>();

        while (true) {
            boolean nazwa = false;
            System.out.println("D-dodaj, P-pokaz, U-usun, Z-zmien, K-koniec");
            String menu = scanner.nextLine().toUpperCase();

            if (menu.equals("D")) {

                System.out.println("Podaj imie: ");
                String imie = scanner.nextLine();

                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();

                System.out.println("Podaj telefon: ");
                int telefon = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Podaj email: ");
                String email = scanner.nextLine();

                Employee pracownik = new Employee(imie , nazwisko , email ,telefon);

                listaPracownikow.add(pracownik);

                System.out.println("Pracownik dodany pomyslnie");

            } else if (menu.equals("P")) {
                for(Employee x : listaPracownikow){
                    System.out.println("Imie: " + x.imie + " Nazwisko: " + x.nazwisko + " Telefon: " + x.numerTel + " email: " + x.email);
                }
            } else if (menu.equals("U")) {
                System.out.println("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                for(Employee x : listaPracownikow) {
                    if (x.nazwisko.equals(nazwisko)) {
                        listaPracownikow.remove(x);
                        System.out.println("Usunieto pomyslnie");
                        nazwa = true;
                        break;
                    }
                }
                if(nazwa == false){
                    System.out.println("Nie znaleziono");
                }

            } else if (menu.equals("Z")) {
                System.out.println("Podaj nazwisko: ");
                String nazwisko1 = scanner.nextLine();
                for(Employee x : listaPracownikow) {
                    if(x.nazwisko.equals(nazwisko1)){
                        System.out.println("Podaj nowe imie: ");
                        String imie = scanner.nextLine();

                        System.out.println("Podaj nowe nazwisko: ");
                        String nazwisko = scanner.nextLine();

                        System.out.println("Podaj nowy telefon: ");
                        int telefon = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Podaj nowy email: ");
                        String email = scanner.nextLine();

                        x.imie = imie;
                        x.nazwisko = nazwisko;
                        x.numerTel = telefon;
                        x.email = email;

                        System.out.println("Zmieniono pomyślnie");
                        nazwa = true;
                        break;
                    }
                }
                if(nazwa == false){
                    System.out.println("Nie znaleziono");
                }
            }else if(menu.equals("K")){
                break;
            }
            else{
                System.out.println("Nierozpoznana opcja menu");
            }
        }
    }
}
