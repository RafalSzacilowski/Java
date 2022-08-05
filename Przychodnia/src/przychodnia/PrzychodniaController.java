package przychodnia;

import java.util.ArrayList;
import java.util.HashMap;

public class PrzychodniaController {

    HashMap<Przychodnia, ArrayList<Pacjent>> listaPrzychodni = new HashMap();
    ArrayList<Pacjent> listaPacjentow = new ArrayList<>();

    public void dodajPrzychodnie(String nazwa, String miasto) {
        Przychodnia przychodnia = new Przychodnia(nazwa, miasto);
        this.listaPrzychodni.put(przychodnia, null);
        System.out.println("Dodano pomyslnie.");
    }

    public void dodajPacjenta(String nazwa, String imie, String nazwisko) {
        if (znajdzPrzychodnie(nazwa) != null) {
            Pacjent pacjent = new Pacjent(imie, nazwisko);
            this.listaPacjentow.add(pacjent);
            this.listaPrzychodni.put(znajdzPrzychodnie(nazwa), this.listaPacjentow);
            System.out.println("Dodano pacjenta.");
        } else {
            System.out.println("Nie znaleziono przychodni: " + nazwa);
        }
    }

    public void listaPrzychodni() {

        for (Przychodnia x : this.listaPrzychodni.keySet()) {
            System.out.println("Przychodnia: " + x.getNazwa() + " Miasto: " + x.getMiasto());
        }
    }

    public void listaPacjentow(String nazwa) {
        if (znajdzPrzychodnie(nazwa) != null) {
            if (this.listaPrzychodni.get(znajdzPrzychodnie(nazwa)) != null) {
                for (Pacjent x : this.listaPrzychodni.get(znajdzPrzychodnie(nazwa))) {
                    System.out.println(x);
                }
            } else {
                System.out.println("Nie ma pacjentow");
            }

        } else {
            System.out.println("Nie znaleziono przychodni");
        }
    }

    public void dodajChorobe(String nazwa, String nazwisko, String choroba) {
        if (znajdzPrzychodnie(nazwa) != null) {
            if (znajdzPacjenta(nazwisko) != null) {
                znajdzPacjenta(nazwisko).choroby.add(choroba);
                System.out.println("Dodano chorobe");
            } else {
                System.out.println("Nie znaleziono pacjenta: " + nazwisko);
            }
        }else {
            System.out.println("Nie znaleziono przychodni");
        }

    }


    public void listaChorob(String nazwa, String nazwisko) {
        if (znajdzPrzychodnie(nazwa) != null) {
            if (znajdzPacjenta(nazwisko) != null) {
                System.out.println("Pacjent: " + znajdzPacjenta(nazwisko) + "Lista chorob: ");
                for (String x : znajdzPacjenta(nazwisko).choroby) {
                    System.out.print(x + " ");
                }
            } else {
                System.out.println("Nie naleziono Pacjenta.");
            }

            System.out.println();
        } else {
            System.out.println("Nie znaleziono przychodni");
        }
    }

    public Przychodnia znajdzPrzychodnie(String nazwa) {
        for (Przychodnia x : this.listaPrzychodni.keySet()) {
            if (x.getNazwa().equals(nazwa)) {
                return x;
            }
        }
        return null;
    }

    public Pacjent znajdzPacjenta(String nazwisko) {
        for (Pacjent x : this.listaPacjentow) {
            if (x.getNazwisko().equals(nazwisko)) {
                return x;
            }
        }
        return null;
    }
}
