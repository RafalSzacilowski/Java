package hr;

public class Pracownik {
    private String imie;
    private String nazwisko;
    private String kontrakt;
    private double pensja;

    public Pracownik(String imie, String nazwisko, String kontrakt, double pensja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kontrakt = kontrakt;
        this.pensja = pensja;
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

    public String getKontrakt() {
        return this.kontrakt;
    }

    public void setKontrakt(String kontrakt) {
        this.kontrakt = kontrakt;
    }

    public double getPensja() {
        return this.pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + this.imie + '\'' +
                ", nazwisko='" + this.nazwisko + '\'' +
                ", kontrakt='" + this.kontrakt + '\'' +
                ", pensja=" + this.pensja +
                '}';
    }
}
