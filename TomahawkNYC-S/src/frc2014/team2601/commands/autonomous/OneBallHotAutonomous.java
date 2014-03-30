/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc2014.team2601.commands.CheckIfHot;
import frc2014.team2601.commands.DoNothing;
import frc2014.team2601.commands.collecting.Close;
import frc2014.team2601.commands.collecting.Open;
import frc2014.team2601.commands.driving.MoveForward;
import frc2014.team2601.commands.launching.Fire;
import frc2014.team2601.commands.vision.MoveToPosition;

/**
 *
 * @author steelhawks
 */
public class OneBallHotAutonomous extends CommandGroup {
    
    public OneBallHotAutonomous() {
        addSequential(new MoveToPosition(90));
        addSequential(new CheckIfHot(4));
        addParallel(new Open());
        addSequential(new DoNothing(1.0));
        addSequential(new Close());
        addSequential(new MoveForward(1.7));
        addSequential(new DoNothing(0.5));
        addParallel(new Open());
        addSequential(new DoNothing(1.0));
        addSequential(new Fire());
//        addParallel(new MoveForward(2));
//        addParallel(new Open());
//        addSequential(new CheckIfHot(5));
//        addSequential(new Fire());
    }
    
}
