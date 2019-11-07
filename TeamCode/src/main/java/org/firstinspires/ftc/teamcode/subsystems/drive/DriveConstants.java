package org.firstinspires.ftc.teamcode.subsystems.drive;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints;
import com.qualcomm.hardware.motors.NeveRest20Gearmotor;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

@Config
public class DriveConstants {


    private static final MotorConfigurationType MOTOR_CONFIG =
            MotorConfigurationType.getMotorType(NeveRest20Gearmotor.class);
    private static final double TICKS_PER_REV = MOTOR_CONFIG.getTicksPerRev();

    public static double WHEEL_RADIUS = 2;
    public static double GEAR_RATIO = 1; // output (wheel) speed / input (motor) speed
    public static double TRACK_WIDTH = 1;


    public static double kV = 1.0 / rpmToVelocity(getMaxRpm());
    public static double kA = 0;
    public static double kStatic = 0;

    public static DriveConstraints BASE_CONSTRAINTS = new DriveConstraints(
            30.0, 30.0, 0.0,
            Math.toRadians(180.0), Math.toRadians(180.0), 0.0
    );


    public static double encoderTicksToInches(int ticks) {
        return WHEEL_RADIUS * 2 * Math.PI * GEAR_RATIO * ticks / TICKS_PER_REV;
    }

    public static double rpmToVelocity(double rpm) {
        return rpm * GEAR_RATIO * 2 * Math.PI * WHEEL_RADIUS / 60.0;
    }

    public static double getMaxRpm() {
        return MOTOR_CONFIG.getMaxRPM();
    }
}