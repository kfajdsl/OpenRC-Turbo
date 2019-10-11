package org.firstinspires.ftc.teamcode.commands;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Grabber;

public class GrabberForTime implements Command {

    private ElapsedTime timer;
    private Grabber grabber;

    private double secondsToGrab;
    private Grabber.GrabberState state;


    public GrabberForTime(Grabber grabber, double secondsToGrab, Grabber.GrabberState state){

        timer = new ElapsedTime();
        this.grabber = grabber;
        this.secondsToGrab = secondsToGrab;
        this.state = state;

    }

    @Override
    public void start() {
        timer.reset();
    }


    @Override
    public void periodic() {
        if(timer.seconds() == secondsToGrab) {
            grabber.setGrabberState(Grabber.GrabberState.DOWN);
            grabber.setGrabberState(Grabber.GrabberState.OFF);
        } else if(timer.seconds() < seconds){
            grabber.setGrabberState(Grabber.GrabberState.OFF);
        } else if(timer.seconds() > seconds){

        }
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
