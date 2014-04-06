/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc2014.team2601.Map;
import frc2014.team2601.commands.collecting.OperateWithJoystick;

/**
 *
 * @author developer
 */
public class Arms extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Value solenoidClose, solenoidOpen;
    private final Talon arm;
    private final DoubleSolenoid solenoid;
    private double speed;
    //private Ultrasonic ballSonar;
    //private boolean hasBall;

    public Arms(){
        setConfiguration();
        arm = new Talon(Map.ARM_MOTOR);
        solenoid = new DoubleSolenoid(Map.ARM_OPEN, Map.ARM_CLOSE);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new OperateWithJoystick());
    }
    
    public void openArm(){
        solenoid.set(solenoidOpen);
    }
    
    public void closeArm(){
        solenoid.set(solenoidClose);
    }
    
    public void operateArm(Joystick joystick){
        arm.set(joystick.getY());
    }
    
    public void moveArmDown(){
        arm.set(-speed);
    }
    
    public void moveArmUp(){
        arm.set(speed);
    }
    
    public void stopArm(){
        arm.stopMotor();
    }
    
//    public double getDistanceFromBall(){
//        return ballSonar.getRangeInches();
//    }
//
//    public boolean getHasBall(){
//        return hasBall;
//    }
//    
//    public void setHasBall(boolean setting){
//        hasBall = setting;
//    } 
    
    public void setConfiguration(){
        //hasBall = false;
        speed = 1.0;
        solenoidClose = DoubleSolenoid.Value.kReverse;
        solenoidOpen = DoubleSolenoid.Value.kForward;
    }
}