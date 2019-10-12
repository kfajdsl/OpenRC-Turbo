package org.firstinspires.ftc.teamcode.commands;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.Drive;

public class StrafeToPosition implements Command {

    private Drive drive;

    static final double distance = 152.4;
    static final double TICKSPERREVOLUTION  = 95.5;      // drive motors
    static final double AUTO_DURATION = 30.0;    // in seconds
    static final double WHEEL_DIAMETER = 99.822;    // in mm
    static final double ROBOT_LENGTH = 434.34;     // in mm



    public StrafeToPosition(Drive drive){
        this.drive = drive;
    }

    @Override
    public void start() {
        driveToEndPosition();
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

    public void driveToEndPosition(){
        double dist = (distance - ROBOT_LENGTH);
        double distPerRev = WHEEL_DIAMETER * Math.PI;
        double ticksToFoundation = (dist / distPerRev) * TICKSPERREVOLUTION;
        driveToPosit((int)Math.ceil(ticksToFoundation));
    }

    private void driveToPosit(int ticks){
        drive.setTarget(ticks, -ticks);
        drive.setMode(DcMotor.RunMode.RUN_TO_POSITION, DcMotor.RunMode.RUN_TO_POSITION);
        drive.setPower(.25,.25,.25,.25);
    }

}
