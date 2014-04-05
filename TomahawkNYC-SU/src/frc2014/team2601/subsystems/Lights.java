/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc2014.team2601.Map;
import frc2014.team2601.commands.lights.OperateLights;

/**
 *
 * @author steelhawks
 */
public class Lights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Relay red, blue;
    private boolean isRed, isBlue;
    private Relay.Value on, off; 
    private double toggleDelay;
    
    public Lights(){
        red = new Relay(Map.RED_LIGHT_RELAY);
        blue = new Relay(Map.BLUE_LIGHT_RELAY);
        setConfiguration();
        findAllianceColor();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new OperateLights());
    }
    
    public void findAllianceColor(){
        if(DriverStation.Alliance.kBlue_val == 0){
            isRed = false;
            isBlue = true;
        }
        else if(DriverStation.Alliance.kRed_val == 0){
            isRed = true;
            isBlue = false;
        }
    }
    
    public void setAllianceColor(){
        if(isRed) setRed();
        else if(isBlue) setBlue();
    }
    
    public void setOppositeColor(){
        if(isRed) setBlue();
        else if(isBlue) setRed();
    }
    
    public void setRed(){
        red.set(on);
        blue.set(off);
//        isRed = true;
//        isBlue = false;
    }
    
    public void setBlue(){
        red.set(off);
        blue.set(on);
//        isRed = false;
//        isBlue = true;
    }
    
    public void setPurple(){
        red.set(on);
        blue.set(on);
//        isRed = true;
//        isBlue = true;
    }
    
    public void setConfiguration(){
        isRed = false;
        isBlue = false;
        on = Relay.Value.kForward;
        off = Relay.Value.kOff;
        toggleDelay = 50; //milliseconds
    }
    
    public void toggle(double startingTime){
        if(System.currentTimeMillis()<=startingTime+toggleDelay) setRed();
        setBlue();
    }
}
