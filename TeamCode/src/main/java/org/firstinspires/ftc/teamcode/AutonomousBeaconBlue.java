package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by aryand2799 on 11/4/2016.
 */

@Autonomous(name="AutonomousBeaconBlue", group="Pushbot")
//@Disabled

public class AutonomousBeaconBlue extends OpMode{

    //This file drives the robot so that it approaches the white line from the right (blue side)
    //Once it detects the white line, the robot will follow it to the wall using a light sensor.
    //A touch sensor will detect when the robot hits the wall and will stop the robot.

        /* Declare OpMode members. */
        HardwareConfig9837 robot       = new HardwareConfig9837(); // use the class created to define a Pushbot's hardware
        // could also use HardwarePushbotMatrix class.

        final double THRESHOLD = 2.28;

        /*
         * Code to run ONCE when the driver hits INIT
         */
        @Override
        public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
            robot.init(hardwareMap);

            // Send telemetry message to signify robot waiting;
            telemetry.addData("Say", "Hello Driver");    //
        }

        /*
         * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
         */
        @Override
        public void init_loop() {
        }

        /*
         * Code to run ONCE when the driver hits PLAY
         */
        //WHITE RAW VALUE: 2.70
        //GRAY RAW VALUE: 1.77
        /*@Override
        public void start() {
            while (robot.lightSensor.getRawLightDetected() < THRESHOLD) {
                robot.moveFwd(0.2);
            }
            robot.stop();
            robot.waitForTick(2000);


            while (robot.touchSensor.isPressed() == false) {
                telemetry.addData("Sensor reading", "%.2f", robot.lightSensor.getRawLightDetected());
                telemetry.update();
                for (int i = 0; i < 4; i++) {
                    if (robot.lightSensor.getRawLightDetected() > THRESHOLD) {
                        while (robot.lightSensor.getRawLightDetected() > THRESHOLD) {
                            robot.pointTurnRight(0.1);
                        }
                    } else {
                        while (robot.lightSensor.getRawLightDetected() < THRESHOLD) {
                            robot.pointTurnLeft(0.1);
                        }
                    }
                }
                if (robot.lightSensor.getRawLightDetected() > THRESHOLD) {
                    while (robot.lightSensor.getRawLightDetected() > THRESHOLD) {
                        robot.swingTurnRight(0.1);
                    }
                } else {
                    while (robot.lightSensor.getRawLightDetected() < THRESHOLD) {
                        robot.swingTurnLeft(0.1);
                    }
                }
            }
            robot.stop();
        }

        /*
         * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
         */
        @Override
        public void loop() {
        }

        /*
         * Code to run ONCE after the driver hits STOP
         */
        @Override
        public void stop() {
        }

    }
