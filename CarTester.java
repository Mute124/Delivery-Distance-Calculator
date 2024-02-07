/**
 * This project calculates the distance of deliveries based on the Odometer. 
 * (each new calculation will erase the data stored in the object's instance varaibles)
 *  object-oriented programming is the best answer as it will allow to create a car object 
 * that stores both the starting and the ending odometer reading to the object.
 * 
 * The project is slightly different from the example in the assignment. the changes include but not limited to :
 * - Using the LogManager class
 * - naming conventions
 * 
 * 
 * @author Pierce Steinke 
 * @version 1/24/2024
 */

// Importing everything to make things easier. 
import java.util.*;

public class CarTester
{
    public static void main(String[] args)
    {
        // User input variable
        Scanner usrInputScanner = new Scanner(System.in);   
        
        // NOTE : Respectfully this is like using a poster for a small note. In my opinion I think having a bool and this being a char would suffice
        // 
        String again = "y";

        // slightly changed wording from the example
        int beginingOdometer = 0;
        int endingOdometer = 0;

        // NOTE: If user inputs anything besides y, the program will close.
        while(again.equals("y")) {

            //  Get required data about the car.
            // WARNING : This is dangerous code! anything other than an integer will crash the program, respectfully, this is really bad practice and should never be done in this way.
            LogManager.Question("What is the starting odometer reading?");
            beginingOdometer = usrInputScanner.nextInt();

            LogManager.Question("What is the ending odometer reading?");
            endingOdometer = usrInputScanner.nextInt();

            Car car = new Car(beginingOdometer, endingOdometer);
            
            // log the distance. Converts the int to a string.
            LogManager.Log("Distance driven: " + car.getDistance());

            LogManager.Question("calculate another trip?");

            // this can be in one line rather than two. I changed it as it is both more readable, less code, and more efficient.
            again = usrInputScanner.next().toLowerCase(); 

            // log a new line blandly
            LogManager.NewBlandLine();
        }

        // NOTE : This prevents a resource leak.
        usrInputScanner.close();
    }
    
    // Console Logging Functionality, Added to aid in debugging and making it look nice.
// Made for the Do not repeat yourself rule of coding. Most of my programs have some version of this.
public class LogManager {
        // Here because of my coding procedures. Just ask me and I can send you my coding procedures. (Most of it actually is NASA's)
    // Holds the \n string operator thing (I dont know what it is called).
    public static String newLine = "\n";
    
    // Log with no formatting. Hence it is a Bland Log.
    public static void LogBland(String msg) {
        System.out.println(msg);
    }
    
    public static void NewBlandLine() {
        LogBland(newLine);
    }
    

    // Log an error.
    public static void Error(String file, String msg) {
        java.util.Date d = new java.util.Date();
        System.out.println( "[Error at " + file + "] {" + java.text.SimpleDateFormat.getDateTimeInstance().format(d) + "} : " + " " + msg);
    }
    // Send out a warning.
    public static void Warn(String msg) {
        java.util.Date d = new java.util.Date();
        System.out.println( "[Warning] {" + java.text.SimpleDateFormat.getDateTimeInstance().format(d) + "} : " + " " + msg);
    }

    // Take the current time, format it into 12 hour clock, and log the message
    public static void Log(String msg) {
        java.util.Date d = new java.util.Date();
        System.out.println( "[Info] {" + java.text.SimpleDateFormat.getDateTimeInstance().format(d) + "} : " + " " + msg);
    }

    // User input.
    public static void Question(String msg) {
        java.util.Date d = new java.util.Date();
        System.out.println( "[User Input] {" + java.text.SimpleDateFormat.getDateTimeInstance().format(d) + "} : " + " " + msg);

    }
}

}