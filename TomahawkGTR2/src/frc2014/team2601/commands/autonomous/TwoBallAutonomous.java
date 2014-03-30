/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frc2014.team2601.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc2014.team2601.commands.collecting.Close;
import frc2014.team2601.commands.collecting.MoveArmDownTimed;
import frc2014.team2601.commands.collecting.MoveArmUpTimed;
import frc2014.team2601.commands.collecting.Open;
import frc2014.team2601.commands.driving.MoveForward;
import frc2014.team2601.commands.launching.Fire;

/**
 *
 * @author steelhawks
 */
public class TwoBallAutonomous extends CommandGroup{
    
    
    public TwoBallAutonomous () {
        addParallel(new MoveForward(2.25));
        addSequential(new Open());
        addSequential(new MoveArmDownTimed(.625));
        addSequential(new Close());
        addParallel(new MoveForward(.4));
        addSequential(new Fire());
        addSequential(new MoveArmUpTimed(.625));
        addParallel(new MoveForward(1));
        addSequential(new Open());
        addSequential(new Fire());
    }
    
}
