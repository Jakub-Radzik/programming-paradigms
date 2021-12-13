package Lab8.Polimorficzna;

public class Walec extends Paczka {
    private double promien;
    private double wysokosc;

    public Walec(double promien, double wysokosc) {
        this.promien = promien;
        this.wysokosc = wysokosc;
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    @Override
    public double objetosc() {
        return (Math.PI * this.promien * this.promien) * this.wysokosc;
    }

    @Override
    public String toString() {
        return "Walec{" +
                "promien=" + promien +
                ", wysokosc=" + wysokosc +
                '}';
    }
}
