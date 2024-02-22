package uvg.edu.gt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarEnArchivo {
    public static void guardar(String c) {
        String ruta = "C:\\Users\\danie\\OneDrive\\Desktop\\MavenTest\\src\\main\\java\\uvg\\edu\\gt\\datos.txt";
        File archivo = new File(ruta);

        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileWriter escritor = new FileWriter(archivo);
            escritor.write(c+" ");
            escritor.close();

            System.out.println("Datos guardados exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos.");
            e.printStackTrace();
        }
    }
}
