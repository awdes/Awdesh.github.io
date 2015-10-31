/**
 * Created by awdesh on 4/4/15.
 */
public class Child2 extends Parent {

    public void call()
    {
       handleCall();
    }

    @Override
    public int Sum(int a, int b)
    {
        int sum = 0;
        sum = a + b;
        return sum;
    }

    public void Print()
    {
        System.out.println("print of child class 2 has been called");
    }

    @Override
    public void handleCall()
    {
        System.out.println("child class 2 method is called");
    }


}
