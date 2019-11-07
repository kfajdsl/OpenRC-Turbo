package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Intake {

    private CRServo left, right;
    private double leftPower, rightPower;
    private HardwareMap hardwareMap;

    public Intake(HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
    }

    public enum State {
        INTAKE,
        OUTTAKE,
        OFF
    }

    public void init() {
        left = hardwareMap.get(CRServo.class, "left");
        right = hardwareMap.get(CRServo.class, "right");
        right.setDirection(CRServo.Direction.REVERSE);
    }

    public void loop() {
        left.setPower(leftPower);
        right.setPower(rightPower);
    }

    public void setIntake(State state) {
        switch (state) {
            case OFF:
                leftPower = 0.0;
                rightPower = 0.0;
                break;
            case INTAKE:
                leftPower = -1.0;
                rightPower = -1.0;
                break;
            case OUTTAKE:
                leftPower = 1.0;
                rightPower = 1.0;
                break;
        }
    }
}
