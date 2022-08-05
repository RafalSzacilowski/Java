package bank;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("W ktorym banku tworzymy konto: ");
        System.out.println("1 - Bank PKO 5%");
        System.out.println("2 - Bank Alior Bank 3%");
        int menu = scanner.nextInt();
        scanner.nextLine();
        KontoBankowe konto = null;

        if (menu == 1) {
            konto = new BankPKO();

        } else if (menu == 2) {

            konto = new BankAliorBank();

        }
        System.out.println("Podaj numer konta:");
        konto.nrKonta = scanner.nextLine();

        System.out.println("Podaj saldo poczatkowe:");
        konto.saldo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(konto);

        System.out.println("Podaj kwote do wplaty: ");
        konto.addSaldo(scanner.nextDouble());
        scanner.nextLine();
        System.out.println(konto);


        System.out.println("Podaj debet:");
        konto.maxDebit = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(konto);


        System.out.println("Podaj kwote do wyplaty:");
        konto.subSaldo(scanner.nextDouble());
        scanner.nextLine();
        System.out.println(konto);
        konto.interest();
        System.out.println(konto);

        System.out.println("Na koncie zostalo: " + konto.saldo);

    }
}
