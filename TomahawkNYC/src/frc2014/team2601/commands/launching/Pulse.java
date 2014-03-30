/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.launching;

import edu.wpi.first.wpilibj.Timer;
import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author steelhawks
 */
public class Pulse extends CommandBase {
    
    public Pulse() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(launcher);
        setTimeout(1.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.fire();
        Timer.delay(launcher.getDelay());
        while(!isTimedOut()) {
            System.out.println("Pulsing");
            launcher.fire();
            launcher.resetLauncher();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.resetLauncher();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
