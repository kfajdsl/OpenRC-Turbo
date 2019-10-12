package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecommander.DogeCommander;
import com.disnodeteam.dogecommander.DogeOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.commands.DriveFoundation;
import org.firstinspires.ftc.teamcode.commands.GrabberAuto;
import org.firstinspires.ftc.teamcode.commands.StrafeToPosition;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Grabber;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class CommanderAutonomous extends LinearOpMode implements DogeOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DogeCommander dogeCommander = new DogeCommander(this);

        Intake intake = new Intake(hardwareMap);
        Grabber grabber = new Grabber(hardwareMap);
        Drive drive = new Drive(hardwareMap);



        dogeCommander.runCommand(new DriveFoundation(drive, "to"));
        dogeCommander.runCommand(new GrabberAuto(grabber, Grabber.GrabberState.DOWN));
        dogeCommander.runCommand(new DriveFoundation(drive, "from"));
        dogeCommander.runCommand(new GrabberAuto(grabber, Grabber.GrabberState.OFF));
        dogeCommander.runCommand(new StrafeToPosition(drive));



    }
}
