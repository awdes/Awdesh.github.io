package com.company;

/**
 * Created by awdesh on 10/29/15.
 */
public class Class3 extends Class2
{
    public static void main(String[] args)
    {
        test3();
    }

    public static void test3()
    {
        item1 = 5;
        item2 = 10;
        int sum = item1 + item2;
        System.out.println(sum);
        test2(sum);
        test1(--sum);
    }
}
