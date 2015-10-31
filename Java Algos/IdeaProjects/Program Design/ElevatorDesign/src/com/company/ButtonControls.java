package com.company;

/**
 * Created by awdesh on 7/29/15.
 */
public enum ButtonControls
{
    UP,
    DOWN,
    Emergency,
    Close,
    Open;

    private int value;

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
