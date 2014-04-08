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
    private boolean cRed, cPurple;;
    
    public Lights(){
        red = new Relay(Map.RED_LIGHT_RELAY);
        blue = new Relay(Map.BLUE_LIGHT_RELAY);
        cRed = false;
        cPurple = true;
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
        cRed = true;
        cPurple = false;
    }
    
    public void setBlue(){
        red.set(off);
        blue.set(on);
    }
    
    public void setPurple(){
        red.set(on);
        blue.set(on);
        cRed = false;
        cPurple = true;
    }
        
    public void setC(boolean setting){
        cRed = setting;
        cPurple = !setting;
    }
    
    public void toggle(){
        if(cRed) setPurple();
        else if(cPurple) setRed();
    }
    
    public void setConfiguration(){
        isRed = false;
        isBlue = false;
        off = Relay.Value.kForward;
        on = Relay.Value.kOff;
    }
}
