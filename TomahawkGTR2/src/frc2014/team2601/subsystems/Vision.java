/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc2014.team2601.Map;
import frc2014.team2601.commands.vision.TurnLightOn;

/**
 *
 * @author developer
 */
public class Vision extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final Servo tilt;
    private final Relay light;
    private double initial, position, interval;
    
    public Vision(){
        tilt = new Servo(Map.SERVO);
        light = new Relay(Map.CAMERA_LIGHT_RELAY);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TurnLightOn());
    }
    
    public void tiltUp(){
        tilt.setAngle(position - interval);
    }
    
    public void tiltDown(){
        tilt.setAngle(position + interval);
    }
    
    public void center(){
        tilt.setAngle(initial);
    }
    
    public void turnLightOn(){
        light.set(Relay.Value.kForward);
    }
    
    public void turnLightOff(){
        light.set(Relay.Value.kOff);
    }
    
    public Servo getServo(){
        return tilt;
    }
    
    public void setPosition(double angle){
        this.position = angle;
    }
    
    public void setConfiguration(){
        initial = tilt.getAngle();
        interval = 1;
    }
}