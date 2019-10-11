package org.firstinspires.ftc.teamcode.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake implements Subsystem {

    private HardwareMap hardwareMap;
    private State state;
    private CRServo intakeLeftServo, intakeRightServo;

    public Intake(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public enum State {
        INTAKE(1.0),
        STOP(0.0);

        private final double power;

        State(double power) {
            this.power = power;
        }
    }


    public void setState(State state) {
        this.state = state;
    }

    public void initHardware() {

        state = State.STOP;

        intakeLeftServo = hardwareMap.get(CRServo.class, "intakeLeftServo");
        intakeRightServo = hardwareMap.get(CRServo.class, "intakeRightServo");

        intakeLeftServo.setDirection(CRServo.Direction.FORWARD);
        intakeRightServo.setDirection(CRServo.Direction.REVERSE);
    }

    @Override
    public void periodic() {
        intakeLeftServo.setPower(state.power);
        intakeRightServo.setPower(state.power);

    }
}
