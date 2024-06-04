import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args)
    {
        //CallCenterStartWorking();

        //StartParking();


    }

    public static void CallCenterStartWorking()
    {
        int numOperators = 5;
        CallCenter callCenter = new CallCenter(numOperators);
        ExecutorService executor = Executors.newFixedThreadPool(numOperators + 1);
        for (Operator operator : callCenter.getOperators()) {
            executor.execute(operator);
        }
    }

    public static void StartParking()
    {
        int nCapacity = 3;
        int mCapacity = 2;
        int kCars = 100;

        ParkingLot parkingLot = new ParkingLot(mCapacity, nCapacity);
        ExecutorService executor = Executors.newFixedThreadPool(kCars);

        for (int i = 0; i < kCars; i++) {
            executor.execute(new Car("Car " + (i + 1), parkingLot));
        }

        executor.shutdown();
    }
}