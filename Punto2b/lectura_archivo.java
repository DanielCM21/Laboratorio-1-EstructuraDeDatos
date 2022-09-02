import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class lectura_archivo {

    private static String[] datos;
    public static void main(String[] args) {
        
        long inicio = System.nanoTime();
        String lineas;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Archivo\\AccidentesDeTransito.csv"));
            while ((lineas = reader.readLine()) != null)
            {
                datos = lineas.split(";");
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        long fin = System.nanoTime() - inicio;
        float segundos = (float)fin/1000000000; 
        System.out.println("Este proceso tuvo una duración de:" + segundos + " segundos");
    }
}