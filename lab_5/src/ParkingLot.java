import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class ParkingLot {
    private final Semaphore parkingSpacesN;
    private final Semaphore parkingSpacesM;

    public ParkingLot(int capacityN, int capacityM) {
        this.parkingSpacesN = new Semaphore(capacityN, true);
        this.parkingSpacesM = new Semaphore(capacityM, true);
    }

    public boolean parkN() throws InterruptedException {
        return parkingSpacesN.tryAcquire(1, 3, TimeUnit.SECONDS);
    }

    public boolean parkM() throws InterruptedException {
        return parkingSpacesM.tryAcquire(1, 3, TimeUnit.SECONDS);
    }

    public void leaveN() {
        parkingSpacesN.release();
    }

    public void leaveM() {
        parkingSpacesM.release();
    }
}
