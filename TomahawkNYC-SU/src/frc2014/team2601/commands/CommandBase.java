package frc2014.team2601.commands;

import frc2014.team2601.OI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import OI;
import frc2014.team2601.subsystems.Arms;
import frc2014.team2601.subsystems.Drivetrain;
import frc2014.team2601.subsystems.HotGoalVision;
import frc2014.team2601.subsystems.Launcher;
import frc2014.team2601.subsystems.Lights;
import frc2014.team2601.subsystems.Vision;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Arms arms = new Arms();
    public static Drivetrain drivetrain = new Drivetrain();
    public static Launcher launcher = new Launcher();
    public static Vision vision = new Vision();
    public static HotGoalVision hotgoal = new HotGoalVision();
    public static Lights lights = new Lights();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(arms);
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(launcher);
        SmartDashboard.putData(vision);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
