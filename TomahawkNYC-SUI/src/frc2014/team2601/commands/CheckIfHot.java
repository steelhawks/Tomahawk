/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands;

import edu.wpi.first.wpilibj.Timer;
import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author steelhawks
 */
public class CheckIfHot extends CommandBase {

    final double CHECK_FREQUENCY = 0.5; // seconds delay between each check to not overload cRIO -- can move to Constants
    boolean isHot = false;

    public CheckIfHot(double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(hotgoal);
        hotgoal.init();
        setTimeout(timeout);       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //System.out.println("autonVision.execute" + timeSinceInitialized());
        isHot = hotgoal.checkHotGoal();
       
        if (!isHot) {
            //System.out.println("sleeping...");
            Timer.delay(CHECK_FREQUENCY);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        System.out.println("isHot: " + isHot + " Time: " + timeSinceInitialized());

/*        if (isHot) {
            System.out.println("hot hot hot - returning true");
            return true;
        } else {
            boolean t = isTimedOut();
            System.out.println("isTimedOut: " + t);
            return t;
//            return isTimedOut();
        }
*/
        return isHot || isTimedOut();

    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
