package Lab8.Niepolimorficznie;

import Lab8.Polimorficzna.Paczka;

import java.util.ArrayList;

public class PocztaNiepolimorficzna {
    private ArrayList<PaczkaNiepolimorficzna> male;
    private ArrayList<PaczkaNiepolimorficzna> srednie;
    private ArrayList<PaczkaNiepolimorficzna> duze;

    private double sredniaPaczkaMinimumObjetosc;
    private double duzaPaczkaMinimumObjetosc;

    public PocztaNiepolimorficzna(double sredniaPaczkaMinimumObjetosc, double duzaPaczkaMinimumObjetosc) {
        this.sredniaPaczkaMinimumObjetosc = sredniaPaczkaMinimumObjetosc;
        this.duzaPaczkaMinimumObjetosc = duzaPaczkaMinimumObjetosc;

        this.male = new ArrayList<PaczkaNiepolimorficzna>();
        this.srednie = new ArrayList<PaczkaNiepolimorficzna>();
        this.duze = new ArrayList<PaczkaNiepolimorficzna>();
    }

    private void odczytajListe(ArrayList<PaczkaNiepolimorficzna> listaPaczek) {
        listaPaczek.forEach(System.out::println);
    }

    public void odczytajMale() {
        this.odczytajListe(male);
    }

    public void odczytajSrednie() {
        this.odczytajListe(srednie);
    }

    public void odczytajDuze() {
        this.odczytajListe(duze);
    }

    public void przyjmijPaczke(PaczkaNiepolimorficzna paczka) {
        if (paczka.objetosc() < this.sredniaPaczkaMinimumObjetosc) {
            this.male.add(paczka);
        } else if (paczka.objetosc() >= this.duzaPaczkaMinimumObjetosc) {
            this.duze.add(paczka);
        } else {
            this.srednie.add(paczka);
        }
    }
}
