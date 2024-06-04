
public class CallCenter {
    private final Operator[] operators;

    public CallCenter(int operatorsCount)
    {
        operators = new Operator[operatorsCount];

        for(int i = 0 ; i < operators.length ; i++)
        {
            operators[i] = new Operator(i);
        }
    }

    public synchronized Operator[] getOperators() {
        return operators;
    }


    public synchronized Operator getFreeOperator()
    {
        for(Operator operator : operators)
        {
            if(!operator.isBusy())
            {
                return operator;
            }
        }
        return null;
    }
}
