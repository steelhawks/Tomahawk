/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.vision;

import frc2014.team2601.commands.CommandBase;
import frc2014.team2601.subsystems.Vision;

/**
 *
 * @author steelhawks
 */
public class MoveToPosition extends CommandBase {
    
    double position = 150;
    double timeout = .15;
    
    public MoveToPosition(double position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //vision.setPosition(position);
        vision.moveToPosition(vision.getHotPosition());
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
