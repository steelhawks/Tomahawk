/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.collecting;

import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author steelhawks
 */
public class DetectBall extends CommandBase {
    
    public DetectBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //requires(arms);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return sonar.getHasBall();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
