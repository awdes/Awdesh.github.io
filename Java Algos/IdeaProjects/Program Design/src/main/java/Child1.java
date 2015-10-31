/**
 * Created by awdesh on 4/4/15.
 */
public class Child1 extends Parent {

    @Override
    public int Sum(int a, int b)
    {
        int sum = 0;
        sum = a + b;
        return sum;
    }

    private boolean IsDivisibleByTwo(int num)
    {
        boolean isDivisible = false;
        if(num % 2 == 0)
        {
            isDivisible = true;
        }
        return isDivisible;
    }

    public void Print()
    {
        System.out.println("print of child class 1 has been called");
    }

    @Override
    public void handleCall()
    {
        System.out.println("child class 1 method is called");
    }
}
