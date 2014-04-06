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
public class MoveForward extends CommandBase{
    
    public MoveForward(double timeout) {
        requires(drivetrain);
        setTimeout(timeout);
    }
    
    public void interrupted() {
        drivetrain.fullStop();
    }
    
    public void end() {
        drivetrain.fullStop();
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
