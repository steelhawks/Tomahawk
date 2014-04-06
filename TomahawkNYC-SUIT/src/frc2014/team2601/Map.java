package frc2014.team2601;

//package src;

/**
 * The Constants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Map {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the portac
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //General
    public static final int DIGITAL_MODULE = 1; //cRIO Slot
    
    //Operator Interface
    public static final int JOYSTICK_PORT = 1; //Driver Station, USB
    public static final int SECONDARY_JOYSTICK_PORT = 2; //Driver Station, USB
    public static final int TERNARY_JOYSTICK_PORT = 3; //Driver Station, USB
    
    //Drivetrain
    public static final int FRONT_LEFT_MOTOR = 4; //Digital Sidecar, PWM
    public static final int REAR_LEFT_MOTOR = 3; //Digital Sidecar, PWM
    public static final int FRONT_RIGHT_MOTOR = 1; //Digital Sidecar, PWM
    public static final int REAR_RIGHT_MOTOR = 2; //Digital Sidecar, PWM
    
    //Arms
    public static final int ARM_MOTOR = 5; //Digital Sidecar, PWM
    public static final int ARM_OPEN = 4; //cRIO, Solenoid Breakout
    public static final int ARM_CLOSE = 5; //cRIO, Solenoid Breakout
    public static final int ARM_SONAR_INPUT = 4; //Digital Sidecar, DIO; Labeled with red electrical tape "Input"
    public static final int ARM_SONAR_OUTPUT = 3; //Digital Sidecar, DIO
    
    //Launcher
    public static final int LEFT_PISTON_RETRACT = 3; //cRIO, Solenoid Breakout
    public static final int LEFT_PISTON_EXTEND = 1; //cRIO, Solenoid Breakout
    public static final int MIDDLE_PISTON_RETRACT = 2; //cRIO, Solenoid Breakout
    public static final int MIDDLE_PISTON_EXTEND = 6; //cRIO, Solenoid Breakout
    public static final int RIGHT_PISTON_RETRACT = 7; //cRIO, Solenoid Breakout
    public static final int RIGHT_PISTON_EXTEND = 8; //cRIO, Solenoid Breakout
    public static final int LAUNCHER_SONAR_INPUT = 2; //Digital Sidecar, DIO;
    public static final int LAUNCHER_SONAR_OUTPUT = 1; //Digital Sidecar, DIO
    public static final int PRESSURE_SWITCH = 14; //Digital Sidecar, DIO
    public static final int COMPRESSOR_RELAY = 2; //Digital Sidecar, Relay
    
    //Lights
    public static final int BLUE_LIGHT_RELAY = 3; //Digital Sidecar, Relay; old 4
    public static final int RED_LIGHT_RELAY = 4; //Digital Sidecar, Relay; old 3
    
    //Camera and CV
    public static final int SERVO = 6; //Digital Sidecar, PWM (Jumper)
    public static final int CAMERA_LIGHT_RELAY = 1; //Digital Sidecar, Relay;
}

