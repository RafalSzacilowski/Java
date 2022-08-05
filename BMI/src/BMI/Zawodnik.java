package BMI;

public class Zawodnik {
    String imie;
    double wzrost;
    double waga;

    public Zawodnik(String imie, double wzrost, double waga) {
        this.imie = imie;
        this.wzrost = wzrost;
        this.waga = waga;
    }
    public void bmi(){
        double bmi = this.waga / (Math.pow(this.wzrost, 2));
        System.out.println(this.imie + " bmi: " + bmi);
    }
}
