package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by aryand2799 on 11/4/2016.
 */
public class HardwareConfig9837 {

    /**
     * This is NOT an opmode.
     *
     * This class can be used to define all the specific hardware for a single robot.
     * In this case that robot is a Pushbot.
     * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
     *
     * This hardware class assumes the following device names have been configured on the robot:
     * Note:  All names are lower case and some have single spaces between words.
     *
     * Motor channel:  Left  drive motor:        "left_drive"
     * Motor channel:  Right drive motor:        "right_drive"
     * Motor channel:  Manipulator drive motor:  "left_arm"
     * Servo channel:  Servo to open left claw:  "left_hand"
     * Servo channel:  Servo to open right claw: "right_hand"
     */

        /* Public OpMode members. */
        public DcMotor leftFrontMotor   = null;
        public DcMotor leftBackMotor = null;
        public DcMotor rightFrontMotor = null;
        public DcMotor  rightBackMotor  = null;
        public LightSensor lightSensor = null;
        public TouchSensor touchSensor = null;
        public DcMotor spool = null;
        public DcMotor claw = null;
        //public DcMotor  armMotor    = null;
        //public Servo leftClaw    = null;
        //public Servo    rightClaw   = null;

        //public static final double MID_SERVO       =  0.5 ;
        //public static final double ARM_UP_POWER    =  0.45 ;
        //public static final double ARM_DOWN_POWER  = -0.45 ;

        /* local OpMode members. */
        HardwareMap hwMap           =  null;
        private ElapsedTime period  = new ElapsedTime();

        /* Constructor */
        public HardwareConfig9837(){

        }

        /* Initialize standard Hardware interfaces */
        public void init(HardwareMap ahwMap) {
            // Save reference to Hardware map
            hwMap = ahwMap;

            // Define and Initialize Motors
            leftFrontMotor   = hwMap.dcMotor.get("left_front");
            leftBackMotor = hwMap.dcMotor.get("left_back");
            rightFrontMotor  = hwMap.dcMotor.get("right_front");
            rightBackMotor  = hwMap.dcMotor.get("right_back");
            spool = hwMap.dcMotor.get("spool");
            claw = hwMap.dcMotor.get("claw");
            //armMotor    = hwMap.dcMotor.get("left_arm");
            leftFrontMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
            leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
            rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
            rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
            spool.setDirection(DcMotor.Direction.FORWARD);
            claw.setDirection(DcMotor.Direction.FORWARD);

            // Set all motors to zero power
            leftFrontMotor.setPower(0);
            leftBackMotor.setPower(0);
            rightFrontMotor.setPower(0);
            rightBackMotor.setPower(0);
            spool.setPower(0);
            claw.setPower(0);
            //armMotor.setPower(0);

            // Set all motors to run with encoders.
            leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            // Define and initialize ALL installed servos.
            /*leftClaw = hwMap.servo.get("left_hand");
            rightClaw = hwMap.servo.get("right_hand");
            leftClaw.setPosition(MID_SERVO);
            rightClaw.setPosition(MID_SERVO); */

            //Define and Initialize Sensors
            lightSensor = hwMap.lightSensor.get("light_sensor");
            touchSensor = hwMap.touchSensor.get("touch_sensor");

            //Turn on LED of light sensor
            lightSensor.enableLed(true);
        }

        public void moveFwd (double power) {
            leftFrontMotor.setPower(power);
            leftBackMotor.setPower(power);
            rightFrontMotor.setPower(power);
            rightBackMotor.setPower(power);
        }

        public void stop() {
            leftFrontMotor.setPower(0);
            leftBackMotor.setPower(0);
            rightFrontMotor.setPower(0);
            rightBackMotor.setPower(0);
        }

        public void pointTurnRight(double power) {
            leftFrontMotor.setPower(0);
            leftBackMotor.setPower(0);
            rightFrontMotor.setPower(power);
            rightBackMotor.setPower(power);
        }

        public void pointTurnLeft (double power) {
            leftFrontMotor.setPower(power);
            leftBackMotor.setPower(power);
            rightFrontMotor.setPower(0);
            rightBackMotor.setPower(0);
        }

        public void swingTurnRight (double power) {
            leftFrontMotor.setPower(-power);
            leftBackMotor.setPower(-power);
            rightFrontMotor.setPower(power);
            rightBackMotor.setPower(power);
        }

        public void swingTurnLeft (double power) {
            leftFrontMotor.setPower(power);
            leftBackMotor.setPower(power);
            rightFrontMotor.setPower(-power);
            rightBackMotor.setPower(-power);
        }

        /***
         *
         * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
         * periodic tick.  This is used to compensate for varying processing times for each cycle.
         * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
         *
         * @param periodMs  Length of wait cycle in mSec.
         */
        public void waitForTick(long periodMs) {

            long  remaining = periodMs - (long)period.milliseconds();

            // sleep for the remaining portion of the regular cycle period.
            if (remaining > 0) {
                try {
                    Thread.sleep(remaining);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Reset the cycle clock for the next pass.
            period.reset();
        }
    }


