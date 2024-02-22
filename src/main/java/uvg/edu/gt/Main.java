package uvg.edu.gt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal que contiene el método main para ejecutar la aplicación.
 * Esta clase lee expresiones matemáticas desde un archivo de texto, las evalúa utilizando una calculadora postfix,
 * y muestra los resultados.
 *
 * @author Javier Linares - 231135
 * @author Daniel Chet - 231177
 */

public class Main {

    /**
     * Método para leer el contenido de un archivo de texto.
     *
     * @param filePath Ruta del archivo de texto a leer.
     * @return El contenido del archivo como una cadena de caracteres.
     */
    public static String readTxtFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    /**
     * Método principal de la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este ejemplo).
     */
    public static void main(String[] args) {
        // Crear una pila para la calculadora
        MyStack<Integer> pila = new MyStack<>();
        // Crear una instancia de la calculadora
        CalculadoraPOSTFIX calculadora = new CalculadoraPOSTFIX(pila);

        // instanciar Lista Factory:
        ListaFactory nfactory = new ListaFactory();

        //Instanciar Expresion Factory
        ExpresionFactory nexpresion = new ExpresionFactory();

        // Leer el contenido del archivo de texto "datos.txt"
        String fileContent = readTxtFile("datos.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de lista:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Listas");


        int op = scanner.nextInt();
        switch (op) {
            case 1:
                String listas = nexpresion.getExpresion(fileContent,op);
                // Dividir el contenido del archivo en expresiones individuales
                String[] expressions1 = listas.split("\n");



                // Iterar sobre cada expresión en el archivo
                for (String expression1 : expressions1) {
                    // Imprimir la expresión actual
                    System.out.println("Expresión: " + expression1);
                    // Calcular el resultado de la expresión y mostrarlo
                    System.out.println("Resultado: " + calculadora.calcular(expression1));
                    System.out.println(); // Imprimir una línea en blanco para mayor claridad
                }
                break;
            case 2:
                String listas2 = nexpresion.getExpresion(fileContent,op);
                // Dividir el contenido del archivo en expresiones individuales
                String[] expressions2 = listas2.split("\n");



                // Iterar sobre cada expresión en el archivo
                for (String expression1 : expressions2) {
                    // Imprimir la expresión actual
                    System.out.println("Expresión: " + expression1);
                    // Calcular el resultado de la expresión y mostrarlo
                    System.out.println("Resultado: " + calculadora.calcular(expression1));
                    System.out.println(); // Imprimir una línea en blanco para mayor claridad
                }
                break;
            case 3:
                System.out.println("Listas");

                Scanner scannerList = new Scanner(System.in);
                System.out.println("Seleccione el tipo de lista:");
                System.out.println("1. Lista Simple");
                System.out.println("2. Lista Doblemente Enlazada");

                int opList = scannerList.nextInt();


                String lista = nfactory.getLista(fileContent,opList);
                // Dividir el contenido del archivo en expresiones individuales
                String[] expressions = lista.split("\n");



                // Iterar sobre cada expresión en el archivo
                for (String expression : expressions) {
                    // Imprimir la expresión actual
                    System.out.println("Expresión: " + expression);
                    // Calcular el resultado de la expresión y mostrarlo
                    System.out.println("Resultado: " + calculadora.calcular(expression));
                    System.out.println(); // Imprimir una línea en blanco para mayor claridad


                }
                break;


        }
    }
}