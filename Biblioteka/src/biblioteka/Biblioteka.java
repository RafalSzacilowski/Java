package biblioteka;

import java.util.ArrayList;

public class Biblioteka implements Dzialania {
    ArrayList<Ksiazka> listaKsiazek = new ArrayList<>();
    ArrayList<Ksiazka> listaKsiazekWypozyczonych = new ArrayList<>();

    @Override
    public void wypozyczKsiazke(String tytul) {
        boolean znalaz = false;
        for (Ksiazka x : listaKsiazek) {
            if (x.tytul.toUpperCase().equals(tytul)) {
                znalaz = true;
                listaKsiazekWypozyczonych.add(x);
                listaKsiazek.remove(x);
                System.out.println("Wypozyczono: " + x.autor + " " + x.tytul);
                break;
            }
        }
        if (znalaz == false) {
            System.out.println("W naszej bibliotece nie ma ksiazki o tytule: " + tytul);
        }
    }

    @Override
    public void przyjmijZwrotKsiazki(String tytul) {
        boolean znalaz = false;
        for (Ksiazka x : listaKsiazekWypozyczonych) {
            if (x.tytul.toUpperCase().equals(tytul)) {
                znalaz = true;
                listaKsiazek.add(x);
                listaKsiazekWypozyczonych.remove(x);
                System.out.println("Oddano: " + x.autor + " " + x.tytul);
                break;
            }
        }
        if (znalaz == false) {
            System.out.println("Nie wypozyczałeś: " + tytul);
        }
    }

    @Override
    public void listaKsiazekWypozyczonych() {
        for (Ksiazka x : this.listaKsiazekWypozyczonych) {
            System.out.println(x.autor + " " + x.tytul);
        }
    }

    @Override
    public void listaKsiazekNieWypozyczonych() {
        for (Ksiazka x : this.listaKsiazek) {
            System.out.println(x.autor + " " + x.tytul);
        }
    }
}
