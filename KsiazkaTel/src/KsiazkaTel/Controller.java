package KsiazkaTel;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Controller {

    DBConnect dbConnect = new DBConnect();

    public void dodaj(String imie, String nazwisko, int telefon, String email) throws SQLException {

        String sql = "INSERT INTO kontakty(imie, nazwisko, telefon, email) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = dbConnect.getCon().prepareStatement(sql);
        ps.setString(1, imie);
        ps.setString(2, nazwisko);
        ps.setInt(3, telefon);
        ps.setString(4, email);
        ps.execute();
        ps.close();

        System.out.println("Czy zatwierdzasz wykonanie operacji T/N ?");
        Scanner scanner = new Scanner(System.in);
        String decyzja = scanner.nextLine().toUpperCase();

        if (decyzja.equals("T")) {
            dbConnect.getCon().commit();
            System.out.println("Dane zostaly zapisane !");
        } else {
            dbConnect.getCon().rollback();
            System.out.println("Operacja nie zostala wykonana");
        }
    }

    public void pokaz() throws SQLException {
        String sql = "SELECT * FROM kontakty";

        Statement st = dbConnect.getCon().createStatement();
        ResultSet reslt = st.executeQuery(sql);

        while (reslt.next()) {
            System.out.println("ID: " + reslt.getInt("idkontakty") + " Imię: " + reslt.getString("imie")
                    + " Nazwisko: " + reslt.getString("nazwisko") + " telefon: " + reslt.getInt("telefon") +
                    " email: " + reslt.getString("email"));
        }
        st.close();
        reslt.close();

    }

    public void usun(String nazwisko) throws SQLException {
        String sql1 = "SELECT * FROM kontakty WHERE nazwisko = '" + nazwisko + "'";

        Statement st = dbConnect.getCon().createStatement();
        ResultSet rt = st.executeQuery(sql1);
        rt.next();
        int id = rt.getInt("idkontakty");
        st.close();
        rt.close();


        String sql2 = "DELETE FROM kontakty WHERE idkontakty = ?";
        PreparedStatement ps = dbConnect.getCon().prepareStatement(sql2);
        ps.setInt(1, id);
        ps.execute();
        ps.close();


        System.out.println("Czy chcesz usunąć: " + nazwisko + "  T/N ?");
        Scanner scanner = new Scanner(System.in);
        String decyzja = scanner.nextLine().toUpperCase();

        if (decyzja.equals("T")) {
            dbConnect.getCon().commit();
            System.out.println("Kontakt zostal usuniety!");
        } else {
            dbConnect.getCon().rollback();
            System.out.println("Operacja nie zostala wykonana");
        }

    }

    public void zmien(String nazwisko, String noweImie, String noweNazwisko, int nowyTelefon, String nowyEmail) throws SQLException {
        String sql1 = "SELECT * FROM kontakty WHERE nazwisko = '" + nazwisko + "'";

        Statement st = dbConnect.getCon().createStatement();
        ResultSet rt = st.executeQuery(sql1);
        rt.next();
        int id = rt.getInt("idkontakty");
        rt.close();

        String sql2 = "UPDATE kontakty SET imie = ?,  nazwisko = ?,  telefon = ?,  email = ? WHERE idkontakty = ?";
        PreparedStatement ps = dbConnect.getCon().prepareStatement(sql2);
        ps.setString(1, noweImie);
        ps.setString(2, noweNazwisko);
        ps.setInt(3, nowyTelefon);
        ps.setString(4, nowyEmail);
        ps.setInt(5, id);
        ps.execute();
        ps.close();
        rt.close();
        st.close();

        System.out.println("Czy zmeinić: " + nazwisko + "  T/N ?");
        Scanner scanner = new Scanner(System.in);
        String decyzja = scanner.nextLine().toUpperCase();

        if (decyzja.equals("T")) {
            dbConnect.getCon().commit();
            System.out.println("Kontakt zostal zmieniony!");
        } else {
            dbConnect.getCon().rollback();
            System.out.println("Operacja nie zostala wykonana");
        }

    }

    public void wyszukaj(String fraza) throws SQLException {
        String sql1 = "SELECT * FROM kontakty WHERE nazwisko LIKE '%" + fraza + "%' OR imie LIKE '%" + fraza + "%'";

        Statement st = dbConnect.getCon().createStatement();
        ResultSet rt = st.executeQuery(sql1);

        while (rt.next()) {

            System.out.println("ID: " + rt.getInt("idkontakty") + " Imię: " + rt.getString("imie")
                    + " Nazwisko: " + rt.getString("nazwisko") + " telefon: " + rt.getInt("telefon") +
                    " email: " + rt.getString("email"));

        }
        st.close();
        rt.close();
    }
}
