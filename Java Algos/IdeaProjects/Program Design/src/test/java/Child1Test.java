import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


/**
 * Created by awdesh on 4/5/15.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Child1.class)
public class Child1Test {

    @Test
    public void Sumtest()
    {
        Child1 c = new Child1();
        int val = c.Sum(2,5);
        Assert.assertEquals(7, val);
    }

    /*
    Testing private methods using reflection.
     */
    @Test
    public void IsDivisibleTest() throws IllegalAccessException
    {
        Child1 cls = new Child1();
        try
        {
            Class[] cArg = new Class[1];
            cArg[0] = Integer.class;
            Method method = Child1.class.getDeclaredMethod("IsDivisibleByTwo", cArg);
            method.setAccessible(true);
            boolean returnVal = (Boolean)method.invoke(cls, 5);
            Assert.assertEquals(false, returnVal);
        }
        catch (NoSuchMethodException ex)
        {
            System.out.println(ex.toString());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void IsDivisibleTestWithPowerMock()
    {
//        Child1 obj = PowerMock.createPartialMock(Child1.class, "IsDivisibleByTwo");
//        PowerMock.expectPrivate(obj, "IsDivisibleByTwo", 7).andReturn(false);
    }

}
