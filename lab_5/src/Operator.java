import java.util.Random;

public class Operator implements Runnable {
    private final int id;
    private boolean isBusy;

    private int ordersCompleted;

    public Operator(int id)
    {
        this.id = id;
        isBusy = false;
        ordersCompleted = 0;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized boolean isBusy()
    {
        return isBusy;
    }

    public synchronized void handleCall() throws InterruptedException {
        isBusy = true;
        System.out.println("Оператор " + id + " начинает обслуживание клиента");
        try {
                Thread.sleep(4000);
        }
        catch (InterruptedException exception)
        {
            System.out.println(exception.getMessage() + "ID - " + id);
        }
        isBusy = false;
        System.out.println("Оператор " + id + " оканчивает обслуживание клиента, всего обслужено: " + ++ordersCompleted);
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                handleCall();
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
