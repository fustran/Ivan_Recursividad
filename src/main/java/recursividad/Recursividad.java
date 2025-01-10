package recursividad;

/* 
* Proyecto-2 
*/

import java.util.Scanner;

public class Recursividad {

    private static final Scanner entradaTeclado = new Scanner(System.in);

     // Método que imprime el menú de opciones.
    public static void imprimirMenuUno() {
        System.out.println("");
        System.out.println("\nSelecciona el modo que quieres ejecutar:");
        System.out.println("1 - Dígitos");
        System.out.println("2 - Potencias");
        System.out.println("3 - Del Revés");
        System.out.println("4 - Binario");
        System.out.println("5 - A binario");
        System.out.println("6 - Orden alfabético");
        System.out.println("7 - Mostrar suma");
        System.out.print("-> ");
    }

    // Método para imprimir el menú secundario.
    public static void imprimirMenuDos() {
        System.out.println("");
        System.out.println("Elige una opción: ");
        System.out.println("   [M] - Volver al menú principal");
        System.out.println("   [X] - Salir");
        System.out.print("-> ");
    }

    // Método para leer la opción del usuario.
    public static int leerOpcion() {
        while (!entradaTeclado.hasNextInt()) {
            System.out.println("");
            System.out.println("Error: Introduce un número válido:");
            entradaTeclado.next();
            imprimirMenuUno();
        }
        return entradaTeclado.nextInt();
    }

    // Método para leer la respuesta del usuario.
    public static String leerRespuesta() {
        return entradaTeclado.next().trim().toUpperCase();
    }

    // Método que llama al método correspondiente según la opción elegida.
    public static void opcionElegida(int opcion) {
        switch (opcion) {
            case 1 -> cantidadDigitos();
            case 2 -> elevarNumeroAOtro();
            case 3 -> numeroInvertido();
            case 4 -> comprobarNumeroBinario();
            case 5 -> obtenerNumeroBinario();
            case 6 -> comprobarPalabraOrdenada();
            case 7 -> sumaNumerosNaturales();
        }
    }

    // Método para obtener la cantidad de dígitos de un número N mayor que cero.
    public static void cantidadDigitos() {
        System.out.println("");
        System.out.print("Introduce un número: ");
        int numero = entradaTeclado.nextInt();
        int contador = 0;

        if (numero == 0) {
            System.out.println("El resultado es: 0");
        } else {
            while (numero != 0) {
                numero = numero / 10;
                contador++;
            }
            System.out.println("El resultado es: " + contador);
        }
    }

    // Método que obtiene el resultado de elevar un número a otro.
    public static void elevarNumeroAOtro() {
        
    }

    // Método para invertir un número positivo.
    public static void numeroInvertido() {
        
    }

    // Método para comprobar si un número es binario.
    public static void comprobarNumeroBinario() {
        
    }

    // Método que obtiene el número binario de un número N pasado como parámetro.
    public static void obtenerNumeroBinario() {
        
    }

    // Método que comprueba si una palabra está ordenada alfabéticamente.
    public static void comprobarPalabraOrdenada() {
        
    }

    // Método que obtiene la suma de los números naturales desde 1 hasta N.
    public static void sumaNumerosNaturales() {
        
    }
}