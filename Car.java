/**
 * Car class file
 * No main() method included; only class elements
 */

public class Car {

    private int startMiles = 0;
    private int endMiles = 0;


    // constructors
    /**
     * Constructor for Car class objects.
     * The Car() constructor will get starting and ending
     * miles info passed from the "new" object creation
     * statement in the main() method.
     */
    public Car(int starting, int ending) {

        if (starting >= 0 && ending >= 0) {
            
            startMiles = starting;
            endMiles = ending;
        } else {
            LogManager.Warn("Starting odometer values cannot equal 0!");
        }

    }


    public int getDistance() {
        int distance = endMiles - startMiles;
        return distance;
    }

    // Private

}