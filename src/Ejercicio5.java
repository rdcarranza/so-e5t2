import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Ejercicio5 {
    private static ArrayList<Rueda> ruedas;
    private static ArrayList<Cuadro> cuadros;
    private static ArrayList<Manubrio> manubrios;

    public static void main(String[] args) {
        ruedas=new ArrayList<Rueda>();
        cuadros=new ArrayList<Cuadro>();
        manubrios=new ArrayList<Manubrio>();

        Semaphore semaforo1=new Semaphore(0);
        Semaphore semaforo2=new Semaphore(0);
        Semaphore semaforo3=new Semaphore(0);

        Semaphore semaforoc1=new Semaphore(20);
        Semaphore semaforoc2=new Semaphore(10);
        Semaphore semaforoc3=new Semaphore(10);

        Operario1 op1=new Operario1(ruedas,semaforo1,semaforoc1);
        Operario2 op2=new Operario2(cuadros,semaforo2,semaforoc2);
        Operario3 op3=new Operario3(manubrios,semaforo3,semaforoc3);

        Armador armador=new Armador(ruedas, cuadros, manubrios, semaforo1, semaforo2, semaforo3, semaforoc1, semaforoc2, semaforoc3);

        op1.start();
        op2.start();
        op3.start();

        armador.start();

    }
}
