package Kurs;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kurs> listaKursow = new ArrayList<>();

        while (true) {
            boolean znaleziono2 = false;
            boolean znaleziono3 = false;
            boolean znaleziono = false;
            System.out.println("1-dodaj kurs, 2-wyswietl kursy, 3-dodaj kursanta do kursu, 4-wyswietl kurs wraz z kursantami, " +
                    "5-usun kurs, 6-usun kursanta z kursu, 7-koniec, 8- przenies kursanta");

            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                System.out.println("Podaj nazwe kursu: ");
                String nazwa = scanner.nextLine();

                System.out.println("Podaj miasto kursu: ");
                String miasto = scanner.nextLine();

                Kurs kurs = new Kurs(nazwa, miasto);
                listaKursow.add(kurs);
                System.out.println("Dodano kurs");

            } else if (menu == 2) {
                for (Kurs x : listaKursow) {
                    System.out.println("Nazwa: " + x.nazwa + " Miasto: " + x.miasto);
                }
            } else if (menu == 3) {
                System.out.println("Podaj nazwe kursu");
                String nazwa = scanner.nextLine();
                for (Kurs x : listaKursow) {
                    if (x.nazwa.equals(nazwa)) {
                        znaleziono = true;
                        System.out.println("Podaj Imie: ");
                        String imie = scanner.nextLine();

                        System.out.println("Podaj nazwisko: ");
                        String nazwisko = scanner.nextLine();

                        System.out.println("Podaj email: ");
                        String email = scanner.nextLine();

                        Kursant kursant = new Kursant(imie, nazwisko, email);
                        x.listaKursantow.add(kursant);

                        System.out.println("Dodano kursanta " + imie + " do kursu " + x.nazwa);
                        break;

                    }

                }
                if (znaleziono == false) {
                    System.out.println("Nie znaleziono kursu");

                }
            } else if (menu == 4) {
                System.out.println("Podaj nazwe kursu: ");
                String nazwa = scanner.nextLine();

                for (Kurs x : listaKursow) {
                    if (x.nazwa.equals(nazwa)) {
                        znaleziono = true;
                        System.out.println("Nazwa: " + x.nazwa + " Miasto: " + x.miasto);
                        for (Kursant y : x.listaKursantow) {
                            System.out.println("Imie: " + y.imie + " Nazwisko: " + y.nazwisko + " Email: " + y.email);
                        }

                    }

                }
                if (znaleziono == false) {
                    System.out.println("Nie znaleziono kursu");

                }
            } else if (menu == 5) {
                System.out.println("Podaj nazwe kursu: ");
                String nazwa = scanner.nextLine();

                for (Kurs x : listaKursow) {
                    if (x.nazwa.equals(nazwa)) {
                        znaleziono = true;
                        if (x.listaKursantow.size() > 0) {
                            System.out.println("Nie mozna usunac kursu poniewaz sa dodani kursanci");
                            break;
                        } else {
                            listaKursow.remove(x);
                            System.out.println("Usunieto pomyślnie");
                            break;
                        }

                    }

                }
                if (znaleziono == false) {
                    System.out.println("Nie znaleziono kursu");

                }

            } else if (menu == 6) {
                System.out.println("Podaj nazwe kursu: ");
                String nazwa = scanner.nextLine();

                for (Kurs x : listaKursow) {
                    if (x.nazwa.equals(nazwa)) {
                        znaleziono = true;
                        System.out.println("Podaj Nazwisko: ");
                        String nazwisko = scanner.nextLine();
                        for (Kursant y : x.listaKursantow) {
                            if (y.nazwisko.equals(nazwisko)) {
                                x.listaKursantow.remove(y);
                                System.out.println("Usunieto pomyslnie");
                                znaleziono2 = true;
                                break;
                            }
                        }
                    }

                }
                if (znaleziono == false) {
                    System.out.println("Nie znaleziono kurs");
                    break;
                }
                if (znaleziono2 == false) {
                    System.out.println("Nie znaleziono kursanta");
                }

            } else if (menu == 7) {
                break;
            } else if (menu == 8) {
                System.out.println("Podaj nazwe obecnego kursu: ");
                String nazwa = scanner.nextLine();
                for (Kurs x : listaKursow) {
                    if (x.nazwa.equals(nazwa)) {
                        znaleziono = true;
                        System.out.println("Podaj nazwisko kursanta");
                        String nazwisko = scanner.nextLine();
                        for (Kursant y : x.listaKursantow) {
                            if (y.nazwisko.equals(nazwisko)) {
                                znaleziono2 = true;
                                System.out.println("Podaj nowy kurs: ");
                                String nazwa2 = scanner.nextLine();
                                for (Kurs z : listaKursow) {
                                    if (z.nazwa.equals(nazwa2)) {
                                        znaleziono3 = true;
                                        Kursant kursant = new Kursant(y.imie, y.nazwisko, y.email);
                                        z.listaKursantow.add(kursant);
                                        System.out.println("Przeniesiono kursanta " + y.imie + " do kursu " + z.nazwa);
                                        x.listaKursantow.remove(y);
                                        break;
                                    }
                                }
                            }
                            if (znaleziono3 == true) {
                                break;
                            }
                        }
                        if (znaleziono2 == false) {
                            System.out.println("Nie znaleziono kursanta " + nazwisko + " w kusie " + nazwa);
                        }
                    }

                }
                if (znaleziono == false) {
                    System.out.println("Nie znaleziono kursu " + nazwa);
                }

            }

        }

    }
}
