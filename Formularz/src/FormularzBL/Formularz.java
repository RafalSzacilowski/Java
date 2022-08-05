package FormularzBL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Formularz extends JFrame{

    ArrayList<Rezerwacja> listaRezerwacji = new ArrayList<>();

    private JPanel rootPanel;
    private JTextField imie;
    private JTextField nazwisko;
    private JComboBox wylotZ;
    private JComboBox przylotDo;
    private JRadioButton TAKRadioButton;
    private JRadioButton NIERadioButton;
    private JCheckBox przystawkaCheckBox;
    private JCheckBox obiadCheckBox;
    private JCheckBox deserCheckBox;
    private JButton dodajRezerwacjeButton;
    private JTextArea Uwagi;
    private JTable table1;
    private JButton usunRezerwacjeButton;
    private JButton zakonczProgramButton;

    public Formularz (){
        add(rootPanel);
        setTitle("Formularz rezerwacji biletu lotniczego");
        setSize(1200,500);

        //zamkniecie okna ma konczyc proces
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //definicja kolumn dla tabeli
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Imię");
        model.addColumn("Nazwisko");
        model.addColumn("Wylot z");
        model.addColumn("Przylot do");
        model.addColumn("VIP");
        model.addColumn("Posiłek");
        model.addColumn("Uwagi");
        table1.setModel(model);

        zakonczProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        dodajRezerwacjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imie.getText().equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Nie podałeś imienia!");
                }else if(nazwisko.getText().equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Nie podałeś nazwiska!");
                }else if(wylotZ.getSelectedItem().equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Musisz wybrać miejce wylotu!");
                }else if(przylotDo.getSelectedItem().equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Musisz wybrać miejce przylotu!");
                }else if(!TAKRadioButton.isSelected() && !NIERadioButton.isSelected()){
                    JOptionPane.showMessageDialog(rootPane, "Zaznacz VIP!");
                }else if(!przystawkaCheckBox.isSelected() && !obiadCheckBox.isSelected() && !deserCheckBox.isSelected()){
                    JOptionPane.showMessageDialog(rootPane, "Zaznacz posiłek!");
                }else {

                    String vip;
                    if(TAKRadioButton.isSelected()){
                        vip = "tak";
                    }else {
                        vip = "nie";
                    }
                    String posilek;
                    ArrayList<String> posilki = new ArrayList<>();

                    if(przystawkaCheckBox.isSelected()){
                        posilek = "Przystawka";
                        posilki.add(posilek);
                    }
                    if(obiadCheckBox.isSelected()){
                        posilek = "Obiad";
                        posilki.add(posilek);
                    }
                    if(deserCheckBox.isSelected()){
                        posilek = "Deser";
                        posilki.add(posilek);
                    }

                    Rezerwacja rezerwacja = new Rezerwacja(imie.getText(), nazwisko.getText(),
                            wylotZ.getSelectedItem().toString(), przylotDo.getSelectedItem().toString(), vip, Uwagi.getText(), posilki);

                    listaRezerwacji.add(rezerwacja);

                    listaRezerwacji(model);

                    imie.setText("");
                    nazwisko.setText("");
                    wylotZ.setSelectedIndex(0);
                    przylotDo.setSelectedIndex(0);
                    TAKRadioButton.setSelected(false);
                    NIERadioButton.setSelected(false);
                    przystawkaCheckBox.setSelected(false);
                    obiadCheckBox.setSelected(false);
                    deserCheckBox.setSelected(false);
                    Uwagi.setText("");
                }
            }
        });
        TAKRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TAKRadioButton.isSelected()){
                    NIERadioButton.setSelected(false);
                }else {
                    TAKRadioButton.setSelected(true);
                }
            }
        });
        NIERadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(NIERadioButton.isSelected()){
                    TAKRadioButton.setSelected(false);
                }else {
                    NIERadioButton.setSelected(true);
                }
            }
        });
        usunRezerwacjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(table1.getSelectedRow() != -1) {

                    listaRezerwacji.remove(table1.getSelectedRow());
                    listaRezerwacji(model);
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Zaznacz rezerwacje!");

                }

            }
        });
    }


    public void listaRezerwacji(DefaultTableModel model){

        int ileWierszy = model.getRowCount();
        for(int i = ileWierszy -1 ; i >= 0; i--){
            model.removeRow(i);
        }

        for(Rezerwacja x : this.listaRezerwacji){
            model.addRow(new Object[]{x.imie, x.nazwisko , x.wylotZ , x.przylotDo, x.miejsceVIP, x.listaPosilkow, x.uwagi});
        }


    }


}
