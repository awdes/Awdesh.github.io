import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by AS025782 on 9/23/2015.
 */
public class ElevatorController
{
    protected Queue requests = new LinkedList();

    public ElevatorController()
    {

    }


    /**
     *
     * @param req
     */
    protected void startElevator(int req)
    {
        requests.add(req);
    }

    protected void shutDownElevator()
    {

    }
}


