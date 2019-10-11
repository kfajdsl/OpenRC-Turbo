package org.firstinspires.ftc.teamcode.commands;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.Drive;

public class TeleOpDrive implements Command {

    private Drive drive;
    private Gamepad gamepad;

    public TeleOpDrive(Drive drive, Gamepad gamepad) {
        this.drive = drive;
        this.gamepad = gamepad;
    }

    @Override
    public void start() {
        drive.setPower(0,0,0,0);
    }

    @Override
    public void periodic() {
        double speed = Math.hypot(gamepad.left_stick_x, gamepad.left_stick_y);
        double angle = Math.atan2(gamepad.left_stick_y, gamepad.left_stick_x) - Math.PI/4;
        double turn = gamepad.right_stick_x;

        final double leftFrontPower = speed * Math.sin(angle) + turn;
        final double rightFrontPower = speed * Math.cos(angle) - turn;
        final double leftBackPower = speed * Math.cos(angle) + turn;
        final double rightBackPower = speed * Math.sin(angle) - turn;

        drive.setPower(leftFrontPower, rightFrontPower, leftBackPower, rightBackPower);
    }

    @Override
    public void stop() {
        drive.setPower(0,0,0,0);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
