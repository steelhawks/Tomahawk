
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc2014.team2601.Map;
import frc2014.team2601.commands.DoNothing;
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
    private boolean isFired;
    private double delay;
    
    public Launcher(){
        setConfiguration();
        leftPiston = new DoubleSolenoid(Map.LEFT_PISTON_EXTEND, Map.LEFT_PISTON_RETRACT);
        middlePiston = new DoubleSolenoid(Map.MIDDLE_PISTON_EXTEND, Map.MIDDLE_PISTON_RETRACT);
        rightPiston = new DoubleSolenoid(Map.RIGHT_PISTON_EXTEND, Map.RIGHT_PISTON_RETRACT);
        displayData();
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
    
    public void pulse(){
        fire();
        resetLauncher();
    }
    
    public void delayedPulse() {
        DoNothing timer = new DoNothing(1); 
        timer.start();
        if(!timer.isRunning())System.out.println("Time is finished");
        while(timer.isRunning()) {
            System.out.println("PULSING");
            pulse();
        }
    }
    
    public double getDelay(){
        return delay;
    } 
    
    public boolean getFired(){
        return isFired;
    }
    
    public void setDelay(double value){
        delay = value;
    }
    
    public void setFired(boolean status){
        isFired = status;
    }
    
    public void displayDelay() {
        SmartDashboard.putDouble("New Time Delay", delay);
    }
    
    public void setConfiguration(){
        delay = 0.3;
        retractor = DoubleSolenoid.Value.kReverse; //Forward
        extender = DoubleSolenoid.Value.kForward; //Reverse
    }
    
    public void displayData(){
        SmartDashboard.putString("Left piston", leftPiston.get().toString());
        SmartDashboard.putString("Middle piston", middlePiston.get().toString());
        SmartDashboard.putString("Right piston", rightPiston.get().toString());
        SmartDashboard.putDouble("New Time Delay", delay);
    }
}