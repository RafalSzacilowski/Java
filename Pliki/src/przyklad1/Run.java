package przyklad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Ksiazka> listaKsiazek = new ArrayList<>();
        File file = new File("C:\\Pliki\\src\\przyklad1\\ksiazki.txt");

        Scanner scannerFile = new Scanner(file);
        while (scannerFile.hasNextLine()) {
            String wiersz = scannerFile.nextLine();
            String[] txtTab = wiersz.split(";");
            Ksiazka ksiazka = new Ksiazka(txtTab[0], txtTab[1], txtTab[2]);
            listaKsiazek.add(ksiazka);
        }

        scannerFile.close();

        for (Ksiazka x : listaKsiazek) {
            System.out.println(x.autor + "\t " + x.nazwa + "\t" + x.rokWydania);
        }

    }
}
