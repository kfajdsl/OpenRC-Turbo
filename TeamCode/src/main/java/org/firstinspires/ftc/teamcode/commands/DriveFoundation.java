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
    static final double WHEEL_DIAMETER = 99.822;    // in mm
    static final double ROBOT_LENGTH = 434.34;     // in mm



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
        drive.setPower(0,0,0,0);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    private void driveToFoundation(String mode){
        double dist = (1200.2 - ROBOT_LENGTH);
        double distPerRev = WHEEL_DIAMETER * Math.PI;
        double ticksToFoundation = (dist / distPerRev) * TICKSPERREVOLUTION;
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