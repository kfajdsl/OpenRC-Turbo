package org.firstinspires.ftc.teamcode.commands;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.Intake;


public class TeleOpIntake implements Command {

    private Intake intake;
    private Gamepad gamepad;

    public TeleOpIntake(Intake intake, Gamepad gamepad) {
        this.intake = intake;
        this.gamepad = gamepad;
    }

    @Override
    public void start() {
        intake.setState(Intake.State.STOP);
    }

    @Override
    public void periodic() {
        if (gamepad.right_bumper) {
            intake.setState(Intake.State.INTAKE);
        } else {
            intake.setState(Intake.State.STOP);
        }
    }

    @Override
    public void stop() {
        intake.setState(Intake.State.STOP);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}