package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmGrab extends OpMode {

    Servo servo;

    @Override
    public void init() {
        hardwareMap.get(Servo.class, "clamp");
    }

    @Override
    public void loop() {
        if (gamepad2.dpad_down){
            servo.setPosition(180);
        }
        if (gamepad2.dpad_up){
            servo.setPosition(0);
        }
    }
}
