package Dziennik;

import java.util.ArrayList;

public class Uczen {
    String imie;
    String nazwisko;
    ArrayList<Integer> oceny = new ArrayList<>();

    public Uczen(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
}
