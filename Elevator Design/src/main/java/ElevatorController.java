import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by AS025782 on 9/23/2015.
 */
public abstract class ElevatorController
{
    protected Queue requests = new LinkedList();
    public ElevatorController(Elevator req)
    {
        requests.add(req);
    }

    protected abstract void startElevator();

    protected abstract void shutDownElevator();
}
