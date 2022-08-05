package Kurs;

import java.util.ArrayList;

public class Kurs {
    String nazwa;
    String miasto;
    ArrayList<Kursant> listaKursantow = new ArrayList<>();

    public Kurs(String nazwa, String miasto) {
        this.nazwa = nazwa;
        this.miasto = miasto;
    }
}
