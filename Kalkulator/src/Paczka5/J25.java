package Paczka5;

import java.util.Scanner;

public class J25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kalkulator kalkulator = new Kalkulator();

        double wynik = 0;

        System.out.println("Podaj pierwsza liczbe: ");
        double liczba1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj znak dzialania: ");
        String znak = scanner.nextLine();

        System.out.println("Podaj druga liczbe: ");
        double liczba2 = scanner.nextDouble();
        scanner.nextLine();

        
        if(znak.equals("+")){
            wynik = kalkulator.suma(liczba1, liczba2);
        }else if(znak.equals("-")){
            wynik = kalkulator.roznica(liczba1, liczba2);
        }else if(znak.equals("*")){
            wynik = kalkulator.iloczyn(liczba1, liczba2);
        }else if(znak.equals("/")){
            wynik = kalkulator.iloraz(liczba1, liczba2);
        }

        System.out.println(wynik);

    }
}
