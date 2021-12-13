package Lab8.Niepolimorficznie;

import java.util.ArrayList;

public class PaczkaNiepolimorficzna {
    private ArrayList<Double> wymiary;
    private TypPaczki typPaczki;

    public PaczkaNiepolimorficzna(ArrayList<Double> wymiary, TypPaczki typPaczki) {
        this.wymiary = wymiary;
        this.typPaczki = typPaczki;
    }

    public double objetosc(){
        if (typPaczki == TypPaczki.PROSTOPADLOSCIAN) {
            return this.wymiary.get(0) * this.wymiary.get(1) * this.wymiary.get(2);
        } else if (typPaczki == TypPaczki.KULA) {
            return this.wymiary.get(0) * this.wymiary.get(0) * Math.PI;
        } else if (typPaczki == TypPaczki.WALEC) {
            return this.wymiary.get(0) * this.wymiary.get(0) * this.wymiary.get(1) * Math.PI;
        };
//        ZADANIE 2: TU DODAJ IFa z GRANISTOSLUPEM I OBLICZ WYMIAR DLA NIEGO
        return 0;
    }

    @Override
    public String toString() {
        return "PaczkaNiepolimorficzna{" +
                "wymiary=" + wymiary +
                ", typPaczki=" + typPaczki +
                '}';
    }
}
