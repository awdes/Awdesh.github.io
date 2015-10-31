package com.company;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by awdesh on 7/29/15.
 */
public abstract class Buttons implements ElevatorOperation
{
    ButtonControls bc;
    boolean isPressed;

    public Buttons(ButtonControls bc)
    {
        this.bc = bc;
    }

    public void setPressed(boolean isPressed)
    {
        this.isPressed = isPressed;
    }

    public boolean getIsPressed()
    {
        return isPressed;
    }

    public void Press(ButtonControls buttonControls)
    {
        setPressed(true);
        if(buttonControls.getValue() == up)
        {
            moveUp();
        }

        if(buttonControls.getValue() == up)
        {
            moveDown();
        }

        if(buttonControls.getValue() == emergency)
        {
            //stop elevators.
        }

    }

    public void ShowButtonLight ()
    {
        if(getIsPressed())
        {
            //Call Indicator class and Glow Light.
        }
        else
        {
            // Call Indicator class and Dim Light.
        }
    }
}
