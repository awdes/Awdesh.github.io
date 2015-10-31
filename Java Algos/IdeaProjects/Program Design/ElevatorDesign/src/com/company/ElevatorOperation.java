package com.company;

/**
 * Created by awdesh on 7/29/15.
 */
public interface ElevatorOperation
{
    void moveUp();

    void moveDown();

    void openDoor();

    void closeDoor();

    void playOpenSound();

    void playCloseSound();

    void showMoveIndicator();
}
