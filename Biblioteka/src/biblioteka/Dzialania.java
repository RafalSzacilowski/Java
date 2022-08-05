package biblioteka;

public interface Dzialania {

    public void wypozyczKsiazke(String tytul);

    public void przyjmijZwrotKsiazki(String tytul);

    public void listaKsiazekWypozyczonych();

    public void listaKsiazekNieWypozyczonych();

}
