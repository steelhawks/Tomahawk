/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc2014.team2601.Map;
import frc2014.team2601.commands.launching.ResetLauncher;

/**
 *
 * @author developer
 */
public class Launcher extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private final DoubleSolenoid leftPiston, middlePiston, rightPiston;
    private Value retractor, extender;
    
    public Launcher(){
        setConfiguration();
        leftPiston = new DoubleSolenoid(Map.LEFT_PISTON_EXTEND, Map.LEFT_PISTON_RETRACT);
        middlePiston = new DoubleSolenoid(Map.MIDDLE_PISTON_EXTEND, Map.MIDDLE_PISTON_RETRACT);
        rightPiston = new DoubleSolenoid(Map.RIGHT_PISTON_EXTEND, Map.RIGHT_PISTON_RETRACT);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ResetLauncher());
    }
    
    public void resetLauncher(){
        leftPiston.set(retractor);
        middlePiston.set(retractor);
        rightPiston.set(retractor);
    }
    
    public void fire(){
        leftPiston.set(extender);
        middlePiston.set(extender);
        rightPiston.set(extender);
    }
    
    public void setConfiguration(){
        retractor = DoubleSolenoid.Value.kForward;
        extender = DoubleSolenoid.Value.kReverse;
    }
}