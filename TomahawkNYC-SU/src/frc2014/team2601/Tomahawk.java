package frc2014.team2601;

/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc2014.team2601.commands.CommandBase;
import frc2014.team2601.commands.autonomous.MoveForwardAutonomous;
import frc2014.team2601.commands.autonomous.OneBallAutonomous;
import frc2014.team2601.commands.autonomous.OneBallHotAutonomous;
import frc2014.team2601.commands.autonomous.OneBallToLowGoalAutonomous;
import frc2014.team2601.commands.autonomous.ThreeBallAutonomous;
import frc2014.team2601.commands.autonomous.TwoBallAutonomous;
import frc2014.team2601.commands.launching.ResetLauncher;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Tomahawk extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autoChooser;
    Compressor compressor;
    NetworkTable table;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the NetworkTable used for varying autonomous settings
        table = NetworkTable.getTable("Autonomous Table");
        
        // instantiate the command used for the autonomous period
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Move Forward", new MoveForwardAutonomous());
        autoChooser.addDefault("One Ball Hot Autonomous", new OneBallHotAutonomous());
        autoChooser.addObject("One Ball Auton", new OneBallAutonomous());
        autoChooser.addObject("One Ball Auton to Low Goal", new OneBallToLowGoalAutonomous());
        autoChooser.addObject("Two Ball Auton", new TwoBallAutonomous());
        autoChooser.addObject("Three Ball Auton", new ThreeBallAutonomous());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
//        SmartDashboard.putData("ArcadeDrive", new ArcadeDrive());
//        SmartDashboard.putData("ArcadeDriveSqrt", new ArcadeDriveSqrt());
//        SmartDashboard.putData("TankDrive", new TankDrive());

        // Initialize all subsystems
        CommandBase.init();
        compressor = new Compressor(Map.PRESSURE_SWITCH, Map.COMPRESSOR_RELAY);
        compressor.start();
        new ResetLauncher().start();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand = (Command) autoChooser.getSelected();
        CommandBase.vision.target();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
