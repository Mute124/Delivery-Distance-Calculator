/**
 * This project calculates the distance of deliveries based on the Odometer. 
 * (each new calculation will erase the data stored in the object's instance varaibles)
 *  object-oriented programming is the best answer as it will allow to create a car object 
 * that stores both the starting and the ending odometer reading to the object.
 * 
 * @author Pierce Steinke 
 * @version 1/24/2024
 */

// Importing everything to make things easier. 
import java.util.*;

public class CarTester
{

    public static String newLine = "\n";

    public static void main(String[] args)
    {
        // User input variable
        Scanner usrInputScanner = new Scanner(System.in);   
        
        // NOTE : This is not good practice but I would like to ask why we 
        // are doing this anyways? This can be simply put as a char.
        String again = "y";

   

        int beginingOdometer = 0;
        int endingOdometer = 0;

        

        // NOTE: If user inputs anything besides y, the program will close.
        while(again.equals("y")) {

            //  Get required data about the car.
            // Inputting anything other than a number crashed the program. this is here to prevent that.
            try {
                LogManager.Question("What is the starting odometer reading?");
                beginingOdometer = usrInputScanner.nextInt();
            } catch (Exception e) {
                LogManager.Warn("Please input a number!!");
                
                LogManager.Question("What is the starting odometer reading?");
                beginingOdometer = usrInputScanner.nextInt();
            }
            
            try {
                LogManager.Question("What is the ending odometer reading?");
                endingOdometer = usrInputScanner.nextInt();

           
            } catch (Exception e) {
                LogManager.Warn("Please input a number!!");
                
                LogManager.Question("What is the ending odometer reading?");
                endingOdometer = usrInputScanner.nextInt();


                // TODO: handle exception
            }

            Car car = new Car(beginingOdometer, endingOdometer);
            
            LogManager.LogBland("Distance driven: " + car.getDistance());

            LogManager.Question("calculate another trip?");

            // this can be in one line rather than two.
            again = usrInputScanner.next().toLowerCase(); 

            // log a new line as bland
            LogManager.NewBlandLine();


        }

        // WARNING : This prevents a resource leak.
        usrInputScanner.close();
    }
}