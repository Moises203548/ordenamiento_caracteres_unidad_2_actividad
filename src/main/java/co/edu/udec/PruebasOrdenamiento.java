package co.edu.udec;
public class PruebasOrdenamiento {

    private static int ok = 0, fallos = 0;

    private static void probar(String nombre, String entrada, String esperado) {
        OrdenadorCaracteres ord = new OrdenadorCaracteres(false);
        char[] r = ord.ordenarCadena(entrada);
        String obtenido = new String(r);
        boolean pasa = obtenido.equals(esperado)
                && OrdenadorCaracteres.estaOrdenado(r)
                && OrdenadorCaracteres.mismosCaracteres(entrada.toCharArray(), r);
        System.out.printf("[%s] %-28s \"%s\" -> \"%s\" (comp=%d, desp=%d)%n",
                pasa ? "OK" : "FALLO", nombre, entrada, obtenido,
                ord.getComparaciones(), ord.getDesplazamientos());
        if (pasa) ok++; else fallos++;
    }

    public static void ejecutarTodas() {
        ok = 0; fallos = 0;
        System.out.println("\n=== Casos de prueba ===");
        probar("Ejemplo principal",        "Programacion",  "aacgimnooPrr");
        probar("Mayúsculas y minúsculas",  "bAcDeF",        "AbcDeF");
        probar("Repetidos y estabilidad",  "bBaA",          "aAbB");
        probar("Ya ordenado",              "abcdef",        "abcdef");
        probar("Orden inverso",            "fedcba",        "abcdef");
        probar("Un solo carácter",         "x",             "x");
        probar("Todos iguales",            "aaaa",          "aaaa");
        probar("Con espacios",             "b a",           " ab");
        probar("Con dígitos y símbolos",   "b2a1!",         "!12ab");
        System.out.println("Resultado: " + ok + " correctas, " + fallos + " fallidas");
    }

    public static void main(String[] args) {
        ejecutarTodas();
    }
}
