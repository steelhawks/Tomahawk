/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc2014.team2601.Map;
import frc2014.team2601.commands.driving.DriveWithJoystick;

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
    private final Gyro gyro;
    private boolean isCartesian;
    
    public Drivetrain(){
        frontLeft = new Talon(Map.FRONT_LEFT_MOTOR);
        rearLeft = new Talon(Map.REAR_LEFT_MOTOR);
        frontRight = new Talon(Map.FRONT_RIGHT_MOTOR);
        rearRight = new Talon(Map.REAR_RIGHT_MOTOR);
        speed = 1.0;
        robotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        robotDrive.setSafetyEnabled(false);
        gyro = new Gyro(Map.GYRO);
        isCartesian = true;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drivePolar(Joystick joystick){
        robotDrive.mecanumDrive_Polar(joystick.getMagnitude(), joystick.getDirectionDegrees(), joystick.getTwist());
    }
    
    public void driveCartesian(Joystick joystick){
        robotDrive.mecanumDrive_Cartesian(joystick.getX(), joystick.getY(), joystick.getTwist(), gyro.getAngle());
//        System.out.println("talon 1" + frontLeft.get() + ", talon 2" + frontRight.get() + ", talon 3" + rearLeft.get() + ", talon 4" + rearRight.get());
    }
    
    public void moveForward(){
        robotDrive.mecanumDrive_Polar(speed, forwardAngle, nonRotate);
    }
    
    public void moveForwardSlowly(){
        robotDrive.mecanumDrive_Polar(speed - 0.5, forwardAngle, nonRotate);
    }
    
    public void moveBackward(){
        robotDrive.mecanumDrive_Polar(speed, backwardAngle, nonRotate);
    }
    
    public void rotateLeft(){
        robotDrive.mecanumDrive_Polar(speed, nonDirection, leftRotationRate);
    }
    
    public void rotateRight(){
        robotDrive.mecanumDrive_Polar(speed, nonDirection, rightRotationRate);
    }
    
    public void strafeLeft(){
        robotDrive.mecanumDrive_Polar(speed, leftAngle, nonRotate);
    }
    
    public void strafeRight(){
        robotDrive.mecanumDrive_Polar(speed, rightAngle, nonRotate);
    }
    
    public void stop(){
        robotDrive.stopMotor();
    }
    
    public void resetGyro(){
        gyro.reset();
    }
    
    public boolean getCartesian(){
        return isCartesian;
    }
    
    public void setCartesian(boolean setting){
        if(setting) SmartDashboard.putString("Drive Mode: ", "Cartesian/Field-centric");
        else SmartDashboard.putString("Drive Mode: ", "Polar/Robot-centric");
        isCartesian = setting;
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
    
    public double debugGyro(){
        SmartDashboard.putDouble("Gyro reading: ", gyro.getAngle());
        return gyro.getAngle();
    }
}