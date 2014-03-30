/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.launching;

import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author developer
 */
public class Fire extends CommandBase {
    
    private double timeout = 2.0;
    
    public Fire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(launcher);
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //launcher.setFired(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.fire();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.resetLauncher();
        //launcher.setFired(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}