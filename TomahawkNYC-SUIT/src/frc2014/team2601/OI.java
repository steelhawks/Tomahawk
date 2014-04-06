package frc2014.team2601;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc2014.team2601.commands.collecting.AutoIntakeBall;
import frc2014.team2601.commands.collecting.OpenAndClose;
import frc2014.team2601.commands.launching.DecreaseDelay;
import frc2014.team2601.commands.launching.Fire;
import frc2014.team2601.commands.launching.IncreaseDelay;
import frc2014.team2601.commands.vision.MoveToPosition;
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
    private final Button fire; //, reset;
    //private final Button variableFire;
    //private final Button passFire;
    private final Button increaseDelay, decreaseDelay;
    
    //Attack 3
    private Joystick attack3;
    private final Button openAndClose;
    private final Button resetCamera;
    private final Button setCamera;
    private final Button tiltCameraUp, tiltCameraDown;
    private final Button autoIntake;
    
    public OI(){
        thrustmaster = new Joystick(Map.JOYSTICK_PORT);
        fire = new JoystickButton(thrustmaster, 1);
        //variableFire = new JoystickButton(thrustmaster, 1);
        //passFire = new JoystickButton(thrustmaster, 3);
        increaseDelay = new JoystickButton(thrustmaster, 4);
        decreaseDelay = new JoystickButton(thrustmaster, 5);
        //reset = new JoystickButton(thrustmaster, 2);
        
        attack3 = new Joystick(Map.SECONDARY_JOYSTICK_PORT);
        openAndClose = new JoystickButton(attack3, 1);
        resetCamera = new JoystickButton(attack3, 5);
        setCamera = new JoystickButton(attack3, 4);
        tiltCameraUp = new JoystickButton(attack3, 3);
        tiltCameraDown = new JoystickButton(attack3, 2);
        autoIntake = new JoystickButton(attack3, 6);
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
        //variableFire.whenPressed(new VariableFire());
        //reset.whenPressed(new ResetLauncher());
        //passFire.whenPressed(new PassFire());
        increaseDelay.whileHeld(new IncreaseDelay());
        decreaseDelay.whileHeld(new DecreaseDelay());
        
        //Secondary Controller
        openAndClose.whenPressed(new OpenAndClose());
        setCamera.whenPressed(new MoveToPosition());
        resetCamera.whenPressed(new TiltReset());
        tiltCameraUp.whileHeld(new TiltUp());
        tiltCameraDown.whileHeld(new TiltDown());
        autoIntake.whileHeld(new AutoIntakeBall());
    }
}

