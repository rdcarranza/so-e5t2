import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Operario1 extends Thread{
    private ArrayList<Rueda> ruedas;
    private Semaphore semaforo1;
    private Semaphore semaforoc1;

    public Operario1(ArrayList<Rueda> r, Semaphore s1, Semaphore sc1){
        ruedas=r;
        semaforo1=s1;
        semaforoc1=sc1;
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            try {
                semaforoc1.acquire();
                Rueda r = new Rueda();
                Thread.sleep(1000);
                r.fabricar();
                ruedas.add(r);
                semaforo1.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
