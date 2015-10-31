/**
 * Created by awdesh on 4/4/15.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Child1 obj = new Child1();
        obj.handleCall();
        obj.PrintParent();

        System.out.println();

        Child2 obj2 = new Child2();
        obj2.handleCall();
        obj2.PrintParent();

    }
}
