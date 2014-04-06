/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.lights;

import frc2014.team2601.commands.CommandBase;

/**
 *
 * @author steelhawks
 */
public class OperateLights extends CommandBase {
    
    public OperateLights() {
        // Use requires() here to declare subsystem dependencies
        requires(lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(sonar.getInRange()) lights.setRed();
        else lights.setPurple();
        /*
        if(launcher.getFired()){
            lights.setOppositeColor();
        }
        else{
            lights.setAllianceColor();
        }
        */
        //lights.setBlue();
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
