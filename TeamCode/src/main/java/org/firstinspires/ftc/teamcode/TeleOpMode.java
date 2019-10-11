package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecommander.DogeCommander;
import com.disnodeteam.dogecommander.DogeOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.TeleOpDrive;
import org.firstinspires.ftc.teamcode.commands.TeleOpIntake;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@TeleOp(name = "Actual working black team code for the first time in a year")
public class TeleOpMode extends LinearOpMode implements DogeOpMode {

    @Override
    public void runOpMode() {
        DogeCommander commander = new DogeCommander(this);

        Intake intake = new Intake(hardwareMap);
        Drive drive = new Drive(hardwareMap);

        commander.registerSubsystem(intake);
        commander.registerSubsystem(drive);
        commander.init();

        waitForStart();

        commander.runCommandsParallel(
                new TeleOpIntake(intake, gamepad1),
                new TeleOpDrive(drive, gamepad1)
        );

        commander.stop();
    }
}
