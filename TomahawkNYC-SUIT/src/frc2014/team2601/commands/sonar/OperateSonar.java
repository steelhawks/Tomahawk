/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.commands.sonar;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc2014.team2601.commands.CommandBase;
import frc2014.team2601.subsystems.Sonar;

/**
 *
 * @author Neil
 */
public class OperateSonar extends CommandBase {
    
    //Optimal launch distanceToWall thresholds
    private int lowCloseThreshold = 65, lowFarThreshold = 95,
                    highCloseThreshold = 89, highFarThreshold = 119; //inches
    private double distanceToWall;
             
    //Optimal intake distanceToWall thresholds
    private double ballCloseThreshold = 3, ballFarThreshold = 19;
    private double distanceToBall;
    
    //Simplifying things
    private boolean isClose, isFar, isLegit;
    
    //For denoising algorithm
//    private int pings = 0;
//    private double sumDistanceToWall = 0.0, sumDistanceToBall = 0.0;
//    private double meanDistanceToWall = 0.0, meanDistanceToBall = 0.0;
//    private double standardDeviation = 0.0;
//    private double[] ballReadings = new double[100];
    private int ballGap = 35, wallGap = 60; //Max permissible gap between consecutive readings to eliminate noise
    
    public OperateSonar() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(sonar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
               //Allow for SmartDashboard adjustment of thresholds
        SmartDashboard.putNumber("lowCloseThreshold", lowCloseThreshold);
        SmartDashboard.putNumber("lowFarThreshold", lowFarThreshold);
        SmartDashboard.putNumber("highCloseThreshold", highCloseThreshold);
        SmartDashboard.putNumber("highFarThreshold", highFarThreshold);
        SmartDashboard.putNumber("ballCloseThreshold", ballCloseThreshold);
        SmartDashboard.putNumber("ballFarThreshold", ballFarThreshold);
        lowCloseThreshold = (int) SmartDashboard.getNumber("lowCloseThreshold", lowCloseThreshold);
        lowFarThreshold = (int) SmartDashboard.getNumber("lowFarThreshold", lowFarThreshold);
        highCloseThreshold = (int) SmartDashboard.getNumber("highCloseThreshold", highCloseThreshold);
        highFarThreshold = (int) SmartDashboard.getNumber("highFarThreshold", highFarThreshold);
        ballCloseThreshold = (int) SmartDashboard.getNumber("ballCloseThreshold", ballCloseThreshold);
        ballFarThreshold = (int) SmartDashboard.getNumber("ballFarThreshold", ballFarThreshold);
        
        //Assign sonar readings to variables for clearer references
        distanceToWall = sonar.getDistanceFromWall();
        distanceToBall = sonar.getDistanceFromBall();
 
        //Filter out outlier readings and sensor noise using the mean and standard deviation
//        pings++;
//        sumDistanceToBall += distanceToBall;
//        meanDistanceToBall = sumDistanceToBall/pings;
//        if(pings <= ballReadings.length) ballReadings[pings] = distanceToBall;
//        else ballReadings = new double[100]; //Clean up to save memory on the cRIO
//        for(int i=0; i<ballReadings.length; i++){
//            standardDeviation += ((ballReadings[i] - meanDistanceToBall)*(ballReadings[i] - meanDistanceToBall))/ballReadings.length;
//        }
//        standardDeviation = Math.sqrt(standardDeviation);
        
        //Set flags for optimal shooting distance  
//        if( ((distanceToWall>=lowCloseThreshold && distanceToWall<=lowFarThreshold)
//                || (distanceToWall>=highCloseThreshold && distanceToWall<=highFarThreshold))
//             && ((distanceToWall<sonar.getPreviousWallReading()+wallGap)) || (distanceToWall>sonar.getPreviousWallReading()-wallGap)){
//            sonar.setInRange(true);
//        }
//        else{
//            sonar.setInRange(false);
//        }
        
        isClose = ((distanceToWall>=lowCloseThreshold) && (distanceToWall<=lowFarThreshold));
        isFar = ((distanceToWall>=highCloseThreshold) && (distanceToWall<=highFarThreshold));
        isLegit = ((distanceToWall<sonar.getPreviousWallReading()+wallGap) || (distanceToWall>sonar.getPreviousWallReading()-wallGap));
        if((isClose||isFar)&&isLegit){
            sonar.setInRange(true);
        }  
        else{
            sonar.setInRange(false);
        }
        
        //Set flags for optimal intake distance
        distanceToBall = sonar.getDistanceFromBall();
        if((distanceToBall>=ballCloseThreshold) && (distanceToBall<=ballFarThreshold)
                && ((distanceToBall<sonar.getPreviousBallReading()+ballGap) || (distanceToBall>sonar.getPreviousBallReading()-ballGap))){
            sonar.setHasBall(true);
        }
        else{
            sonar.setHasBall(false);
        }
        
        //Output values to SmartDasboard for debugging
        SmartDashboard.putNumber("Distance from ball", distanceToBall);
        SmartDashboard.putBoolean("Has ball", sonar.getHasBall());      
        SmartDashboard.putNumber("Distance from wall", distanceToWall);
        SmartDashboard.putBoolean("In range", sonar.getInRange());
                
        //Set up filter for next 20ms loop
        sonar.setPreviousBallReading(distanceToBall);
        sonar.setPreviousWallReading(distanceToWall);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
