package FormularzBL;

import java.util.ArrayList;

public class Rezerwacja {
    String imie;
    String nazwisko;
    String wylotZ;
    String przylotDo;
    String miejsceVIP;
    String uwagi;
    ArrayList<String> listaPosilkow = new ArrayList<>();

    public Rezerwacja(String imie, String nazwisko, String wylotZ, String przylotDo, String miejsceVIP, String uwagi, ArrayList<String> listaPosilkow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wylotZ = wylotZ;
        this.przylotDo = przylotDo;
        this.miejsceVIP = miejsceVIP;
        this.uwagi = uwagi;
        this.listaPosilkow = listaPosilkow;
    }



}
