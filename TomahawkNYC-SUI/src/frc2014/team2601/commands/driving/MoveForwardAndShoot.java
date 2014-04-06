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
public class MoveForwardAndShoot extends CommandBase{
    
    public MoveForwardAndShoot(double timeout) {
        requires(drivetrain);
        requires(launcher);
        setTimeout(timeout);
    }
    
    public void interrupted() {
        
    }
    
    public void end() {
        drivetrain.stop();
        launcher.fire();
    }
    
    public boolean isFinished() {
        return isTimedOut();
    }
    
    public void execute() {
        drivetrain.moveForward();
    }
    
    public void initialize() {
        
    }
    
}
