package com.company;

/**
 * Created by awdesh on 7/29/15.
 */
public class OutsideElevatorControls
{
    ButtonControls up;
    ButtonControls down;
    ButtonControls Emergency;
    ButtonControls buttonControls;

    /**
     *
     * @param bc
     */
    public OutsideElevatorControls(ButtonControls bc)
    {
        this.buttonControls = bc;
    }

    /**
     *
     */
    public void pressButton()
    {
        Buttons buttons = new Buttons(buttonControls.getValue(1);
        buttons.Press();
    }
}
