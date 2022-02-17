package Lab8.Polimorficzna;

import Lab8.Polimorficzna.Paczka;

import java.util.ArrayList;

public class Poczta {
    private ArrayList<Paczka> male;
    private ArrayList<Paczka> srednie;
    private ArrayList<Paczka> duze;

    private double sredniaPaczkaMinimumObjetosc;
    private double duzaPaczkaMinimumObjetosc;

    public Poczta(double sredniaPaczkaMinimumObjetosc, double duzaPaczkaMinimumObjetosc) {
        this.sredniaPaczkaMinimumObjetosc = sredniaPaczkaMinimumObjetosc;
        this.duzaPaczkaMinimumObjetosc = duzaPaczkaMinimumObjetosc;

        this.male = new ArrayList<Paczka>();
        this.srednie = new ArrayList<Paczka>();
        this.duze = new ArrayList<Paczka>();
    }

    private void odczytajListe(ArrayList<Paczka> listaPaczek) {
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

    public void przyjmijPaczke(Paczka paczka) {
        if (paczka.objetosc() < this.sredniaPaczkaMinimumObjetosc) {
            this.male.add(paczka);
        } else if (paczka.objetosc() >= this.duzaPaczkaMinimumObjetosc) {
            this.duze.add(paczka);
        } else {
            this.srednie.add(paczka);
        }
    }
}
