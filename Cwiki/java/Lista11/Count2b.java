//Jakub Radzik

package Cwiki.java.Lista11;
// zad 2b
import java.util.concurrent.Semaphore;
class IntCell2b {
    private int n = 0;
    public int getN() {return n;}
    public void setN(int n) {this.n = n;}
}
public class Count2b extends Thread {
    private static IntCell2a n = new IntCell2a();
    private static Semaphore s = new Semaphore(1);
    public void run() {
        int temp;
        try{
            s.acquire();
            for (int i = 0; i < 200000; i++) {
                temp = n.getN();
                n.setN(temp + 1);
            }
            s.release();
        } catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Count2b p = new Count2b();
        Count2b q = new Count2b();
        p.start();
        q.start();
        try { p.join(); q.join(); }
        catch (InterruptedException e) { }
        System.out.println("The value of n is " + n.getN());
    }
}
