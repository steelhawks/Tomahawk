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
import frc2014.team2601.commands.driving.MoveForwardAndShoot;
import frc2014.team2601.commands.launching.Fire;

/**
 *
 * @author steelhawks
 */
public class ThreeBallAutonomous extends CommandGroup{
    
    
    public ThreeBallAutonomous () {
//        addSequential(new OpenArm(Config.ARM_OPEN_TIMEOUT));
//        addSequential(new MoveArmDownTimed(.625));
//        addSequential(new CloseArm(Config.ARM_CLOSE_TIMEOUT));
//        addSequential(new MoveForward(2.25));
//        addParallel(new MoveForward(.5));
//        addSequential(new Shoot(Config.LONG_RANGE_TIMEOUT));
//        addSequential(new MoveArmUpTimed(.625));
//        addSequential(new OpenArm(Config.ARM_OPEN_TIMEOUT));
//        addSequential(new Timer(.2));
//        addSequential(new Shoot(Config.LONG_RANGE_TIMEOUT));
        addParallel(new MoveForward(3));
        addSequential(new Open());
        addSequential(new MoveArmDownTimed(.625));
        addSequential(new Close());
        addParallel(new MoveForward(.4));
        addSequential(new Fire());
        addSequential(new MoveArmUpTimed(.625));
        addParallel(new MoveForward(1));
        addSequential(new Open());
        addSequential(new Fire());
        addParallel(new MoveForward(.8));
        addSequential(new MoveArmDownTimed(.625));
        addSequential(new Close());
        addSequential(new MoveArmUpTimed(.625));
        addSequential(new Open());
        addSequential(new Fire());
        
    }
    
}
