package recursividad;

import java.io.IOException;
import java.util.Scanner;

public class Recursividad {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    static char palabra_vector[]=null;

    public static void main(String[] args) throws IOException, InterruptedException { // Lanzar excepciones de entrada/salida y de interrupción.

        while (true) {
            // Validar entrada del menú principal.
            boolean validarMenuUno = false;
            while (!validarMenuUno) {
                imprimirMenuUno();
                int opcion = leerOpcionInt();

                if (opcion >= 1 && opcion <= 8) {
                    opcionElegida(opcion);
                    validarMenuUno = true;
                } else {
                    System.out.println("Error: Opción no válida, inténtalo de nuevo.");
                }
            }
            // Validar entrada del menú secundario.
            boolean validarMenuDos = false;
            while (!validarMenuDos) {
                imprimirMenuDos();
                String respuesta = leerOpcionMenuDos();

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
        System.out.println("    [1] - Dígitos");
        System.out.println("    [2] - Potencias");
        System.out.println("    [3] - Invertir número o cadena");
        System.out.println("    [4] - Es Binario?");
        System.out.println("    [5] - A binario");
        System.out.println("    [6] - Orden alfabético");
        System.out.println("    [7] - Mostrar suma");
        System.out.println("    [8] - Salir");
        System.out.print("->");
    }

    // Método para imprimir el menú secundario.
    public static void imprimirMenuDos() {
        //clearScreen(); // Limpia la consola antes de imprimir el menú (windows=cls, linux=clear)
        System.out.println("");
        System.out.println("Elige una opción: ");
        System.out.println("    [M] - Volver al menú principal");
        System.out.println("    [X] - Salir");
        System.out.print("-> ");
    }

    // Método para comprobar la opción de tipo int del usuario.
    public static int leerOpcionInt() {
        while (!entradaTeclado.hasNextInt()) {
            System.out.println("");
            System.out.println("Error: Introduce un número válido:");
            System.out.print("-->");
            entradaTeclado.next();
        }
        return entradaTeclado.nextInt();
    }

    // Método para comprobar la opción de tipo String del usuario.
    public static String leerOpcionString() {
        String entrada;
        do {
            if (entradaTeclado.hasNextLine()) { // Limpiar el buffer.
                entradaTeclado.nextLine();
            }
            entrada = entradaTeclado.nextLine().trim();
            if (!entrada.matches("^[a-zA-Z]+$")) {
                System.out.println("\nError: Introduce una palabra válida.");
                System.out.print("-->");
                entrada = entradaTeclado.next();
            }
        } while (!entrada.matches("^[a-zA-Z]+$"));
        return entrada;
    }

    // Método para comprobar la respuesta al menu 2 del usuario.
    public static String leerOpcionMenuDos() {
        return entradaTeclado.next().trim().toUpperCase();
    }

    // Método que llama al método correspondiente según la opción elegida.
    public static void opcionElegida(int opcion) {
        switch (opcion) { //Este tipo de switch me lo ha sugerido el vs code como corrección. Lo crea más compacto y no hay que usar break.

            // case 1: cantidadDigitos();
            case 1 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = leerOpcionInt(); // Se llama al método leerOpcion() para validar la entrada.
                System.out.println("\nEl resultado es: " + cantidadDigitos(numeroIntroducido));
            }

            // case 2: elevarNumeroAOtro();
            case 2 -> {
                System.out.print("\nIntroduce la base: ");
                int base = leerOpcionInt();
                System.out.print("\nIntroduce el exponente: ");
                int exponente = leerOpcionInt();
                System.out.println("\nEl resultado es: " + elevarNumeroAOtro(base, exponente));
            }

            // case 3: Invertir número o cadena.
            case 3 -> {
                while (true) {
                    System.out.println("\n¿Qué quieres invertir?");
                    System.out.println("    [1] - Número");
                    System.out.println("    [2] - Cadena");
                    System.out.println("    [3] - Volver al menú principal");
                    System.out.println("    [4] - Salir");
                    System.out.print("->");
                    int opcionDos = leerOpcionInt();
            
                    switch (opcionDos) {
                        case 1 -> {
                            // Invertir número
                            System.out.print("\nIntroduce un número: ");
                            int numero = leerOpcionInt();
                            System.out.print("\nEl número invertido es: ");
                            numeroInvertido(numero);
                            System.out.println();
                        }
                        case 2 -> {
                            // Invertir cadena
                            System.out.print("\nIntroduce una cadena: ");
                            String cadena = leerOpcionString();
                            System.out.print("\nLa cadena invertida es: ");
                            palabraInvertida(cadena.length() - 1, cadena);
                            System.out.println();
                        }
                        case 3 -> {
                            return;
                        }
                        case 4 -> {
                            System.exit(0);
                        }
                    }
                }
            }
            
            // case 4: comprobarNumeroBinario();
            case 4 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = leerOpcionInt();
    
                if(comprobarNumeroBinario(numeroIntroducido)){
                    System.out.println("--> Es binario...");
                }else{
                    System.out.println("--> NO es binario...");
                }
            }

            // case 5: obtenerNumeroBinario();
            case 5 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = leerOpcionInt();
                String numeroBinario = obtenerNumeroBinario(numeroIntroducido);
                System.out.println("\nEl número binario es: " + numeroBinario);
            }

            // case 6: comprobarPalabraOrdenada();
            case 6 -> {
                System.out.print("\nIntroduce una palabra: ");
                String palabra = leerOpcionString();
                palabra_vector = palabra.toCharArray();
            
                if (comprobarPalabraOrdenada(0)) {
                    System.out.println("\nLa palabra está ordenada.");
                } else {
                    System.out.println("\nLa palabra no está ordenada.");
                }
            }
            
            // case 7: sumaNumerosNaturales();
            case 7 -> {
                System.out.print("\nIntroduce un número: ");
                int numeroIntroducido = leerOpcionInt();
                System.out.println("\nLa suma de los números naturales es: " + sumaResultado(numeroIntroducido));
            }

            // case 8: Salir del programa.
            case 8 -> System.exit(0);
        }
    }

    //EJERCICIO-1
    // Método para obtener la cantidad de dígitos de un número N mayor que cero.
    public static int cantidadDigitos(int numero) {
        if (numero < 10) {
            return 1;
        } else {
            return 1 + cantidadDigitos(numero / 10);
        }
    }

    //EJERCICIO-2
    // Método que obtiene el resultado de elevar un número a otro.
    public static int elevarNumeroAOtro(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * elevarNumeroAOtro(base, --exponente);
        }
    }

    //EJERCICIO-3.0
    // Método para invertir un número positivo.
    public static void numeroInvertido(int numero) {
        if(numero >= 0 && numero < 10){
            System.out.print(numero);
        }else{
            System.out.print(numero % 10);
            numeroInvertido(numero / 10);
        }
    }

    //EJERCICIO-3.1
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

    //EJERCICIO-4
    // Método para comprobar si un número es binario.
    public static boolean comprobarNumeroBinario(int numero) {
        if(numero > 9){
            if(numero % 10 == 0 || numero % 10 == 1){
                return comprobarNumeroBinario(numero / 10);
            }else{
                return false;
            }
        }
        return numero == 0 || numero == 1;
    }

    //EJERCICIO-5
    // Método que obtiene el número binario de un número N pasado como parámetro.
    public static String obtenerNumeroBinario(int numero) {
        if(numero==0 || numero==1){
            return Integer.toString(numero);
        }else{
            return obtenerNumeroBinario(numero/2)+numero%2;
        }
    }

    //EJERCICIO-6
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

    //EJERCICIO-7.0
    // Método que obtiene la suma de los números naturales desde 1 hasta N.
    public static String sumaNumerosNaturales(int numero) {
        if (numero == 1) {
            return "1"; 
        } else {
            String resultado = sumaNumerosNaturales(numero - 1);
            return resultado + " + " + numero; 
        }
    }

    //EJERCICIO-7.1
    // Método para calcular la suma total.
    public static String sumaResultado(int numero) {
        String sumaCadena = sumaNumerosNaturales(numero); 
        int sumaTotal = (numero * (numero + 1)) / 2; 
        return sumaCadena + " = " + sumaTotal;
    }
}