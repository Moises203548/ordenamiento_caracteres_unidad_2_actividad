package co.edu.udec;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    static void ejecutar(String texto) {
        System.out.println("============================================");
        System.out.println("Cadena ingresada : \"" + texto + "\"");
        char[] original = texto.toCharArray();
        System.out.println("Arreglo original : " + Arrays.toString(original));

        OrdenadorCaracteres ord = new OrdenadorCaracteres(true);
        char[] datos = original.clone();
        ord.insertionSort(datos);

        System.out.println("\n--------------------------------------------");
        System.out.println("Arreglo ordenado : " + Arrays.toString(datos));
        System.out.println("Cadena ordenada  : \"" + new String(datos) + "\"");
        System.out.println("Comparaciones    : " + ord.getComparaciones());
        System.out.println("Desplazamientos  : " + ord.getDesplazamientos());
        System.out.println("¿Ordenado?       : " + OrdenadorCaracteres.estaOrdenado(datos));
        System.out.println("¿Mismos caracteres (repetidos incluidos)? : "
                + OrdenadorCaracteres.mismosCaracteres(original, datos));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== Ordenamiento de caracteres (Insertion Sort) ===");
            System.out.println("1. Ingresar una cadena");
            System.out.println("2. Ejecutar casos de prueba");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            String linea = sc.nextLine().trim();
            try {
                opcion = Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                opcion = -1;
            }
            switch (opcion) {
                case 1:
                    System.out.print("Escribe una cadena: ");
                    String texto = sc.nextLine();
                    if (texto.isEmpty()) {
                        System.out.println("La cadena está vacía; no hay nada que ordenar.");
                    } else {
                        ejecutar(texto);
                    }
                    break;
                case 2:
                    PruebasOrdenamiento.ejecutarTodas();
                    break;
                case 0:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
