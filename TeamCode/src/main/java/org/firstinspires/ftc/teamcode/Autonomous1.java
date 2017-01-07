package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by aryand2799 on 12/9/2016.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous1", group="Pushbot")
//@Disabled

public class Autonomous1 extends LinearOpMode {

    //Description goes here

    /* Declare OpMode members. */
    HardwareConfig9837 robot = new HardwareConfig9837(); // use the class created to define a Pushbot's hardware
    // could also use HardwarePushbotMatrix class.

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //

        waitForStart();
        //robot.waitForTick(1000);
        telemetry.addData("Encoder reading 1", robot.leftBackMotor.getCurrentPosition());
        robot.moveFwd(0.25);
        robot.waitForTick(1000);
        robot.stop();
        telemetry.addData("Encoder reading 2", robot.leftBackMotor.getCurrentPosition());
        robot.waitForTick(1000);
        robot.swingTurnRight(0.25);
        robot.waitForTick(500);
        robot.stop();
        robot.waitForTick(1000);
        robot.moveFwd(0.25);
        robot.waitForTick(500);
        robot.stop();
    }
}