import java.awt.*;
import java.util.Random;

public class Client implements Runnable {
    private final CallCenter callCenter;

    public Client(CallCenter callCenter)
    {
        this.callCenter = callCenter;
    }


    @Override
    public void run() {
        while (true)
        {
            Operator operator;
            synchronized (callCenter)
            {
                operator = callCenter.getFreeOperator();
            }

            if(operator != null)
            {
                try {
                    operator.handleCall();
                } catch (InterruptedException exception) {
                    System.out.println(exception.getMessage() + " ID - " + operator.getId());
                }
            }
            else {
                System.out.println("Все операторы заняты. Клиент может попробовать позже");
                try {
                    Thread.sleep(4000);
                }
                catch (InterruptedException exception) {
                    System.out.println(exception.getMessage() + " ID - " + operator.getId());
                }

            }
        }
    }
}
