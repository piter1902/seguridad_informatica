import java.util.HashMap;
import java.util.Map;

public class Tienda {
    /**
     * productos es un HashMap que incluye los productos con los precios.
     */
    private final static Map<String,Integer> productos= new HashMap<String,Integer>();
        
    static {
        productos.put("golosinas", 1);
        productos.put("cachirulo", 3);
        productos.put("coche", 40000);
        productos.put("iPhone11", 700);
        productos.put("libro", 80);
    }

    /**
     * Devuelve la lista de productos en la tienda 
     *
     * @return    lista productos
     */
    public static String muestraProductos(){
        String lista = "";
        for (String p : productos.keySet()) {
            lista += p + "\t" + productos.get(p) + " euros\n";
        }
        return lista;
    }


    /**
     * Devuelve el precio de un producto
     *
     * @param     producto (por ejemplo: "coche")
     * @return    el precio del producto
     */
    public static Integer obtenerPrecioProducto(String producto) {
        if(productos.containsKey(producto)) {
            return productos.get(producto);
        }

        throw new IllegalArgumentException("El producto " + producto + " no está disponible");
    }
}
