package cemaforo;

import java.util.ArrayList;
import java.util.List;

public class Main {


    Semaforo semaforo1 = new Semaforo(1);
    Semaforo semaforo2 = new Semaforo(2);
    Semaforo semaforo3 = new Semaforo(3);

    public Main() {
        List<Semaforo> semaforos = new ArrayList<Semaforo>();
        semaforos.add(semaforo1);
        semaforos.add(semaforo2);
        semaforos.add(semaforo3);

        Simulador simulador = new Simulador(semaforos,300,150);
        new Thread(semaforo1).start();
        new Thread(semaforo2).start();
        new Thread(semaforo3).start();


    }

    public static void main(String[] args) {
        new Main();
    }
}

