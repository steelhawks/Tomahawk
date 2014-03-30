/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frc2014.team2601.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc2014.team2601.commands.DoNothing;
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
    
    //UNTESTED AS OF 3/6/14 (Adjusted DoNothing() from 0.5 to 0.65 - Vinay)
    public TwoBallAutonomous () {
        addParallel(new MoveForward(2.1));
//        addParallel(new DoNothing(2.25));
        addSequential(new Open());
        addSequential(new MoveArmDownTimed(.8));
        addSequential(new Close());
        addParallel(new MoveForward(.4));
//        addParallel(new DoNothing(.4));
        addSequential(new Fire());
        addSequential(new MoveArmUpTimed(.95)); //Q1: 0.8 to 0.95
        addParallel(new MoveForward(0.5)); //Q1: 1 to 0.5
//        addParallel(new DoNothing(1));
        addSequential(new Open());
        addSequential(new DoNothing(1));
        addSequential(new Fire());
    }
    
}
