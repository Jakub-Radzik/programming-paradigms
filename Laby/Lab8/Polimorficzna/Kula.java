package Lab8.Polimorficzna;

public class Kula extends Paczka {

    private double promien;

    public Kula(double promien) {
        this.promien = promien;
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    @Override
    public double objetosc() {
        return (4 * Math.PI * this.promien * this.promien * this.promien) / 3;
    }

    @Override
    public String toString() {
        return "Kula{" +
                "promien=" + promien +
                '}';
    }
}
