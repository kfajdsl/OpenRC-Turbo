package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.drive.Drive;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ArmGrab;
import org.firstinspires.ftc.teamcode.subsystems.FGrabber;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.drive.DriveAuto;
import org.firstinspires.ftc.teamcode.subsystems.drive.DriveTeleOp;

import java.util.List;

public class Robot {

    private OpMode opMode;

    Gamepad gamepad;
    HardwareMap hardwareMap;
    DriveTeleOp driveTeleOp;
    Intake intake;
    FGrabber fGrabber;
    ArmGrab armGrab;
    Arm arm;

    public Robot(OpMode opMode) {
        this.opMode = opMode;
    }

    public void init(){

        hardwareMap = opMode.hardwareMap;
        gamepad = opMode.gamepad1;
        driveTeleOp = new DriveTeleOp(hardwareMap);
        intake = new Intake(hardwareMap);
        fGrabber = new FGrabber();
        armGrab = new ArmGrab();
        arm = new Arm(hardwareMap);


        arm.init();
        armGrab.init();
        fGrabber.init();
        intake.init();
        driveTeleOp.init();

    }
    public void loop(){
        arm.loop();
        arm.setPower(gamepad.dpad_down);
        armGrab.loop();
        fGrabber.loop();
        intake.loop();
        driveTeleOp.loop(gamepad);

    }

    public void autoInit(){
        DriveAuto driveAuto = new DriveAuto() {
            @Override
            public PIDCoefficients getPIDCoefficients(DcMotor.RunMode runMode) {
                return null;
            }

            @Override
            public void setPIDCoefficients(DcMotor.RunMode runMode, PIDCoefficients coefficients) {

            }

            @Override
            public void setMotorPowers(double v, double v1, double v2, double v3) {

            }

            @Override
            public List<Double> getWheelPositions() {
                return null;
            }

            @Override
            protected double getRawExternalHeading() {
                return 0;
            }
        };
    }

    public void autoLoop(){
        intake.setIntake(Intake.State.INTAKE);
    }
}
