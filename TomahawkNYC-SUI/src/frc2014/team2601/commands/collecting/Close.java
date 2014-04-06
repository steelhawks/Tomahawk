/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.collecting;

import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author developer
 */
public class Close extends CommandBase {
    
    private double timeout = 0.2;
    
    public Close() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(arms);
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        arms.closeArm();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}