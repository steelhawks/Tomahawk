/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc2014.team2601.Map;
import frc2014.team2601.commands.driving.ArcadeDrive;

/**
 *
 * @author developer
 */
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final Talon frontLeft, rearLeft, frontRight, rearRight;
    private double forwardAngle, rightAngle, backwardAngle, leftAngle, rightRotationRate, leftRotationRate;
    private double nonRotate, nonDirection;
    private double speed;
    private RobotDrive robotDrive;
    
    public Drivetrain(){
        frontLeft = new Talon(Map.FRONT_LEFT_MOTOR);
        rearLeft = new Talon(Map.REAR_LEFT_MOTOR);
        frontRight = new Talon(Map.FRONT_RIGHT_MOTOR);
        rearRight = new Talon(Map.REAR_RIGHT_MOTOR);
        speed = 1.0;
        robotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
        robotDrive.setSafetyEnabled(false);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ArcadeDrive()); 
    }
    
    public void arcadeDrive(Joystick joystick, boolean hasTwistAxis){
        if(hasTwistAxis) robotDrive.arcadeDrive(joystick.getY(), -joystick.getTwist());
        else robotDrive.arcadeDrive(joystick.getY(), -joystick.getX());
    }
   
    public void moveForward(){
        robotDrive.drive(-speed, nonRotate);
    }
    
    public void moveForwardSlowly(){
        robotDrive.drive(-speed+0.5, nonRotate);
    }
    
    public void moveForward(double rate){
        robotDrive.drive(rate, nonRotate);
    }
    
    public void moveBackward(){
        robotDrive.drive(speed, nonRotate);
    }
    
    public void rotateLeft(){
        robotDrive.drive(speed, leftRotationRate);
    }
    
    public void rotateRight(){
        robotDrive.drive(speed, rightRotationRate);
    }
    
    public void stop(){
        robotDrive.stopMotor();
    }
    
    public void fullStop(){
        robotDrive.stopMotor();
        if((frontLeft.get() + rearLeft.get() + frontRight.get() + rearRight.get()) > 0.01){
            frontLeft.stopMotor();
            rearLeft.stopMotor();
            frontRight.stopMotor();
            rearRight.stopMotor();
        }
    }
    
    public void setSpeed(double speed){
        this.speed = speed;
    }
    
    public void setConfiguration(){
        forwardAngle = 0;
        rightAngle = 90;
        backwardAngle = 180;
        leftAngle = -90;
        rightRotationRate = 1.0;
        leftRotationRate = -1.0;
        nonRotate = 0.0;
        nonDirection = 0.0;
    }
    
    public void displayData(){
        SmartDashboard.putNumber("Front Left Speed Controller", frontLeft.get());
        SmartDashboard.putNumber("Rear Left Speed Controller", rearLeft.get());
        SmartDashboard.putNumber("Front Right Speed Controller", frontRight.get());
        SmartDashboard.putNumber("Rear Right Speed Controller", rearRight.get());
    }
}