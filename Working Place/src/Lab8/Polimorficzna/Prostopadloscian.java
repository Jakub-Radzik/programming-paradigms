package Lab8.Polimorficzna;

public class Prostopadloscian extends Paczka {
    private double wysokosc;
    private double szerokosc;
    private double glebokosc;

    public Prostopadloscian(double wysokosc, double szerokosc, double glebokosc) {
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.glebokosc = glebokosc;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    public double getGlebokosc() {
        return glebokosc;
    }

    public void setGlebokosc(double glebokosc) {
        this.glebokosc = glebokosc;
    }

    @Override
    public double objetosc() {
        return this.glebokosc * this.wysokosc * this.szerokosc;
    }

    @Override
    public String toString() {
        return "Prostopadloscian{" +
                "wysokosc=" + wysokosc +
                ", szerokosc=" + szerokosc +
                ", glebokosc=" + glebokosc +
                '}';
    }
}
