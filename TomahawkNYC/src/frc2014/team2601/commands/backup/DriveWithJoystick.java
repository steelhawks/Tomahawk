/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.backup;

import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author steelhawks
 */
public class DriveWithJoystick extends CommandBase {
    
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //drivetrain.drivePolar(oi.getPrimaryController());
        //System.out.println(drivetrain.debugGyro());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
