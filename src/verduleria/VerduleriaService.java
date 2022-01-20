package verduleria;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class VerduleriaService {
    
    
     Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    // Método para mostrar el menú de opciones
    public void menuOpciones(HashMap<String, Double> catalogoMap) {

        int opcion;
        do {
            System.out.println("\n" + "\n" + "\t" + "Bienvenidos a Fresh Market");
            System.out.println("........................................");
            System.out.println("Por favor seleccione una opción:");
            System.out.println("\t" + "1. Cargar un nuevo producto" + "\n" + "\t" + "2. Modificar precio" + "\n" + "\t" + "3. Eliminar un producto" + "\n" + "\t" + "4. Imprimir lista de productos" + "\n" + "\t" + "5. Salir");
            System.out.println("........................................");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cargarProductos(catalogoMap);
                    break;
                case 2:
                    modificarPrecio(catalogoMap);
                    break;
                case 3:
                    eliminarProducto(catalogoMap);
                    break;
                case 4:
                    imprimirProductos(catalogoMap);
                    break;
                case 5:
                    salir();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // Método para cargar productos
    public void cargarProductos(HashMap<String, Double> catalogoMap) {
        String respuesta = "";
        String producto = "";
        Double precio = 0.0;

        do {
            System.out.println("\n" + "Ingrese nombre del producto:");
            producto = scanner.next().toUpperCase();

            System.out.println("Ingrese el precio de " + producto.toUpperCase() + ":");
            precio = scanner.nextDouble();

            catalogoMap.put(producto, precio);

            System.out.println("\n" + "¿Desea ingresar un nuevo producto? (SI/NO)");
            respuesta = scanner.next();

        } while (respuesta.equalsIgnoreCase("si"));
        
    }

    // Método para modificar precio
    public void modificarPrecio(HashMap<String, Double> catalogoMap) {
        String respuesta = "";
        String producto = "";
        Double precio = 0.0;
       
        do {
            System.out.println("\n" + "¿Qué producto desea modificar?");
            producto = scanner.next().toUpperCase();

            if (catalogoMap.containsKey(producto)) {
                System.out.println("Ingrese su nuevo precio:");
                precio = scanner.nextDouble();
                catalogoMap.put(producto, precio);
                System.out.println("Producto modificado con éxito.");
                
            } else {
                System.out.println("El producto no se encuentra en la lista.");
            }

            System.out.println("\n" + "¿Desea modificar otro producto? (SI/NO)");
            respuesta = scanner.next();
        } while (respuesta.equalsIgnoreCase("si"));

    }

    // Método para eliminar producto
    public void eliminarProducto(HashMap<String, Double> catalogoMap) {
        String respuesta = "";
        String producto = "";
        
        do {
            System.out.println("\n" + "¿Qué producto desea eliminar?");
            producto = scanner.next().toUpperCase();

            if (catalogoMap.containsKey(producto)) {
                catalogoMap.remove(producto);
                System.out.println("Producto eliminado con éxito.");
                
            } else {
                System.out.println("El producto no se encuentra en la lista.");
            }

            System.out.println("\n" + "¿Desea eliminar otro producto? (SI/NO)");
            respuesta = scanner.next();

        } while (respuesta.equalsIgnoreCase("si"));

    }

    // Método para imprimir los productos
    public void imprimirProductos(HashMap<String, Double> catalogoMap) {

        System.out.println("\n" + "La lista de productos ingresados es la siguiente:");
        
        
        Iterator<HashMap.Entry<String, Double>> it = catalogoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Double> obj = it.next();
            System.out.println("- " + obj.getKey().toUpperCase() + ": $" + obj.getValue());
        }

    }

    // Método para salir
    public void salir() {
        System.out.println("Muchas gracias por utilizar nuestros servicios.");
    }

}
