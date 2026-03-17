import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HotelRatings {
    int hotelNumber, ratingsNumber; 
    int[][] numRats;
    Random rand = new Random();
    
    //Constructor takes in two parameters to create the 2-D array
    //Additionally, it creates random ratings from 1 (inc) to 6(exc)
    //which means any whole number from 1-5

    HotelRatings(int hotels, int ratings){
        hotelNumber=hotels;
        ratingsNumber = ratings;
        numRats= new int [hotels][ratings];

        for (int i=0; i<hotels; i++){
            for (int j=0; j<ratings;j++){
                numRats[i][j]=rand.nextInt(1,6);
            }
        }

    }

    public void getArray(){                                 //DONE
        /*
        a void method displaying the two-dimensional array
        with elements values which are generated randomly
         */
        int counter = 1;
        for (int[] i:numRats){
            System.out.print("Hotel "+counter+":\t");
            for (int j:i){
                System.out.print(j + "\t");
            }
            System.out.println();
            counter+=1;
        }
    }

    public List<Integer> getFiveStar(){                     //DONE
        //This uses the ArrayList<> construct in order to only have as many indexes
        //as is needed for the hotels that have 5 stars. Otherwise we would have
        //unneeded, blank, indexes in an Array

        /*
        return single dimensional array of indexes
        of the hotels that have earned five stars
        at least once over 
        */

        //int[] fiveStars=new int[numRats.length];
        List<Integer> fiveStars = new ArrayList<>();
       
        
        for (int i=0; i<numRats.length; i++){
            for(int j=0; j<numRats[i].length;j++){
                if(numRats[i][j]==5){
                    fiveStars.add(i);
                    break;
                }
            }
        }
        
        return fiveStars;
    }

    public double computeOverallAverageRating(){            //DONE
        /*
        A method returning the average rating
        of all the hotels over the years
         */

        //originally ONLY had avgRat as a double, but was not getting expected outcomes
        //changed ALL to double and output came as expected
        double total=0;
        double avgRat=0;
        double counter=0;

        for (int i=0; i<numRats.length; i++){
            for (int j=0; j<numRats[i].length;j++){
                total+=numRats[i][j];
                counter+=1;
                //System.out.println("counter in 'j': "+counter); //This was used for logic tracking
            }
           //System.out.println("Total after i["+i+"]: "+total); //This was used for logic tracking
        }
        avgRat=total/counter;
        return avgRat;
    }

    public boolean hasFiveStar(){                           //DONE
        /*
        A method returning True if at LEAST one hotel
        earned a five-star rating for at LEAST one year
         */

        boolean exists = false;
        
        for (int i=0; i<numRats.length; i++){
            /*
            exists == false, so !exists == true
            this means that this for loop will iterate for numRats.length no matter what
            but will not enter the "if" loop if exists gets switched inside the nested loop
             */
            if (!exists){
                for(int j=0; j<numRats[i].length;j++){
                    if(numRats[i][j]==5){
                        exists=true;
                        break;
                    }
                }
            }
        }

        return exists;
    }

    public int computeHighestYear(){                        //DONE
        /*                                                  //VERY bloated; holding for explanation(s) :)
        A method returning a year
        with the highest average ratings
         */

        System.out.println("This starts computeHighestYear()");
        int highHotel=-1;
        double[] yearTotals = new double[numRats[0].length];
        double[] yearAverage = new double[yearTotals.length];
       
        for (int i =0; i<numRats.length;i++){
            //System.out.println("Inside 'I' Loop");
            for (int j =0; j<numRats[0].length;j++){
                yearTotals[j]+=numRats[i][j];
                //System.out.println("Inside 'J' Loop");
            }
        }
        for(int i=0; i<yearTotals.length;i++){
            System.out.println("Year "+(i+1)+" total rating = "+yearTotals[i]);
        }
        for(double num:yearTotals){
            System.out.println(num);
        }

        for(int i = 0; i<yearAverage.length; i++){
            yearAverage[i]=(yearTotals[i]/yearAverage.length);
            System.out.println("yearAverage = "+yearAverage[i]);
        }

        System.out.print("HighHotel Variable is: ");
        return highHotel;
    }

    public double computeHighestAverage(){                  //DONE
        /*
        A method returning the highest average rating of
        all the hotels over all the years
         */

        double highHotel = -1;
        double yearRat=0;
        int counter=0;
        double highAvg=0;
        List<Double> hotAvs = new ArrayList<>();
       
        //first we compute the overall average over all the years per hotel
        for (int i=0; i<numRats.length; i++){
            yearRat=0;
            for(int j=0; j<numRats[i].length;j++){
                yearRat+=numRats[i][j];
            }
            hotAvs.add(yearRat/numRats[i].length);
        }

        //then we identify which hotel is had the highest overall average rating
        for (int i=0; i<hotAvs.size();i++){
            if(hotAvs.get(i)>highHotel){
                highHotel=(hotAvs.get(i)); //don't forget to use .get(i) here, was using (i+1) which was only dealing with the index, not the value stored in hotAvs
            }
        }

        //Enhanced for loop to check logic of function
        for(double year:hotAvs){
            counter+=1;
            System.out.printf("The average rating for Hotel %d was: "+year+" over "+numRats[0].length+" years.\n", counter);
        }

        return highHotel;
    }

}

/*
The following loop is how to iterate through a 2-D array
"nested for loop" or "enhanced for loop" using array notation/indexes
        
        for (int i = 0; i<arrayName.length;i++){
            System.out.println("I= "+i);
            for (int j=0; j<arrayName[0].length;j++){
                System.out.println("J= "+j);
            }
            System.out.println("I = "+i);
        }

  */


 /*
 //This creates an array that is as long as "numRats" is "wide."
        //Meaning, this array has the same number of index locations
        //as "numRats[]" does.
        //AKA: "columns" is a one-dimentional array and
        //has the same number of indexes that the first array in "numRats" has
        int[] columns = new int[numRats[0].length];
        for(int i=0; i<columns.length; i++){
            columns[i]=(i*i);
        }
             */