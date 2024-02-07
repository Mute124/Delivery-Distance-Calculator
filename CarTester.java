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

// Note : With all due respect ma'am, Alot of this code is incredibly unsafe and simply terrible. Nothing against you as I write code according to alot of NASA's standard practice.
// The comments at the end are what I am refering to, they also contian the guidelines I follow aswell.
public class CarTester
{
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
        // Why are we using again as a bool. It is inefficient.
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



/*
 * Nasa's Code practices : 
 * 
    Avoid complex flow constructs, such as goto and recursion.
    
    All loops must have fixed bounds. This prevents runaway code.
    
    Avoid heap memory allocation.
    
    Restrict functions to a single printed page.
    
    Use a minimum of two runtime assertions per function.
    
    Restrict the scope of data to the smallest possible.
    
    Check the return value of all non-void functions, or cast to void to indicate the return value is useless.
    
    Use the preprocessor sparingly.
    
    Limit pointer use to a single dereference, and do not use function pointers.
    
    Compile with all possible warnings active; all warnings should then be addressed before release of the software.

    On top of all that I add the rules of : 

    Do not repeat code, for example, line 62. It was able to be put all in ONE line reducing function calls.

    Always, and I mean always, design systems, and or functions as if they have zero information. This prevents scope creep, all over the place code, etc
    
    Always design the program to be modular, easy to read (Dont do that prefix bullcrap that alot of libraries use), reuseable, and expandable. 
    this allows the program to be able to grow with ease and not have to refactor everything. 

    Do not comment code, radical I know. But think about it, if you force yourself to not write comments you force yourself to write good code,
    code that anyone can understand. it also saves time!

    The code should be broad, not specific to any architecture or OS. 

    The code should be short, but also at the same time powerful! (This is where modularibility is important)

    Maintain a common format.

    Simplicity is always better than complexity! (always)

    Following these rules are the reason that my game engine can run at 2000-3000 frames a second on most devices. Remember, planning for everything reduces debugging! 
 *  
 * 
 */