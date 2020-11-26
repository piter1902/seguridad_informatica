import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Cuenta {
    /**
     * Puntero al fichero "cuenta.txt"
     */
    private RandomAccessFile fp;

    /**
     * Crea un objeto cuenta asociado al fichero "cuenta.txt"
     */
    public Cuenta() throws Exception {
        this.fp = new RandomAccessFile(new File("backEndOrig/cuenta.txt"), "rw");
    }


    /**
     * Obtiene el saldo
     *
     * @return El contenido del fichero "cuenta.txt" (entero que especifica el saldo)
     */
    public int obtenerSaldo() throws IOException {
        this.fp.seek(0);
        return Integer.parseInt(this.fp.readLine());
    }


   /**
     * Establece un nuevo saldo en la cuenta
     *
     * @param nuevoSaldo nuevo saldo que se quiere guardar en el fichero "cuenta.txt"
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
        this.fp.close();
    }

}
