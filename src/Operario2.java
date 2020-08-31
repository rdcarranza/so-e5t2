import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Operario2 extends Thread{
    private ArrayList<Cuadro> cuadros;
    private Semaphore semaforo2;
    private Semaphore semaforoc2;

    public Operario2(ArrayList<Cuadro> c, Semaphore s2, Semaphore sc2){
        cuadros=c;
        semaforo2=s2;
        semaforoc2=sc2;
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            try {
                semaforoc2.acquire();
                Cuadro c = new Cuadro();
                Thread.sleep(10000);
                c.fabricar();
                cuadros.add(c);
                semaforo2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
