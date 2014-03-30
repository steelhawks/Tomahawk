package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * Sample program to use NIVision to find rectangles in the scene that are
 * illuminated by a LED ring light (similar to the model from FIRSTChoice). The
 * camera sensitivity is set very low so as to only show light sources and
 * remove any distracting parts of the image.
 *
 * The CriteriaCollection is the set of criteria that is used to filter the set
 * of rectangles that are detected. In this example we're looking for rectangles
 * with a minimum width of 30 pixels and maximum of 400 pixels.
 *
 * The algorithm first does a color threshold operation that only takes objects
 * in the scene that have a bright green color component. Then a small object
 * filter removes small particles that might be caused by green reflection
 * scattered from other parts of the scene. Finally all particles are scored on
 * rectangularity, and aspect ratio, to determine if they are a target.
 *
 * Look in the VisionImages directory inside the project that is created for the
 * sample images.
 */
public class VisionSampleProject2014 extends SimpleRobot {

    DriverStation ds = DriverStation.getInstance();
    HotGoalVision hgv = new HotGoalVision();
    
//    Relay spike = new Relay(1);
    
    public void robotInit() {
        hgv.init();
    }

    public void autonomous() {
        boolean foundIt = false;

        while (isAutonomous() && isEnabled()) {
            if (!foundIt) {
                System.out.println("match time: " + ds.getMatchTime());
                if (hgv.checkVision() && !foundIt) {
                    System.out.println("Shoot the ball!");
                    foundIt = true;
                    System.out.println("match time: " + ds.getMatchTime());
                } else {
                    System.out.println("Not hot... wait 1 sec");
                    Timer.delay(1);
                }
            }

        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        // TESTING DriverStation class
        if (ds.isAutonomous()) {
            System.out.println("In auton");
        }
        if (ds.getAlliance() == DriverStation.Alliance.kBlue) {
            System.out.println("Blue alliance");
        } else {
            System.out.println("Red Alliance");
        }

        while (isOperatorControl() && isEnabled()) {
            
            /*  spike relay doesn't work!!!
            System.out.println("set forward");
            spike.setDirection(Relay.Direction.kForward);
            Timer.delay(1);
            System.out.println("Set reverse");
            spike.setDirection(Relay.Direction.kReverse);
            Timer.delay(1);
            System.out.println("Set both");
            spike.setDirection(Relay.Direction.kBoth);
            Timer.delay(1);
                    */
        }
    }

}
