package org.firstinspires.ftc.teamcode.v2Programs;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MyHardwareV2;

//@Disabled
@Autonomous(name = "StorageBlueV2", group="Storage")
public class StorageBlueV2 extends LinearOpMode {

    //Creates new instance of HardwareMap
    MyHardwareV2 robot = new MyHardwareV2();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initialize(hardwareMap); //Initializes all of the hardware for use

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        driveForward(-0.5, 100);
        stopDriving(300);
        turnCarousel(0.6, 10);
        strafeLeft(0.3, 4500);
        turnCarousel(0, 10);
        driveForward(-0.5, 700);
        stopDriving(500);
        strafeLeft(0.5, 400);

        stopDriving();
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
