package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class FGrabber extends OpMode {

    private Servo left, right;

    @Override
    public void init() {
        left = hardwareMap.get(Servo.class, "lgrab");
        right = hardwareMap.get(Servo.class, "rgrab");
    }

    @Override
    public void loop() {
        if (gamepad1.b){
            left.setPosition(0);
            right.setPosition(0);
        }
        if (gamepad1.x){
            left.setPosition(180);
            right.setPosition(180);
        }
    }
}
