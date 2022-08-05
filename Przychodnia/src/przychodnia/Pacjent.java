package przychodnia;

import java.util.ArrayList;

public class Pacjent {
    private String imie;
    private String nazwisko;
    ArrayList<String> choroby = new ArrayList<>();


    public Pacjent(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return this.imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return this.imie + " " + this.nazwisko + " " ;
    }
}
