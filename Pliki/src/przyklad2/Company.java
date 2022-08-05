package przyklad2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Company {
    public void dodaj(String sciezka, String imie, String nazwisko, String wyplata) throws IOException {
        FileWriter fileWriter = new FileWriter(sciezka, true);
        fileWriter.append(imie + ";");
        fileWriter.append(nazwisko + ";");
        fileWriter.append(wyplata + "\n");

        fileWriter.close();

    }

    public void pokaz(String sciezka) throws FileNotFoundException {
        File file = new File(sciezka);
        Scanner scannerFile = new Scanner(file);

        while (scannerFile.hasNextLine()) {
            String wiersz = scannerFile.nextLine();
            String[] wierszTab = wiersz.split(";");
            System.out.println("Imie: " + wierszTab[0] + " Nazwisko: " + wierszTab[1] + " Wyplata: " + wierszTab[2]);
        }
        scannerFile.close();

    }

    public void usun(String sciezka, String nazwisko) throws IOException {
        ArrayList<String> lista = new ArrayList<>();

        File file = new File(sciezka);
        Scanner scannerFile = new Scanner(file);

        while (scannerFile.hasNextLine()) {
            String wiersz = scannerFile.nextLine();
            String[] wierszTab = wiersz.split(";");
            if (!wierszTab[1].equals(nazwisko)) {
                lista.add(wiersz);
            }
        }
        scannerFile.close();

        FileWriter fileWriter = new FileWriter(sciezka, false);
        for (String x : lista) {
            fileWriter.append(x + "\n");
        }
        fileWriter.close();


    }

    public void zmien(String sciezka, String nazwisko, String noweImie, String noweNazwisko) throws IOException {
        ArrayList<String> lista = new ArrayList<>();

        File file = new File(sciezka);
        Scanner scannerFile = new Scanner(file);

        while (scannerFile.hasNextLine()) {
            String wiersz = scannerFile.nextLine();
            String[] wierszTab = wiersz.split(";");
            if (wierszTab[1].equals(nazwisko)) {
                lista.add(noweImie + ";" + noweNazwisko + ";" + wierszTab[2]);
            } else {
                lista.add(wiersz);
            }
        }
        scannerFile.close();

        FileWriter fileWriter = new FileWriter(sciezka, false);
        for (String x : lista) {
            fileWriter.append(x + "\n");
        }
        fileWriter.close();
    }

    public void wyszukaj(String sciezka, String fraza) throws FileNotFoundException {
        File file = new File(sciezka);
        Scanner scannerFile = new Scanner(file);
        boolean znalz1 = false;

        while (scannerFile.hasNextLine()) {
            String wiersz = scannerFile.nextLine();
            String[] wierszTab = wiersz.split(";");
            boolean znalz = false;


            for (int i = 0; i < wierszTab.length; i++) {
                if (wierszTab[i].contains(fraza)) {
                    znalz = true;
                }
            }

            if(znalz){
                System.out.println("Imie: " + wierszTab[0] + " Nazwisko: " + wierszTab[1] + " Wyplata: " + wierszTab[2]);
                znalz1 = true;
            }
        }

        if(!znalz1){
            System.out.println("Nie znaleziono");
        }

        scannerFile.close();
    }


}
