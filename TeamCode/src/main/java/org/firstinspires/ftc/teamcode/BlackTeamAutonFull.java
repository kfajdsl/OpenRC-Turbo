package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "BlackTeamAutonFull")
public class BlackTeamAutonFull extends LinearOpMode {

    static final double TICKSPERREVOLUTION  = 95.5;      // drive motors
    static final double AUTO_DURATION = 30.0;    // in seconds
    static final double WHEEL_DIAMETER = 3.93;    // in inches
    static final double ROBOT_LENGTH = 17.1;     // in inches
    private DcMotor leftFront, rightFront, leftBack, rightBack;

    @Override
    public void runOpMode() throws InterruptedException {
        // establish motors
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");

        waitForStart(); // wait for game to begin
    }

    public void driveToFoundation() {
        double dist = (47.24 - ROBOT_LENGTH); // distance to foundation

// calculate total ticks to the edge of the platform
        double distPerRev = WHEEL_DIAMETER * Math.PI;
        double ticksToEdge = dist / distPerRev * TICKSPERREVOLUTION;

// drive to position, then stop
        driveFromFoundation((int)Math.ceil(ticksToEdge));
    }

    public void driveFromFoundation() {
        // calculate total ticks
        double distPerRev = WHEEL_DIAMETER * Math.PI;
        double totalTicks = ROBOT_LENGTH / distPerRev * TICKSPERREVOLUTION;

        // drive to position, then stop
        driveToPosit((int) Math.ceil(totalTicks));
    }


    // code
}