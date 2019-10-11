package org.firstinspires.ftc.teamcode.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Grabber implements Subsystem {

    private HardwareMap hardwareMap;
    private DcMotor grabber;

    private GrabberState grabberState = GrabberState.OFF;

    public Grabber(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public enum GrabberState{
        DOWN(1),
        OFF(0),
        UP(-1);

        private final double grabberPower;
        GrabberState(double grabberPower){
            this.grabberPower = grabberPower;
        }

    }


    public void setGrabberState(GrabberState grabberState){
        this.grabberState = grabberState;

    }



    @Override
    public void initHardware() {
        this.grabber = hardwareMap.get(DcMotor.class, "grabber");
    }

    @Override
    public void periodic() {
        grabber.setPower(grabberState.grabberPower);
    }
}
