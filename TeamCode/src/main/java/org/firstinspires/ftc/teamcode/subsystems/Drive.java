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

    private double leftFrontPower;
    private double rightFrontPower;
    private double leftBackPower;
    private double rightBackPower;

    private int positionRight;
    private int positionLeft;

    private DcMotor.RunMode runModeLeft;
    private DcMotor.RunMode runModeRight;




    public Drive(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public void setPower(double leftFrontPower, double rightFrontPower, double leftBackPower, double rightBackPower) {
        this.leftFrontPower = leftFrontPower;
        this.rightFrontPower = rightFrontPower;
        this.rightBackPower = rightBackPower;
        this.leftBackPower = leftBackPower;
    }

    public void setMode(DcMotor.RunMode runModeLeft, DcMotor.RunMode runModeRight){
        this.runModeLeft = runModeLeft;
        this.runModeRight = runModeRight;
    }

    public void setTarget(int positionRight, int positionLeft){
        this.positionRight = positionRight;
        this.positionLeft = positionLeft;
    }


    @Override
    public void initHardware() {
        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");

        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);

        leftFrontPower = 0;
        rightFrontPower = 0;
        leftBackPower = 0;
        rightBackPower = 0;

        runModeRight = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
        runModeLeft = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
    }

    @Override
    public void periodic() {
        leftFrontMotor.setPower(leftFrontPower);
        rightFrontMotor.setPower(rightFrontPower);
        leftBackMotor.setPower(leftBackPower);
        rightBackMotor.setPower(rightBackPower);
    }


}
