package org.firstinspires.ftc.teamcode.commands;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Grabber;

public class DriveFoundation implements Command {
    private Drive drive;
    private String mode;


    static final double TICKSPERREVOLUTION  = 95.5;      // drive motors
    static final double AUTO_DURATION = 30.0;    // in seconds
    static final double WHEEL_DIAMETER = 3.93;    // in inches
    static final double ROBOT_LENGTH = 17.1;     // in inches



    public DriveFoundation(Drive drive, String mode){
        this.drive = drive;
        this.mode = mode;
    }

    @Override
    public void start() {
        driveToFoundation(mode);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    public void driveToFoundation(String mode){
        double dist = (47.24 - ROBOT_LENGTH);
        double distPerRev = WHEEL_DIAMETER * Math.PI;
        double ticksToFoundation = dist / distPerRev * TICKSPERREVOLUTION;
        if (mode.equals("to")){
            driveToPosit((int)Math.ceil(ticksToFoundation));
        } else if(mode.equals("from")){
            driveToPosit(-((int)Math.ceil(ticksToFoundation)));
        }

    }

    private void driveToPosit(int ticks){
        drive.setTarget(ticks, -ticks);
        drive.setMode(DcMotor.RunMode.RUN_TO_POSITION, DcMotor.RunMode.RUN_TO_POSITION);
        drive.setPower(.25,.25,.25,.25);
    }




}
