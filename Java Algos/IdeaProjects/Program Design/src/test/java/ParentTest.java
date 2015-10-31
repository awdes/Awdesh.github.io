import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by awdesh on 4/4/15.
 */

//@PrepareForTest(Parent.class)
class ParentTest {

//    public ParentTest()
//    {
//        //
//    }

    @Test
    public void testPrint()
    {
        Parent pInstance = Mockito.mock(Parent.class);
//        when(pInstance.PrintParent()).thenReturn()
//        Mockito.doCallRealMethod().when(pInstance).PrintParent();
        pInstance.PrintParent();
        verify(pInstance, times(1)).PrintParent();
        assert(true);
    }

    @Test
    public void testMultiply()
    {
        Parent pInstance = PowerMockito.mock(Parent.class);
        PowerMockito.when(pInstance.Multiply(2,5)).thenReturn(10);
        Assert.assertEquals(10, pInstance.Multiply(2,5));
    }

}
