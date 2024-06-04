class Car implements Runnable {
    private final String name;
    private final ParkingLot parkingLot;

    public Car(String name, ParkingLot parkingLot) {
        this.name = name;
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (parkingLot.parkN()) {
                    System.out.println(name + " припарковалась на стоянке N");
                    Thread.sleep(1500);
                    parkingLot.leaveN();
                    System.out.println(name + " покинула парковку N");
                    break;
                } else if (parkingLot.parkM()) {
                    System.out.println(name + " припарковалась на стоянке M");
                    Thread.sleep(2500);
                    parkingLot.leaveM();
                    System.out.println(name + " покинула парковку N");
                    break;
                } else {
                    System.out.println(name + " Не удалось найти место парковки, передвигаемся к другой парковке");
                    Thread.sleep(2500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
