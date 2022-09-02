import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Timer;
import java.util.TimerTask;


public class lectura_archivo {

    private static String[] datos;
    public static void main(String[] args) {
        
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
    }
}

class StopWatch{

    Timer timer;

    public StopWatch(int seconds) {
        timer = new Timer();
        timer.schedule(new StopTask(), seconds * 1000);
    }

    public static void main(String[] args) {
        new StopWatch(10);
        System.out.println("StopWatch Started.");
    }

    class StopTask extends TimerTask {
        public void run() {
            System.out.println("Time Up!");
            timer.cancel();
        }
    }
}