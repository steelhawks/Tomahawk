/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.vision;

import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author developer
 */
public class TiltUp extends CommandBase {
    
    public TiltUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("BEFORE TILTING UP: " + vision.getServo().getAngle());
        vision.tiltUp();
        System.out.println("AFTER TILTING UP: " + vision.getServo().getAngle());
        System.out.println("-------------");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}