package org.firstinspires.ftc.teamcode.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Grabber implements Subsystem {

    private HardwareMap hardwareMap;
    private Servo leftServo, rightServo;

    private GrabberState grabberState = GrabberState.OFF;

    public Grabber(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public enum GrabberState{
        DOWN(1),
        OFF(0);

        private final double grabberState;
        GrabberState(double grabberState){
            this.grabberState = grabberState;
        }

    }


    public void setGrabberState(GrabberState grabberState){
        this.grabberState = grabberState;

    }



    @Override
    public void initHardware() {
        this.leftServo = hardwareMap.get(Servo.class, "lgrab");
        this.rightServo = hardwareMap.get(Servo.class, "rgrab");
    }

    @Override
    public void periodic() {
        leftServo.setPosition(grabberState.grabberState);
        rightServo.setPosition(grabberState.grabberState);
    }
}
