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
        LogBland(CarTester.newLine);
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