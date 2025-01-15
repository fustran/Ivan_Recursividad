package recursividad;

import java.io.IOException;
import java.util.Scanner;

public class Recursividad {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    static char palabra_vector[]=null;

    public static void main(String[] args) throws IOException, InterruptedException { // Lanzar excepciones de entrada/salida y de interrupción.

        String palabra = "hola";

        palabra_vector = palabra.toCharArray();
        int posicion_final = palabra_vector.length;
        palabraInvertida(posicion_final - 1, palabra);

        while (true) {
            // Validar entrada del menú principal.
            boolean validarMenuUno = false;
            while (!validarMenuUno) {
                Recursividad.imprimirMenuUno();
                int opcion = Recursividad.leerOpcion();

                if (opcion >= 1 && opcion <= 8) {
                    Recursividad.opcionElegida(opcion);
                    validarMenuUno = true;
                } else {
                    System.out.println("");
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
                        System.out.println("\nOpción no válida. Inténtalo de nuevo.");
                        break;
                }
            }
        }
    }

    // Método para borrar la consola. 
    public static void borrar() throws IOException, InterruptedException { 
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    // Método para limpiar la consola. 
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Método que imprime el menú de opciones.
    public static void imprimirMenuUno() throws IOException, InterruptedException {
        //borrar(); // Limpia la consola antes de imprimir el menú (windows=cls, linux=clear)
        System.out.println("");
        System.out.println("\nSelecciona el modo que quieres ejecutar:");
        System.out.println("1 - Dígitos");
        System.out.println("2 - Potencias");
        System.out.println("3 - Número al Revés");
        System.out.println("4 - Palabra al revés");
        System.out.println("5 - Binario");
        System.out.println("6 - A binario");
        System.out.println("7 - Orden alfabético");
        System.out.println("8 - Mostrar suma");
        System.out.print("--> ");
    }

    // Método para imprimir el menú secundario.
    public static void imprimirMenuDos() {
        //clearScreen(); // Limpia la consola antes de imprimir el menú (windows=cls, linux=clear)
        System.out.println("");
        System.out.println("Elige una opción: ");
        System.out.println("   [M] - Volver al menú principal");
        System.out.println("   [X] - Salir");
        System.out.print("--> ");
    }

    // Método para leer la opción del usuario.
    public static int leerOpcion() {
        while (!entradaTeclado.hasNextInt()) {
            System.out.println("");
            System.out.println("Error: Introduce un número válido:");
            System.out.println("-->");
            entradaTeclado.next();
        }
        return entradaTeclado.nextInt();
    }

    // Método para leer la respuesta del usuario.
    public static String leerRespuesta() {
        return entradaTeclado.next().trim().toUpperCase();
    }

    // Método que llama al método correspondiente según la opción elegida.
    public static void opcionElegida(int opcion) {
        switch (opcion) { //Este tipo de switch me lo ha sugerido el vs code como corrección. Lo crea más compacto y no hay que usar break.
            case 1 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = entradaTeclado.nextInt();
                System.out.println("\nEl resultado es: " + cantidadDigitos(numeroIntroducido));
            }
            case 2 -> {
                System.out.print("\nIntroduce la base: ");
                int base = entradaTeclado.nextInt();
                System.out.print("Introduce el exponente: ");
                int exponente = entradaTeclado.nextInt();
                System.out.println("\nEl resultado es: " + elevarNumeroAOtro(base, exponente));
            }
            case 3 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = entradaTeclado.nextInt();
                System.out.print("\nEl número invertido es: ");
                numeroInvertido(numeroIntroducido);
                System.out.println();
            }
            case 4 -> {
                System.out.print("\nIntroduce una palabra: ");
                String palabraIntroducida = entradaTeclado.next();
                System.out.print("\nLa palabra invertida es: ");
                palabraInvertida(palabraIntroducida.length() - 1, palabraIntroducida);
                System.out.println();
            }
            case 5 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = entradaTeclado.nextInt();
                comprobarNumeroBinario(numeroIntroducido);
            }
            case 6 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = entradaTeclado.nextInt();
                System.out.print("\nEl número binario es: ");
                obtenerNumeroBinario(numeroIntroducido);
                System.out.println();
            }
            case 7 -> {
                if (comprobarPalabraOrdenada(0)) {
                    System.out.println("La palabra está ordenada.");
                } else {
                    System.out.println("La palabra no está ordenada.");
                }
            }
            case 8 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = entradaTeclado.nextInt();
                System.out.println("\nLa suma de los números naturales es: " + sumaNumerosNaturales(numeroIntroducido));
            }
        }
    }

    //EJERCICIO-1
    // Método para obtener la cantidad de dígitos de un número N mayor que cero.
    public static int cantidadDigitos(int numero) {
        if (numero < 10) {
            return 1;
        } else {
            return 1 + cantidadDigitos(numero / 10); // Llamada recursiva dividiendo entre 10.
        }
    }

    //EJERCICIO-2
    // Método que obtiene el resultado de elevar un número a otro.
    public static int elevarNumeroAOtro(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * elevarNumeroAOtro(base, --exponente); // Llamada recursiva restando 1 al exponente.
        }
    }

    //EJERCICIO-3
    // Método para invertir un número positivo.
    public static void numeroInvertido(int numero) {
        if(numero >= 0 && numero < 10){
            System.out.print(numero);
        }else{
            System.out.print(numero % 10);
            numeroInvertido(numero / 10);
        }
    }

    //EJERCICIO-4
    // Método para invertir una palabra.
    public static void palabraInvertida(int posicion, String palabra) {
        char[] palabraArray = palabra.toCharArray();
        if (posicion == 0){
            System.out.print(palabraArray[posicion]);
        }else{
            System.out.print(palabraArray[posicion]);
            palabraInvertida(posicion -1, palabra);
        }
    }

    //EJERCICIO-5
    // Método para comprobar si un número es binario.
    public static boolean comprobarNumeroBinario(int numero) {
        if (numero == 0 || numero == 1) {
            System.out.println("El número es binario.");
            return true;
        } else {
            if (numero % 10 > 1) {
                System.out.println("El número no es binario.");
                return false;
            } else {
                return comprobarNumeroBinario(numero / 10);
            
            }
        }
    }

    //EJERCICIO-6
    // Método que obtiene el número binario de un número N pasado como parámetro.
    public static void obtenerNumeroBinario(int numero) {
        if (numero == 0) {
            System.out.print("0");
        } else {
            obtenerNumeroBinario(numero / 2);
            System.out.print(numero % 2);
        }
    }

    // Ejercicio 6 - Otra forma
    public static String aBinario(int numero) {
        if (numero == 0 || numero == 1) {
            return Integer.toString(numero);
        } else {
            return aBinario(numero / 2) + numero % 2;
        }
    }

    //EJERCICIO-7
    // Método que comprueba si una palabra está ordenada alfabéticamente.
    public static boolean comprobarPalabraOrdenada(int posicion) {
        if (posicion < palabra_vector.length - 1) {
            if (palabra_vector[posicion] <= palabra_vector[posicion + 1]) {
                return comprobarPalabraOrdenada(posicion + 1);
            }else{
                return false;
            }
        }
        return true;
    } 

    //EJERCICIO-8
    // Método que obtiene la suma de los números naturales desde 1 hasta N.
    public static int sumaNumerosNaturales(int numero) {
        if (numero == 1) {
            return 1;
        } else {
            return numero + sumaNumerosNaturales(numero - 1);
        }
    }
}