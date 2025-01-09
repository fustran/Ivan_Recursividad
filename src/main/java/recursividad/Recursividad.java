package recursividad;

/*
 * Ejercicio 1. Crea un programa principal que muestre un menú de opciones y permita ejecutar desde ese mismo programa cualquiera de los ejercicios que realices a continuación. Por ejemplo:
 * Una vez ejecutado el ejercicio deseado, debemos preguntar siempre al usuario si quiere volver al menú principal o salir del programa. Por ejemplo:

*Ejercicio 1. 
-Crea un método que obtenga la cantidad de dígitos de un número N mayor que cero. Se debe pasar como parámetro el número N. 
⚠️OJO: no vale pasarlo a String y calcular el tamaño con la función length()!!!
Si ese número N es 0, devuelvo 0.
Si N no es 0, recorremos del número dividiéndolo entre 10 hasta llegar a 0. 
Cada vez que dividamos entre 10, aumentamos en 1 nuestro contador.

*Ejercicio 2. 
-Crea un método que obtenga el resultado de elevar un número a otro. Ambos números se deben pasar como parámetros. Los números deben ser positivos. 

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

import java.util.Scanner;

public class Recursividad {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("1 - Dígitos");
            System.out.println("2 - Potencias");
            System.out.println("3 - Del Revés");
            System.out.println("4 - Binario");
            System.out.println("5 - A binario");
            System.out.println("6 - Orden alfabético");
            System.out.println("7 - Mostrar suma");
            System.out.print("Introduce una opción: ");
            opcion = entradaTeclado.nextInt();

            switch (opcion) {
                case 1 -> cantidadDigitos(opcion);
                case 2 -> elevarNumeroAOtro(opcion);
                case 3 -> numeroInvertido(opcion);
                case 4 -> comprobarNumeroBinario(opcion);
                case 5 -> obtenerNumeroBinario(opcion);
                case 6 -> comprobarPalabraOrdenada(opcion);
                case 7 -> sumaNumerosNaturales(opcion);
                default -> System.out.println("Opción incorrecta");
            }
        } while (opcion != 11);
    }

    //Método para obtener la cantidad de dígitos de un número N mayor que cero.
    public static void cantidadDigitos(int numero) {
    
    }

    //Método que obtener el resultado de elevar un número a otro.
    public static void elevarNumeroAOtro(int numero){

    }

    //Método para invertir un número positivo.
    public static void numeroInvertido(int numero){

    }

    //Método para comprobar si un número es binario.
    public static void comprobarNumeroBinario(int numero){

    }

    //Método que obtenga el número binario de un número N pasado como parámetro. 
    public static void obtenerNumeroBinario(int numero){

    }

    //étodo que compruebe si una palabra está ordenada alfabéticamente.
    public static void comprobarPalabraOrdenada(int numero){

    }

    //Método que obtenga la suma de los números naturales desde 1 hasta N.
    public static void sumaNumerosNaturales(int numero){

    }
}