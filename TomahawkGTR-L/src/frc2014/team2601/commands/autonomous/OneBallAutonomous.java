/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frc2014.team2601.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc2014.team2601.Map;
import frc2014.team2601.commands.collecting.Open;
import frc2014.team2601.commands.driving.MoveForward;
import frc2014.team2601.commands.launching.Fire;

/**
 *
 * @author steelhawks
 */
public class OneBallAutonomous extends CommandGroup{
    
    
    public OneBallAutonomous () {
        addParallel(new Open());
        addSequential(new MoveForward(2.3));
        addSequential(new Fire());
        
    }
    
}
