/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.driving;

import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author steelhawks
 */
public class ArcadeDrive extends CommandBase {
    
    private final double closeRangeThreshold = 90; //inches
    private final double longRangeThreshold = 110; //inches
    
    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.arcadeDrive(oi.getPrimaryController(), false);
        if(drivetrain.getDistanceFromWall()>=closeRangeThreshold && drivetrain.getDistanceFromWall()<=longRangeThreshold){
            lights.toggle(System.currentTimeMillis());
            //SmartDashboard
        }
        else lights.setRed();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.fullStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drivetrain.fullStop();
    }
}
