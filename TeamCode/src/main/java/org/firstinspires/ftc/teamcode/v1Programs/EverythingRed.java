package org.firstinspires.ftc.teamcode.v1Programs;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MyHardwareV2;
@Disabled
@Autonomous(name = "EverythingRed", group="Everything")
public class EverythingRed extends LinearOpMode {

    //Creates new instance of HardwareMap
    MyHardwareV2 robot = new MyHardwareV2();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initialize(hardwareMap); //Initializes all of the hardware for use

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        strafeLeft(-0.5, 200);
        stopDriving(500);
        driveForward(0.5, 500);
        driveForward(0.05, 500);
        turnCarousel(-0.6, 4000);
        strafeRight(0.5, 1400);
        stopDriving(500);
        driveForward(-0.5, 600);
        stopDriving(10);
        movePulley(0.8, 1100);
        movePulley(0, 500);
        moveBucket(0.6, 2000);
        moveBucket(1, 500);
        movePulley(-0.4, 1200);
        movePulley(0, 10);
        driveForward(0.5, 900);
        stopDriving(500);
        strafeLeft(0.5, 500);

        stopDriving();
    }

    public void movePulley(double power, double milliseconds) {
        robot.PulleyMotor.setPower(power);

        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive() && (runtime.milliseconds() < milliseconds)) {

        }
    }

    public void moveBucket(double position, double milliseconds) {
        robot.BucketServo.setPosition(position);

        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive() && (runtime.milliseconds() < milliseconds)) {

        }
    }

    public void weirdMovement(double RF, double RB, double LF, double LB, int milliseconds) {
        robot.RFMotor.setPower(RF);
        robot.RBMotor.setPower(RB);
        robot.LFMotor.setPower(LF);
        robot.LBMotor.setPower(LB);

        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive() && (runtime.milliseconds() < milliseconds)) {

        }
    }

    public void driveForward(double power, int milliseconds) {
        robot.RFMotor.setPower(power);
        robot.RBMotor.setPower(power);
        robot.LFMotor.setPower(power);
        robot.LBMotor.setPower(power);

        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive() && (runtime.milliseconds() < milliseconds)) {

        }
    }

    public void strafeRight(double power, int milliseconds) {
        robot.RFMotor.setPower(-power);
        robot.RBMotor.setPower(power);
        robot.LFMotor.setPower(power);
        robot.LBMotor.setPower(-power);

        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive() && (runtime.milliseconds() < milliseconds)) {

        }
    }

    public void strafeLeft(double power, int milliseconds) {
        robot.RFMotor.setPower(power);
        robot.RBMotor.setPower(-power);
        robot.LFMotor.setPower(-power);
        robot.LBMotor.setPower(power);

        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive() && (runtime.milliseconds() < milliseconds)) {

        }
    }

    public void stopDriving() {
        robot.RFMotor.setPower(0);
        robot.RBMotor.setPower(0);
        robot.LFMotor.setPower(0);
        robot.LBMotor.setPower(0);
    }

    public void stopDriving(double milliseconds) {
        robot.RFMotor.setPower(0);
        robot.RBMotor.setPower(0);
        robot.LFMotor.setPower(0);
        robot.LBMotor.setPower(0);

        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive() && (runtime.milliseconds() < milliseconds)) {

        }
    }

    public void turnCarousel(double turningPower, int milliseconds) {
        robot.DuckMotor.setPower(turningPower);

        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive() && (runtime.milliseconds() < milliseconds)) {

        }
    }
}
