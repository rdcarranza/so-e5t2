import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Operario3 extends Thread{
    private ArrayList<Manubrio> manubrios;
    private Semaphore semaforo3;
    private Semaphore semaforoc3;

    public Operario3(ArrayList<Manubrio> m, Semaphore s3, Semaphore sc3){
        manubrios=m;
        semaforo3=s3;
        semaforoc3=sc3;
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            try {
                semaforoc3.acquire();
                Manubrio m=new Manubrio();
                Thread.sleep(5000);
                m.fabricar();
                manubrios.add(m);
                semaforo3.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
