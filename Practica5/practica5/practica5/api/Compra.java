import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Compra {

    public static void main(String[] args) {
        Carrito carrito = null;
        Cuenta cuenta = null;
        try {
            carrito = new Carrito();
            cuenta = new Cuenta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Escribir el saldo en pantalla
        int saldoActual = 0;
        try {
            saldoActual = cuenta.obtenerSaldo();
            System.out.println("Tu saldo actual es:" + saldoActual);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Escribir la lista de productos con sus precios
        System.out.println("Lista de productos:");
        String products = Tienda.muestraProductos();
        System.out.println(products);
        // Pide el producto que se quiere comprar
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué quieres comprar?");
        String comprar = scanner.nextLine();
        // Comprueba que el saldo es suficiente para comprar el producto
        int saldoCompra = Tienda.obtenerPrecioProducto(comprar);
        if (saldoActual >= saldoCompra) {
            // Saldo suficiente
            try {
                carrito.meterProducto(comprar);
                int saldoFinal = saldoActual - saldoCompra;
                cuenta.establecerSaldo(saldoFinal);
                System.out.println("Tu saldo es: " + saldoFinal);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        scanner.close();
        if (carrito != null) {
            try {
                carrito.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (cuenta != null) {
            try {
                cuenta.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
