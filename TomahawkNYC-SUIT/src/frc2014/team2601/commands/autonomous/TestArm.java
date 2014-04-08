/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc2014.team2601.commands.collecting.MoveArmUpTimed;

/**
 *
 * @author steelhawks
 */
public class TestArm extends CommandGroup {
    
    public TestArm() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        //ouble delay = 0.300;
        //SmartDashboard.putNumber("Delay", delay);
        //SmartDashboard.getNumber("Delay", delay);
        addSequential(new WaitCommand(5.000));
        addSequential(new MoveArmUpTimed(0.300));
    }
}
