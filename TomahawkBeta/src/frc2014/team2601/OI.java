package frc2014.team2601;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc2014.team2601.commands.collecting.OpenAndClose;
import frc2014.team2601.commands.driving.ModeCartesian;
import frc2014.team2601.commands.driving.ModePolar;
import frc2014.team2601.commands.driving.ResetGyro;
import frc2014.team2601.commands.launching.Fire;
import frc2014.team2601.commands.launching.ResetLauncher;
import frc2014.team2601.commands.vision.TiltDown;
import frc2014.team2601.commands.vision.TiltReset;
import frc2014.team2601.commands.vision.TiltUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    //Thrustmaster
    private Joystick thrustmaster;
    private final Button fire;
    private final Button resetGyro, resetCamera;
    private final Button setCartesian, setPolar;
    private final Button resetLauncher;
    
    //Attack 3
    private Joystick attack3;
    private final Button openAndClose;
    private final Button tiltCameraUp, tiltCameraDown;
    
    public OI(){
        thrustmaster = new Joystick(Map.JOYSTICK_PORT);
        fire = new JoystickButton(thrustmaster, 1);
        resetGyro = new JoystickButton(thrustmaster, 2);
        setCartesian = new JoystickButton(thrustmaster, 12);
        setPolar = new JoystickButton(thrustmaster, 11);
        resetLauncher = new JoystickButton(thrustmaster, 4);
        
        attack3 = new Joystick(Map.SECONDARY_JOYSTICK_PORT);
        openAndClose = new JoystickButton(attack3, 1);
        resetCamera = new JoystickButton(attack3, 5);
        tiltCameraUp = new JoystickButton(attack3, 2);
        tiltCameraDown = new JoystickButton(attack3, 3);
        setButtons();
    }
    
    public Joystick getPrimaryController(){
        return thrustmaster;
    }
    
    public Joystick getSecondaryController(){
        return attack3;
    }
    
    public void setButtons(){
        //Primary Controller
        fire.whenPressed(new Fire());
        resetGyro.whenPressed(new ResetGyro());
        setCartesian.whenPressed(new ModeCartesian());
        setPolar.whenPressed(new ModePolar());
        resetLauncher.whenPressed(new ResetLauncher());
        
        //Secondary Controller
        openAndClose.whenPressed(new OpenAndClose());
        resetCamera.whenPressed(new TiltReset());
        tiltCameraUp.whileHeld(new TiltUp());
        tiltCameraDown.whileHeld(new TiltDown());
    }
}

