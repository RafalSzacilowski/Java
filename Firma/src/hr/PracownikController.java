package hr;

import java.util.ArrayList;

public class PracownikController {

    ArrayList<Pracownik> listaPracownikow = new ArrayList<>();

    public void dodajPracownika(String imie, String nazwisko) {

        Pracownik pracownik = new Pracownik(imie, nazwisko, "staż", 1000);
        this.listaPracownikow.add(pracownik);
        System.out.println("Pracownik zostal pomyslnie dodany!");
    }

    public void dodajPracownika(String imie, String nazwisko, String kontrakt, double pensja) {

        Pracownik pracownik = new Pracownik(imie, nazwisko, kontrakt, pensja);
        this.listaPracownikow.add(pracownik);
        System.out.println("Pracownik zostal pomyslnie dodany!");
    }

    public void pokazPracownikow() {
        for (Pracownik x : listaPracownikow) {
            System.out.println("Imie: " + x.getImie() + " Nazwisko: " + x.getNazwisko() + " Kontrakt: " + x.getKontrakt() + " Pensja: " + x.getPensja());
        }
    }

    public void usunPracownika(String nazwisko, boolean z) {

        if (z == false) {
            System.out.println("Nie ma pracownika");
        } else {
            for (Pracownik x : this.listaPracownikow) {
                if (x.getNazwisko().equals(nazwisko)) {
                    this.listaPracownikow.remove(x);
                    System.out.println("Usunieto pomyslnie!");
                    break;
                }
            }

        }
    }

    public void zmienPracownika(String nazwisko, double pensja, boolean z) {

        if (z == false) {
            System.out.println("Nie ma pracownika");
        } else {
            for (Pracownik x : this.listaPracownikow) {
                if (x.getNazwisko().equals(nazwisko)) {
                    x.setPensja(pensja);
                    if (x.getKontrakt().equals("staż")) {
                        x.setKontrakt("etat");
                    }
                    System.out.println("Zmieniono pomyslnie");
                }
            }
        }

    }

    public boolean znajdz(String nazwisko) {
        boolean znalaz = false;
        for (Pracownik x : listaPracownikow) {
            if (x.getNazwisko().equals(nazwisko)) {
                znalaz = true;
                break;
            }
        }
        return znalaz;
    }

    public Pracownik pracownik(String nazwisko){
        for(Pracownik x : listaPracownikow){
            if(x.getNazwisko().equals(nazwisko)){
                return x;
            }
        }
        System.out.println("Nie znaleziono pracownika");
        return null;
    }
}

