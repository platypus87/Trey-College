import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! Again");
        
        File file = new File("USPopulation.txt");
        Scanner scnr = new Scanner(file);
        int[] popList = new int[41];

        for (int i =0; i<41;i++ ){
            popList[i]=scnr.nextInt();
            System.out.println(popList[i]);
        }   
        
        System.out.println(avgAnnual(popList));
        System.out.println(getLargestDelta(popList));
        

    }



    public static int avgAnnual(int[] population){
        int avg = 0;
        try {
            for(int i=0; i<=population.length; i++){
            avg+=population[i+1]-population[i];
            }
         
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("Error: " + e);
        }
        
        avg=avg/(population.length-1);
        return avg;
    }

    public static int getLargestDelta(int[] population){
        int delta = 0;
        try {
            for(int i=0; i<=population.length; i++){
            if(population[i]>delta){
                delta=population[i];
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return delta;
    }

    public static void getSmallestDelta(int[] population){

    }

}





