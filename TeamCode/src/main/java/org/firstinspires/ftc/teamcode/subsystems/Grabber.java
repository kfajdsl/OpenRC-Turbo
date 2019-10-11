package org.firstinspires.ftc.teamcode.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Grabber implements Subsystem {

    private HardwareMap hardwareMap;

    private DcMotor leftGrabber, rightGrabber;
    private double leftGrabberPower, rightGrabberPower;

    public Grabber(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }
    public void setPower(boolean power){
        if(power){
            this.leftGrabberPower = 1.0;
            this.rightGrabberPower = 1.0;
        } else {
            this.leftGrabberPower = 0;
            this.rightGrabberPower = 0;
        }
    }

    @Override
    public void initHardware() {
        leftGrabber.setDirection(DcMotor.Direction.REVERSE);
        rightGrabber.setDirection(DcMotor.Direction.FORWARD);

        leftGrabber = hardwareMap.get(DcMotor.class, "leftGrabber");
        rightGrabber = hardwareMap.get(DcMotor.class,"rightGrabber");

        leftGrabber.setPower(0);
        rightGrabber.setPower(0);
    }

    @Override
    public void periodic() {
        leftGrabber.setPower(leftGrabberPower);
        rightGrabber.setPower(rightGrabberPower);
    }
}
