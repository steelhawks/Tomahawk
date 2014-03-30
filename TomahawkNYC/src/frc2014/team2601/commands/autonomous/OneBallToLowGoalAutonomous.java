/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frc2014.team2601.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc2014.team2601.commands.DoNothing;
import frc2014.team2601.commands.collecting.Close;
import frc2014.team2601.commands.collecting.Open;
import frc2014.team2601.commands.driving.MoveForward;
import frc2014.team2601.commands.launching.Fire;

/**
 *
 * @author steelhawks
 */
public class OneBallToLowGoalAutonomous extends CommandGroup{
    
    
    public OneBallToLowGoalAutonomous () {
        addParallel(new Open());
        addSequential(new DoNothing(1));
        addSequential(new Close());
        addSequential(new MoveForward(1.7));
        addSequential(new DoNothing(0.5));
        addParallel(new Open());
        addSequential(new Fire());
        
    }
    
}
