/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc2014.team2601.Map;
import frc2014.team2601.commands.sonar.OperateSonar;

/**
 *
 * @author Neil
 */
public class Sonar extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Ultrasonic wallSonar, ballSonar;
    //private Ultrasonic wallSonar = new Ultrasonic(Map.LAUNCHER_SONAR_INPUT, Map.LAUNCHER_SONAR_OUTPUT);
    //private Ultrasonic ballSonar = new Ultrasonic(Map.ARM_SONAR_INPUT, Map.ARM_SONAR_OUTPUT);
    private boolean inRange, hasBall;
    private double previousBallReading = 0.0, previousWallReading = 0.0;
    
    public Sonar(){
        ballSonar = new Ultrasonic(Map.ARM_SONAR_INPUT, Map.ARM_SONAR_OUTPUT);
        wallSonar = new Ultrasonic(Map.LAUNCHER_SONAR_INPUT, Map.LAUNCHER_SONAR_OUTPUT);
        ballSonar.setEnabled(true);
        ballSonar.setAutomaticMode(true);
        wallSonar.setEnabled(true);
        wallSonar.setAutomaticMode(true);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new OperateSonar());
    }
    
    public double getDistanceFromWall(){
        return wallSonar.getRangeInches();
    }
    
    public double getDistanceFromBall(){
        return ballSonar.getRangeInches();
    }
      
    public boolean getHasBall(){
        return hasBall;
    }
    
    public boolean getInRange(){
        return inRange;
    }
    
    public double getPreviousBallReading(){
        return previousBallReading;
    }
    
    public double getPreviousWallReading(){
        return previousWallReading;
    }
    
    public void setInRange(boolean setting){
        inRange = setting;
    }
    
    public void setHasBall(boolean setting){
        hasBall = setting;
    }
    
    public void setPreviousBallReading(double setting){
        previousBallReading = setting;
    }
    
    public void setPreviousWallReading(double setting){
        previousWallReading = setting;
    }
    
    public void setConfiguration(){
        inRange = false;
        hasBall = false;
    } 
}
