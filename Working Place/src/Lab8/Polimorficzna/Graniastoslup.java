package Lab8.Polimorficzna;

public class Graniastoslup extends Paczka {
    private double a;
    private double wysokosc;

    public Graniastoslup(double a, double wysokosc) {
        this.a = a;
        this.wysokosc = wysokosc;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    @Override
    public double objetosc() {
        return (this.a * this.a * Math.sqrt(3) / 4) * 6 * this.wysokosc;
    }

    @Override
    public String toString() {
        return "Graniastoslup{" +
                "a=" + a +
                ", wysokosc=" + wysokosc +
                '}';
    }
}
