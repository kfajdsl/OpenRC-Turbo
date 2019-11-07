package org.firstinspires.ftc.teamcode.subsystems.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;

@TeleOp(name = "drive")
public class DriveTeleOp {
    private HardwareMap hardwareMap;
    private DcMotor leftFront, rightFront, leftBack, rightBack;


    public DriveTeleOp(HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
    }


    public void init() {
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightBack = hardwareMap.get(DcMotor.class, "rb");
    }

    public void loop(Gamepad gamepad) {
        setPower(gamepad);
    }

    private void MecanumDrive(double speed, double direction, double rotation) {
        final double v1 = speed * Math.cos(direction) + rotation;
        final double v2 = speed * Math.sin(direction) - rotation;
        final double v3 = speed * Math.sin(direction) + rotation;
        final double v4 = speed * Math.cos(direction) - rotation;

        leftFront.setPower(v1);
        rightFront.setPower(v2);
        leftBack.setPower(v3);
        rightBack.setPower(v4);
    }


    private void setPower(Gamepad gamepad1){
        double speed = Math.hypot(gamepad1.right_stick_x, gamepad1.right_stick_y);
        double direction = Math.atan2(gamepad1.right_stick_y, -gamepad1.right_stick_x) - Math.PI / 4;
        MecanumDrive(speed, direction, gamepad1.right_stick_y);
    }

}
