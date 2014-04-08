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
public class PassFire extends CommandBase {
    
    private double timeout = 0.320;
    private boolean hasDelayed = false;
    
    public PassFire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.fire();
        Timer.delay(timeout);
        launcher.resetLauncher();
        hasDelayed = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasDelayed;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
