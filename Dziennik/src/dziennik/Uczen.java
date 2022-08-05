package dziennik;

import java.util.ArrayList;

public class Uczen {
    private String imie;
    private String nazwisko;
    private ArrayList<Integer> oceny = new ArrayList<>();

    public Uczen(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void dodajOcene(int ocena){
        this.oceny.add(ocena);

    }

    public double sredniaOcen(){
        double srednia =0;
        int suma = 0;
       for(int x : this.oceny){
           suma += x;
       }
       srednia = suma / this.oceny.size();
       srednia *= 100;
       Math.round(srednia);
       srednia /= 100;
       return srednia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public ArrayList<Integer> getOceny() {
        return oceny;
    }

    @Override
    public String toString() {
        return "Imie: " + this.imie + " Nazwisko: " + this.nazwisko;
    }
}
