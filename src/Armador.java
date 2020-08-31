import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Armador extends Thread {

    private ArrayList<Rueda> ruedas;
    private ArrayList<Cuadro> cuadros;
    private ArrayList<Manubrio> manubrios;

    private Bicicleta bicicleta;

    private Semaphore semaforo1;
    private Semaphore semaforo2;
    private Semaphore semaforo3;
    private Semaphore semaforoc1;
    private Semaphore semaforoc2;
    private Semaphore semaforoc3;

    public Armador(ArrayList<Rueda> r, ArrayList<Cuadro> c, ArrayList<Manubrio> m, Semaphore s1, Semaphore s2, Semaphore s3, Semaphore sc1, Semaphore sc2, Semaphore sc3){
        ruedas=r;
        cuadros=c;
        manubrios=m;
        semaforo1=s1;
        semaforo2=s2;
        semaforo3=s3;
        semaforoc1=sc1;
        semaforoc2=sc2;
        semaforoc3=sc3;

        bicicleta=null;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                semaforo1.acquire();
                semaforo1.acquire();
                semaforo2.acquire();
                semaforo3.acquire();
                System.out.println("Armador: hay "+ruedas.size()+" ruedas almacendas.");
                Rueda r1=ruedas.remove(ruedas.size()-1);
                System.out.println("Armador: tomo una rueda y quedan: "+ruedas.size()+" almacendas.");
                Rueda r2=ruedas.remove(ruedas.size()-1);
                System.out.println("Armador: tomo otra rueda y quedan: "+ruedas.size()+" almacendas.");
                Cuadro c=cuadros.remove(cuadros.size()-1);
                Manubrio m=manubrios.remove(manubrios.size()-1);

                bicicleta=new Bicicleta(r1,r2,c,m);
                bicicleta.montar();
                Thread.sleep(5000);

                semaforoc1.release();
                semaforoc1.release();
                semaforoc2.release();
                semaforoc3.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
