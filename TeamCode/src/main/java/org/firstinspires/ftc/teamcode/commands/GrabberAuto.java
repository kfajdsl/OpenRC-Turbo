package org.firstinspires.ftc.teamcode.commands;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Grabber;

public class GrabberAuto implements Command {

    private Grabber grabber;
    private Grabber.GrabberState state;


    public GrabberAuto(Grabber grabber, Grabber.GrabberState state){

        this.grabber = grabber;
        this.state = state;

    }

    @Override
    public void start() {
        grabber.setGrabberState(state);
    }


    @Override
    public void periodic() {

    }

    @Override
    public void stop() {
        grabber.setGrabberState(Grabber.GrabberState.OFF);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
