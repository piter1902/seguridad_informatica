import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Cuenta {
    /**
     * Puntero al fichero "cuenta.txt"
     */
    private RandomAccessFile fp;
    // Source:
    // https://dzone.com/articles/locking-files-in-java#:~:text=In%20Java%2C%20a%20file%20lock,given%20region%20of%20a%20ile.
    private static FileChannel fc;

    /**
     * Crea un objeto cuenta asociado al fichero "cuenta.txt"
     */
    public Cuenta() throws Exception {
        this.fp = new RandomAccessFile(new File("backEndOrig/cuenta.txt"), "rw");
        fc = this.fp.getChannel();
    }

    /**
     * Obtiene el saldo
     *
     * @return El contenido del fichero "cuenta.txt" (entero que especifica el
     *         saldo)
     */
    public int obtenerSaldo() throws IOException {
        this.fp.seek(0);
        return Integer.parseInt(this.fp.readLine());

    }

    /**
     * Establece un nuevo saldo en la cuenta
     *
     * @param nuevoSaldo nuevo saldo que se quiere guardar en el fichero
     *                   "cuenta.txt"
     */
    public void establecerSaldo(int nuevoSaldo) throws Exception {
        this.fp.setLength(0);
        String str = Integer.valueOf(nuevoSaldo).toString() + '\n';
        this.fp.writeBytes(str);
    }

    /**
     * Cierre fichero
     */
    public void close() throws Exception {
        fc.close();
        this.fp.close();
    }

    /**
     * Retira de la cuenta la cantidad de dinero indicada
     */
    public void sacarDinero(int cantidad) throws Exception {
        FileLock fileLock = null;
        // fc.lock es bloqueante
        fileLock = fc.lock(0L, Long.MAX_VALUE, false);
        int dineroActual = obtenerSaldo();
        if (dineroActual >= cantidad) {
            establecerSaldo(dineroActual - cantidad);
        } else {
            throw new RuntimeException("Saldo insuficiente.");
        }

        if (fileLock != null) {
            fileLock.release();
        }
    }

}
