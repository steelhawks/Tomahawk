/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.driving;

import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author developer
 */
public class DriveWithJoystick extends CommandBase {
    
    private boolean isCartesian = true;
    
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
    }
    
    protected void setCartesian(boolean setting){
        isCartesian = drivetrain.getCartesian();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(isCartesian) drivetrain.driveCartesian(oi.getPrimaryController());
        else drivetrain.drivePolar(oi.getPrimaryController());
        System.out.println(drivetrain.debugGyro());
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