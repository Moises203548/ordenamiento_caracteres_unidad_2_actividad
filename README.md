# Ejercicio 15 – Ordenamiento de caracteres (Insertion Sort)

**Asignatura:** Estructuras de datos · **Programa:** Ingeniería del software ·
**actividad:** Unidad 2 – Algoritmos de ordenamiento

## Descripción
El programa lee una cadena escrita por el usuario, la convierte en un arreglo de caracteres (`char[]`) y la ordena
alfabéticamente con **Insertion Sort implementado manualmente** (sin `Arrays.sort`).

Cumple los requisitos del ejercicio:
- Ordena los caracteres alfabéticamente (ascendente).
- Ignora diferencias entre mayúsculas y minúsculas al comparar (`'a'` y `'A'` se consideran iguales).
- Mantiene los caracteres repetidos (el algoritmo es estable: iguales conservan su orden original).
- Muestra el proceso de desplazamiento e inserción en cada paso.
- Cuenta comparaciones y desplazamientos y verifica que el resultado esté ordenado.

## Estructura
```
src/
├── OrdenadorCaracteres.java   # Insertion Sort, comparador, contadores y verificaciones
├── Main.java                  # Menú interactivo (ingresar cadena / pruebas)
└── PruebasOrdenamiento.java   # Casos de prueba
```

## Cómo ejecutar
Requiere JDK 8 o superior.
```bash
cd src
javac *.java
java Main                  # menú interactivo
java PruebasOrdenamiento   # solo casos de prueba
```

## Ejemplo
Entrada: `HolaMundo` → Salida: `adHlMnoou` (21 comparaciones, 14 desplazamientos).

## Complejidad
| Caso | Tiempo | Cuándo ocurre |
|---|---|---|
| Mejor | O(n) | Arreglo ya ordenado |
| Promedio | O(n²) | Datos desordenados |
| Peor | O(n²) | Arreglo en orden inverso |

Espacio auxiliar O(1) (in-place) y algoritmo estable.
