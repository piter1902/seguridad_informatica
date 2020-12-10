import java.io.File;
import java.io.RandomAccessFile;


public class Carrito {
    /**
     * Puntero al fichero "carrito.txt"
     */
    private RandomAccessFile fp;

    /**
     * Crea un objeto cuenta asociado al fichero "cuenta.txt"
     */
    public Carrito() throws Exception {
        this.fp = new RandomAccessFile(new File("backEndOrig/carrito.txt"), "rw");
    }

    /**
     * Añade un producto al carrito.
     *
     * @param producto nombre del producto (por ejemplo, "coche")
     */
    public void meterProducto(String producto) throws Exception {
        this.fp.seek(this.fp.length());
        this.fp.writeBytes(producto + '\n');
    }

    /**
     * Cierre fichero
     */
    public void close() throws Exception {
        this.fp.close();
    }
}
