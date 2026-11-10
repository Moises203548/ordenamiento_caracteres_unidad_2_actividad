package co.edu.udec;

import java.util.Arrays;
public class OrdenadorCaracteres {

    private int comparaciones;
    private int desplazamientos;
    private boolean mostrarProceso;

    public OrdenadorCaracteres(boolean mostrarProceso) {
        this.mostrarProceso = mostrarProceso;
    }

    public int getComparaciones() { return comparaciones; }
    public int getDesplazamientos() { return desplazamientos; }

    public static int comparar(char a, char b) {
        return Character.toLowerCase(a) - Character.toLowerCase(b);
    }

    public char[] ordenarCadena(String texto) {
        char[] datos = texto.toCharArray();
        insertionSort(datos);
        return datos;
    }

    public void insertionSort(char[] a) {
        comparaciones = 0;
        desplazamientos = 0;
        if (a == null) return;

        for (int i = 1; i < a.length; i++) {
            char clave = a[i];
            int j = i - 1;
            if (mostrarProceso) {
                System.out.println("\nPaso " + i + ": tomar '" + clave + "' (posición " + i + ")");
            }
            // Desplazar a la derecha los elementos mayores que la clave.
            // Se usa '>' estricto: si son iguales NO se desplaza (estabilidad).
            while (j >= 0) {
                comparaciones++;
                if (comparar(a[j], clave) > 0) {
                    a[j + 1] = a[j];
                    desplazamientos++;
                    if (mostrarProceso) {
                        System.out.println("   desplazar '" + a[j + 1] + "' de pos " + j + " a pos " + (j + 1));
                    }
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = clave;
            if (mostrarProceso) {
                System.out.println("   insertar '" + clave + "' en pos " + (j + 1));
                System.out.println("   arreglo: " + Arrays.toString(a));
            }
        }
    }

    public static boolean estaOrdenado(char[] a) {
        for (int i = 1; i < a.length; i++) {
            if (comparar(a[i - 1], a[i]) > 0) return false;
        }
        return true;
    }

    public static boolean mismosCaracteres(char[] original, char[] ordenado) {
        char[] x = original.clone();
        char[] y = ordenado.clone();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }
}
