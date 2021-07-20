import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class Proceso extends Thread{
    public enum Tipo{LECTOR, ESCRITOR};
    private Semaphore semaforo;
    private Tipo tipo;

    public Proceso(String name, Tipo tipo, Semaphore semaforo){
        super(name);
        this.semaforo = semaforo;
        this.tipo = tipo;
    }

    @Override
    public void run(){
        if (tipo == tipo.LECTOR) {
            leer();
        }else {
            escribir();
        }
    }

    private void leer(){
        System.out.println(getName() + " intentando leer...");
        try {
            semaforo.acquire();
            System.out.println(getName() + " leyendo...");
            Thread.sleep((long) (Math.random() * 50));
            semaforo.release();
            System.out.println(getName() + " ya he leido.");
        }catch (InterruptedException ex){
            Logger.getLogger(Proceso.class.getName());
        }
    }

    private void escribir(){
        System.out.println(getName() + " intentando escribir...");
        try {
            semaforo.release();
            System.out.println(getName() + " escribiendo...");
            Thread.sleep((long) (Math.random() * 50));
            semaforo.release(5);
            System.out.println(getName() + " ya he escrito.");
        }catch (InterruptedException xe){
            Logger.getLogger(Proceso.class.getName());
        }
    }
}
