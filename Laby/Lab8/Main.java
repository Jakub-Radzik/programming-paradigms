package Lab8;

import Lab8.Niepolimorficznie.PaczkaNiepolimorficzna;
import Lab8.Niepolimorficznie.PocztaNiepolimorficzna;
import Lab8.Niepolimorficznie.TypPaczki;
import Lab8.Polimorficzna.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Poczta poczta = new Poczta(8, 18);
        ArrayList<Paczka> listaPaczek = new ArrayList<>(
                List.of(
                        new Kula(2),
                        new Kula(5),
                        new Kula(10),
                        new Walec(2, 2),
                        new Walec(3, 3),
                        new Walec(4, 4),
                        new Prostopadloscian(1, 1, 1),
                        new Prostopadloscian(2, 2, 2),
                        new Prostopadloscian(3, 3, 3),
                        new Graniastoslup(2,2),
                        new Graniastoslup(1,1),
                        new Graniastoslup(15,5)
                )
        );

        listaPaczek.forEach(paczka -> poczta.przyjmijPaczke(paczka));
        System.out.println("Male:");
        poczta.odczytajMale();
        System.out.println("Srednie: ");
        poczta.odczytajSrednie();
        System.out.println("Duze:");
        poczta.odczytajDuze();

        //niepolimorficznie
        System.out.println("NIEPOLIMORFICZNY PRZYKŁAD:");
        PocztaNiepolimorficzna pocztaNiepolimorficzna = new PocztaNiepolimorficzna(3, 10);

        ArrayList<PaczkaNiepolimorficzna> listaPaczekNiepolimorficznych = new ArrayList<>(
                List.of(
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(2.0)), TypPaczki.KULA),
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(4.0)), TypPaczki.KULA),
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(5.0)), TypPaczki.KULA),
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(1.0, 1.0)), TypPaczki.WALEC),
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(7.0, 7.0)), TypPaczki.WALEC),
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(10.0, 10.0)), TypPaczki.WALEC),
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(10.0, 10.0, 10.0)), TypPaczki.PROSTOPADLOSCIAN),
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(1., 1., 1.)), TypPaczki.PROSTOPADLOSCIAN),
                        new PaczkaNiepolimorficzna(new ArrayList<Double>(List.of(2., 2., 1.)), TypPaczki.PROSTOPADLOSCIAN)
                )
        );

        listaPaczekNiepolimorficznych.forEach(paczkaNiepolimorficzna -> pocztaNiepolimorficzna.przyjmijPaczke(paczkaNiepolimorficzna));
        System.out.println("Male: ");
        pocztaNiepolimorficzna.odczytajMale();
        System.out.println("Srednie: ");
        pocztaNiepolimorficzna.odczytajSrednie();
        System.out.println("Duze: ");
        pocztaNiepolimorficzna.odczytajDuze();

    }
}
