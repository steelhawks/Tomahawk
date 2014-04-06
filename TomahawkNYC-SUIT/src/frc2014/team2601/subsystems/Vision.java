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
    private double hot, initial, interval;
    
    public Vision(){
        tilt = new Servo(Map.SERVO);
        light = new Relay(Map.CAMERA_LIGHT_RELAY);
        hot = 0.0;
        interval = 2.5;
        initial = 102.0;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TurnLightOn());
    }
    
    public void tiltUp(){
        tilt.setAngle(tilt.getAngle() - interval);
    }
    
    public void tiltDown(){
        tilt.setAngle(tilt.getAngle() + interval);
    }
    
    public void reset(){
        tilt.setAngle(initial);
    }
    
    public void target(){
        tilt.setAngle(hot);
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
    
    public void moveToPosition(double angle){
        tilt.setAngle(hot);
    }
    
    public double getHotPosition(){
        return hot;
    }
}