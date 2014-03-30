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
    //private final Gyro gyro;
    //private boolean isCartesian;
    
    public Drivetrain(){
        frontLeft = new Talon(Map.FRONT_LEFT_MOTOR);
        rearLeft = new Talon(Map.REAR_LEFT_MOTOR);
        frontRight = new Talon(Map.FRONT_RIGHT_MOTOR);
        rearRight = new Talon(Map.REAR_RIGHT_MOTOR);
        speed = 1.0;
        robotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
        //robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        //robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        robotDrive.setSafetyEnabled(false);
        //gyro = new Gyro(Map.GYRO);
        //isCartesian = true;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ArcadeDrive()); //Commented for testing only; allows for SmartDashboard selection of driving
    }
    
    public void arcadeDrive(Joystick joystick, boolean hasTwistAxis){
        if(hasTwistAxis) robotDrive.arcadeDrive(joystick.getY(), -joystick.getTwist());
        else robotDrive.arcadeDrive(joystick.getY(), -joystick.getX());
        System.out.println(frontLeft.get() + ", " + rearLeft.get() + ", " + frontRight.get() + ", " + rearRight.get());
    }
    
    public void arcadeDriveSqrt(Joystick joystick, boolean hasTwistAxis){
        if(hasTwistAxis) robotDrive.arcadeDrive(squareRoot(joystick.getY()), squareRoot(-joystick.getTwist()));
        else robotDrive.arcadeDrive(squareRoot(joystick.getY()), squareRoot(-joystick.getX()));
    }
    
    public double squareRoot(double value){
        double sign = Math.abs(value)/value;
        return sign*Math.sqrt(Math.abs(value));
    }
    
    public void tankDrive(Joystick leftStick, Joystick rightStick){
        robotDrive.tankDrive(leftStick.getY(), rightStick.getY()); 
    }
    
    /*
    public void drivePolar(Joystick joystick){
        robotDrive.mecanumDrive_Polar(joystick.getMagnitude(), joystick.getDirectionDegrees(), joystick.getTwist());
    }
    
    public void driveCartesian(Joystick joystick){
        robotDrive.mecanumDrive_Cartesian(joystick.getX(), joystick.getY(), joystick.getTwist(), gyro.getAngle());
//        System.out.println("talon 1" + frontLeft.get() + ", talon 2" + frontRight.get() + ", talon 3" + rearLeft.get() + ", talon 4" + rearRight.get());
    }
    */
    
    /*
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
*/
    
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
    
    /*
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
    */
    
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
    
    /*
    public double debugGyro(){
        SmartDashboard.putDouble("Gyro reading: ", gyro.getAngle());
        return gyro.getAngle();
    }
    */
    
    public void displayData(){
        SmartDashboard.putNumber("Front Left Speed Controller", frontLeft.get());
        SmartDashboard.putNumber("Rear Left Speed Controller", rearLeft.get());
        SmartDashboard.putNumber("Front Right Speed Controller", frontRight.get());
        SmartDashboard.putNumber("Rear Right Speed Controller", rearRight.get());
        //SmartDashboard.putNumber("Gyro", gyro.getAngle());
    }
}