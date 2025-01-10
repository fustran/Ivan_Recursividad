package recursividad;

/*

* Ejercicio 0. Crea un programa principal que muestre un menú de opciones y permita ejecutar desde ese mismo programa cualquiera de los ejercicios que realices a continuación. Por ejemplo:
    Una vez ejecutado el ejercicio deseado, debemos preguntar siempre al usuario si quiere volver al menú principal o salir del programa. Por ejemplo:

*Ejercicio 1. 
    -Crea un método que obtenga la cantidad de dígitos de un número N mayor que cero. Se debe pasar como parámetro el número N. 
    ⚠️OJO: no vale pasarlo a String y calcular el tamaño con la función length()!!!
    Si ese número N es 0, devuelvo 0.
    Si N no es 0, recorremos del número dividiéndolo entre 10 hasta llegar a 0. 
    Cada vez que dividamos entre 10, aumentamos en 1 nuestro contador.

*Ejercicio 2. 
    rea un método que obtenga el resultado de elevar un número a otro. Ambos números se deben pasar como parámetros. Los números deben ser positivos. 

*Ejercicio 3. 
    -Crea un método que dado un número positivo, lo imprima invertido por pantalla. 
    -Haz lo mismo pero con una cadena de texto como entrada. Usa el método .toCharArray().
    -En el programa principal de este ejercicio se deberá preguntar al usuario si quiere invertir una cadena o un número, y llamar al método que corresponda.

*Ejercicio 4. 
    -Crea un método que compruebe si un número es binario. Un número binario está formado únicamente por ceros y unos. 

*Ejercicio 5. 
    -Crea un método que obtenga el número binario de un número N pasado como parámetro. 

*Ejercicio 6. 
    -Crea un método que compruebe si una palabra está ordenada alfabéticamente. 

*Ejercicio 7. 
    -Crea un método que obtenga la suma de los números naturales desde 1 hasta N. Se debe pasar como parámetro el número N, debe ser mayor que cero. Se debe imprimir toda la cadena por consola. 
    -Por ejemplo, para N=4 → ( 1+2+3+4 = 10).

*/

public class Main {

    public static void main(String[] args) {

        while (true) {
            // Validar entrada del menú principal.
            boolean validarMenuUno = false;
            while (!validarMenuUno) {
                Recursividad.imprimirMenuUno();
                int opcion = Recursividad.leerOpcion();

                if (opcion >= 1 && opcion <= 7) {
                    Recursividad.opcionElegida(opcion);
                    validarMenuUno = true;
                } else {
                    System.out.println();
                    System.out.println("Error: Opción no válida, inténtalo de nuevo.");
                }
            }

            // Validar entrada del menú secundario.
            boolean validarMenuDos = false;
            while (!validarMenuDos) {
                Recursividad.imprimirMenuDos();
                String respuesta = Recursividad.leerRespuesta();

                switch (respuesta) {
                    case "X":
                        System.exit(0);
                    case "M":
                        validarMenuDos = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        System.out.println();
                        break;
                }
            }
        }
    }
}