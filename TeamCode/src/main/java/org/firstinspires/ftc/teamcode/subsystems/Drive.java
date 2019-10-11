package org.firstinspires.ftc.teamcode.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive implements Subsystem {

    private HardwareMap hardwareMap;

    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;
    private DcMotor leftBackMotor;
    private DcMotor rightBackMotor;

    private double leftFrontPower = 0;
    private double rightFrontPower = 0;
    private double leftBackPower = 0;
    private double rightBackPower = 0;

    public Drive(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public void setPower(double leftFrontPower, double rightFrontPower, double leftBackPower, double rightBackPower) {
        this.leftFrontPower = leftFrontPower;
        this.rightFrontPower = rightFrontPower;
        this.rightBackPower = rightBackPower;
        this.leftBackPower = leftBackPower;
    }

    @Override
    public void initHardware() {
        leftFrontMotor = hardwareMap.get(DcMotor.class, "LFM");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "RFM");
        leftBackMotor = hardwareMap.get(DcMotor.class, "LFM");
        rightBackMotor = hardwareMap.get(DcMotor.class, "RFM");

        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void periodic() {
        leftFrontMotor.setPower(leftFrontPower);
        rightFrontMotor.setPower(rightFrontPower);
        leftBackMotor.setPower(leftBackPower);
        rightBackMotor.setPower(rightBackPower);
    }
}
