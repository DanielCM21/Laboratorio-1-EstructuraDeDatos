import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class lab_01 {
    public static void main(String[] args) {       
    
        Scanner leer = new Scanner(System.in);
        System.out.println("escribir nombre del archivo con datos generales de los clientes.");
        String client = leer.nextLine();
        String clientvalidatecsv = (client + ".csv");
        
        System.out.println("escribir el nombre del archivo que contiene las facturas.");
        String Facturas = leer.nextLine();
        String Facturascsv = (Facturas + ".csv");

        System.out.println("escribe el nombre del archivo de los productos.");
        String productos = leer.nextLine();
        String productoscsv = (productos + ".csv");
    
        int sizefactures = sizeint(Facturas);
        int sizeclients = sizeint(client);
        int sizeproducts = sizeint(productos);

        System.out.println("listas organizadas por cédula.");
        

        

        
    try {

       

        String [][] clients = matrix(clientvalidatecsv);
        orden(clients, 1);
    
        
        String [][] facturelist = matrix(Facturascsv);
        orden(facturelist, 1);
        


        String [][] productslist = matrix(productoscsv);
        

        printmatriz(clients);
        System.out.println("----------------------------------------");
        printmatriz(facturelist);
        System.out.println("----------------------------------------");
        printmatriz(productslist);

        


} catch (Exception e) {}
        

    }

    public static String[][] matrix(String archivo) {
        
        try{

            int columnas = colums(archivo);
            int [] length = size(archivo); 
            FileReader  legible = new FileReader(archivo);
            BufferedReader read_file= new BufferedReader(legible);
            String reading = null;
            String [][] savelines = new String [length[0]][length[1]];
            int fila=0;
            

            while ((reading = read_file.readLine()) != null) {
            
                String [] temp = reading.split(";"); 
                for (int pos= 0; pos < temp.length; pos++){

                    savelines [fila][pos] = temp [pos];


                }
                
                fila++;
                
            }
          
              
          legible.close();
          return savelines;
            
        
        
        } 
        catch (Exception caporo) {
       
            return null;

        }


    }

    
    public static int []  size(String archivo) {
        
        try {

            int [] contador = new int [2];
            String reading = null;
            FileReader  legible = new FileReader(archivo);
            BufferedReader read_file= new BufferedReader(legible);
             
             
             while ((reading = read_file.readLine()) != null) {
                String [] temp = reading.split(";");
                
                contador[0]++;
                contador[1]=temp.length;

                }
            read_file.close();
            return contador;


        } catch (Exception e) {

            return null;
            
        }
       

    }

    public static int colums (String  archivo) {
        try {
                
                FileReader  legible = new FileReader(archivo);
                BufferedReader read_file= new BufferedReader(legible);
                String reading = read_file.readLine();
                String [] divide= reading.split(";");
                
            
                return divide.length;
        } catch (Exception e) {

            return 0;
        
        }
        

    }

    public static void printmatriz(String[][] matriz) {
        for (int i=0;i<matriz.length;i++){
            for (int j=0; j<matriz[0].length;j++){
                System.out.print(matriz[i][j]+"\t");
                if (j== matriz[0].length-1)     
                System.out.println("");
                
            }
        }
    }

    public static String[][] orden(String [][] ordened, int colum){

        colum = colum -1;
        String [] temporal = new String[ordened[0].length];
        for(int i = 0; i<ordened.length-1;i++){
            for(int j=0; j<ordened.length-i-1;j++){
                if(Integer.parseInt(ordened[j][colum])>Integer.parseInt(ordened[j+1][colum])){
                    for(int k=0; k<ordened[0].length; k++){
                        temporal[k] = ordened[j][k];
                    }
                    for(int k=0; k<ordened[0].length;k++){
                        ordened[j][k] = ordened[j+1][k];
                    }
                    for(int k=0; k<ordened[0].length;k++){
                        ordened[j+1][k] = temporal[k];
                    }
                }
            }
        }
        return null;

    }

    public static int sizeint (String archivo){
        int i =0;
        try {
            String strCurrentLine = null;
            FileReader lector = new FileReader(archivo + ".csv");
            BufferedReader reader = new BufferedReader(lector);
            while ((strCurrentLine = reader.readLine ())!= null) {
                    i++;
            }  
        } catch (Exception e) {
        }    
        return i;
    }

}