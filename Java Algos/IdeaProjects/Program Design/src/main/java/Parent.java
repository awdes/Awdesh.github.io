/**
 * Created by awdesh on 4/4/15.
 */
public abstract class Parent {
    private int a = 10;

    public abstract int Sum(int x1, int x2);

    public void print()
    {
        System.out.println("print method has been called");
    }

    public void PrintParent()
    {
        System.out.println("I am Print from parent");
        // Depends on the object of child class respective child class method has been called.
        this.handleCall();
    }

    public abstract void handleCall();

    public final int Multiply(int a, int b)
    {
        int c = a * b;
        return c;
    }
}
