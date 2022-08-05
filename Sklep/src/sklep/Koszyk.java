package sklep;

import java.util.HashMap;

public class Koszyk {
    HashMap<String , Integer> zakupy = new HashMap<>();

    public Koszyk() {
    }

    public void dodajProdukt(String nazwa, int ilosc){
        if(this.zakupy.containsKey(nazwa)) {

            int nowaIlosc = this.zakupy.get(nazwa) + ilosc;
            this.zakupy.put(nazwa ,nowaIlosc);
        }else {
            this.zakupy.put(nazwa, ilosc);
        }
    }

    public void usunProdukt(String nazwa, int iloscUsun) {
        if (this.zakupy.containsKey(nazwa)) {
            if (this.zakupy.get(nazwa) > iloscUsun) {
                int nowaIlosc = this.zakupy.get(nazwa) - iloscUsun;
                this.zakupy.put(nazwa, nowaIlosc);
            } else if (this.zakupy.get(nazwa) == iloscUsun) {
                this.zakupy.remove(nazwa);
            } else if (this.zakupy.get(nazwa) < iloscUsun) {
                System.out.println("Nie mozna usunac " + iloscUsun + " poniewaz w koszyku sa: " + this.zakupy.get(nazwa));
            }
        }else {
            System.out.println("Koszyk jest pusty");
        }
    }
}
