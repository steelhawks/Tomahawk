/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc2014.team2601.commands.CheckIfHot;
import frc2014.team2601.commands.collecting.Open;
import frc2014.team2601.commands.driving.MoveForward;
import frc2014.team2601.commands.launching.Fire;

/**
 *
 * @author steelhawks
 */
public class OneBallHotAutonomous extends CommandGroup {
    
    public OneBallHotAutonomous() {
        addParallel(new MoveForward(2));
        addParallel(new Open());
        addSequential(new CheckIfHot(5));
        addSequential(new Fire());
    }
    
}
