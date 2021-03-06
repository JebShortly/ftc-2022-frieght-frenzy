package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="JoystickDrive", group="Linear Opmode")
//@Disabled
public class JoystickDrive extends OpMode {
    MyHardwareV2 robot = new MyHardwareV2();

    double RFpower = 0;
    double RBpower = 0;
    double LFpower = 0;
    double LBpower = 0;
    double IntakePower = 0;
    double PulleyPower = 0;
    double DuckPower = 0;
    double ArmPower = 0;

    int ticks = 0;

    @Override
    public void init() {
        robot.initialize(hardwareMap);
        robot.PulleyMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.PulleyMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void loop() {
        ticks = robot.PulleyMotor.getCurrentPosition();
        tankDrive(0.5);
        intake(0.6);
        pulley(0.8, 0.4);
        bucket();
        turnCarousel(0.85);
        moveArm(0.2);
    }

    public void tankDrive(double drivePow){
        //double rightXAxis = gamepad1.right_stick_x;
        double rightYAxis = gamepad1.right_stick_y;
        //double leftXAxis = gamepad1.left_stick_x;
        double leftYAxis = gamepad1.left_stick_y;



        if(gamepad1.dpad_up){
            RFpower = drivePow;
            RBpower = drivePow;
            LFpower = drivePow;
            LBpower = drivePow;
        }
        else if(gamepad1.dpad_down){
            RFpower = -drivePow;
            RBpower = -drivePow;
            LFpower = -drivePow;
            LBpower = -drivePow;
        }
        else if(gamepad1.dpad_right){
            RFpower = -drivePow;
            RBpower = drivePow;
            LFpower = drivePow;
            LBpower = -drivePow;
        }
        else if(gamepad1.dpad_left){
            RFpower = drivePow;
            RBpower = -drivePow;
            LFpower = -drivePow;
            LBpower = drivePow;
        }
        else {
            RFpower = -rightYAxis;
            RBpower = -rightYAxis;
            LFpower = -leftYAxis;
            LBpower = -leftYAxis;
        }

        RFpower = RFpower - rightYAxis;
        RBpower = RBpower - rightYAxis;
        LFpower = LFpower - leftYAxis;
        LBpower = LBpower - leftYAxis;

        robot.RFMotor.setPower(RFpower);
        robot.RBMotor.setPower(RBpower);
        robot.LFMotor.setPower(LFpower);
        robot.LBMotor.setPower(LBpower);
    }

    public void intake(double turningPower){
        if(gamepad1.b){
            IntakePower = turningPower;
        } else if(gamepad1.left_bumper){
            IntakePower = -turningPower;
        } else {
            IntakePower = 0;
        }

        robot.IntakeMotor.setPower(IntakePower);
    }

    public void pulley(double powerGoingUp, double powerGoingDown){

        if(gamepad1.y){
            PulleyPower = powerGoingUp;
        } else if(gamepad1.a){
            PulleyPower = -powerGoingDown;
        } else {
            PulleyPower = 0;
        }

        robot.PulleyMotor.setPower(PulleyPower);
    }

    public void bucket(){
        telemetry.addData("ticks:",ticks);
        if(gamepad1.x){
            robot.BucketServo.setPosition(0.6);
        } else if (ticks > 500){
            robot.BucketServo.setPosition(0.86);
        } else {
            robot.BucketServo.setPosition(1);

        }
    }

    public void turnCarousel(double turningPower){
        if(gamepad1.left_trigger > 0.8){
            DuckPower = turningPower;
        } else if (gamepad1.left_bumper){
            DuckPower = -turningPower;
        } else {
            DuckPower = 0;
        }

        robot.DuckMotor.setPower(DuckPower);
    }

//    public void moveArm(double turningPower){
//        if(gamepad1.right_trigger > 0.8){
//            ArmPower = turningPower;
//        } else if (gamepad1.right_bumper){
//            ArmPower = -turningPower;
//        } else {
//            ArmPower = 0;
//        }
//
//        robot.ArmMotor.setPower(ArmPower);
//    }

    public void moveArm(double turningPower){
        int ticks = robot.ArmMotor.getCurrentPosition();

        if(gamepad1.right_trigger > 0.8){
            robot.ArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.ArmMotor.setPower(turningPower);
        } else if(gamepad1.right_bumper){
            robot.ArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.ArmMotor.setPower(-turningPower - 0.05);
        } else {
            robot.ArmMotor.setTargetPosition(ticks);
            robot.ArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }
}
