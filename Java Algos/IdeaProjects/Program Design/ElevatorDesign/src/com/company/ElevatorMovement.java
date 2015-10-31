package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by awdesh on 7/29/15.
 */
public abstract class ElevatorMovement implements ElevatorOperation
{
    static Queue q = new PriorityQueue();
    public ElevatorMovement()
    {

    }
    /**
     *
     */
    @Override
    public void moveDown()
    {

    }

    /**
     *
     */
    @Override
    public void moveUp()
    {
        q.add(Floor);
    }
}
