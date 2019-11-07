package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {


    private double armPower;
    private HardwareMap hardwareMap;
    private DcMotor arm;

    public Arm(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public void init() {
        arm = hardwareMap.get(DcMotor.class, "arm");
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void loop() {
        arm.setPower(armPower);
    }

    public void setPower(boolean power){
        if (power){
            armPower = 1;
        } else {
            armPower = 0;
        }


    }
}
