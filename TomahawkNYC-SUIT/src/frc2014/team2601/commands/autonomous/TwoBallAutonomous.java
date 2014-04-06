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
   
    private double speed = 1.0;
    
    public TwoBallAutonomous () {

        
////        addParallel(new MoveForward(2.8));
//        addSequential(new Open());
//        addSequential(new MoveArmDownTimed(.8));
//        addSequential(new Close());
//        addSequential(new MoveArmUpTimed(0.1));
//        addSequential(new MoveForward(2.8));
////        addParallel(new MoveForward(0.6));                          
////        addParallel(new DoNothing(.4));
//        addSequential(new DoNothing(1.6));
//        addSequential(new Fire());
//        addSequential(new MoveArmUpTimed(.9)); //Q1: 0.8 to 0.95
////       addParallel(new MoveForward(0.5)); //Q1: 1 to 0.5
////        addParallel(new DoNothing(1));
//        addSequential(new Open());
//        addSequential(new DoNothing(1.25));
//        addSequential(new Fire());
        
//          addParallel(new Open());
//          addSequential(new MoveArmDownTimed(0.8));
//          addSequential(new Close());
//          addSequential(new MoveForwardRated(0.4, speed));
//          addSequential(new Fire());
//          addSequential(new MoveArmUpTimed(0.9));
//          addSequential(new Open());
//          addSequential(new Fire());

            //Version 3 (or something...)
            addSequential(new Open());
            addSequential(new MoveArmDownTimed(0.8));
            addSequential(new Close());
            addSequential(new MoveArmUpTimed(0.2));
            addSequential(new MoveForward(0.45));
            addParallel(new Fire(false));
            addSequential(new MoveForward(1.48));
            addSequential(new MoveArmUpTimed(0.6));
            addParallel(new Open());
            addSequential(new DoNothing(1.0));
            addSequential(new Fire());
            
    }
    
}
