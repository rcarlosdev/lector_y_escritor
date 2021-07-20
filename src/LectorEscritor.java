import java.util.concurrent.Semaphore;

public class LectorEscritor{

    public static void main(String[] args) {
        final int NRO_LECTORES = 2;
        final int NRO_ESCRITORES = 5;
        final int MAX_RECURSOS = 3;

        Semaphore semaforo = new Semaphore(MAX_RECURSOS);

        for (int i = 0; i < NRO_ESCRITORES; i++){
            new Proceso("Escritor " + i, Proceso.Tipo.ESCRITOR, semaforo).start();
        }

        for (int i = 0; i < NRO_LECTORES; i++) {
            new Proceso("Lector " + i, Proceso.Tipo.LECTOR, semaforo).start();
        }
    }
}
