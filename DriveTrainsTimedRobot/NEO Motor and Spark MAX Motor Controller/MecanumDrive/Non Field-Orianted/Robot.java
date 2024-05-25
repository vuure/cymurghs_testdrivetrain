
/*Bu, kontrolcünün XBOX kontrolcü varsayıldığı, sol analoğun y ekseni ile robotun ileri-geri gitmesini, sol analoğun x ekseni ile sağ-sola gitmesini, sağ analoğun x ekseni ile 
sağ-sol yönünü ayarlayan bir programdır*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;


public class Robot extends TimedRobot {

  private final PWMSparkMax frontleft = new PWMSparkMax(0);
  private final PWMSparkMax frontright = new PWMSparkMax(1);
  private final PWMSparkMax backleft = new PWMSparkMax(2);
  private final PWMSparkMax backright = new PWMSparkMax(3);

  MecanumDrive m_robotDrive = new MecanumDrive(frontleft, backleft, frontright, backright);

  Joystick controller = new Joystick(0);

  @Override
  public void robotInit() {

  }

  @Override
  public void teleopPeriodic() {
    double leftYaxis = controller.getRawAxis(1);
    double rightXaxis = controller.getRawAxis(0);
    double leftXaxis = controller.getRawAxis(4);

    m_robotDrive.driveCartesian(-leftYaxis, -rightXaxis, leftXaxis);
  }
}
