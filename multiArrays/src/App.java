import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        //Initializing the object with hard-coded params
        HotelRatings hotel = new HotelRatings(4,4);
        //Testing initializing the object with random rows/cols from 1-5
        HotelRatings hostel = new HotelRatings(rand.nextInt(1,6), rand.nextInt(1,6)); 
        
        /*
        //Printing out each item in the 2D array to confirm object intialized correctly
        hotel.getArray();
        System.out.println("Total hotel ratings average: "+hotel.computeOverallAverageRating());
        System.out.println("Checking for 5-star ratings in hotel: ");
        hotel.hasFiveStar();
          */

        System.out.println("---Line Break---");
       
        //Printing out each item in the randomized 2D array
        hostel.getArray();
        // System.out.println("Total hostel ratings average: "+hostel.computeOverallAverageRating());
        // System.out.println("Checking for 5-star ratings in hostel: ");
        // hostel.hasFiveStar();
        
        System.out.print("Index(es) of 5-Star years: ");
        System.out.println(hostel.getFiveStar());
        System.out.println(hostel.computeHighestAverage());
        System.out.println(hostel.computeHighestYear());

    }
}
