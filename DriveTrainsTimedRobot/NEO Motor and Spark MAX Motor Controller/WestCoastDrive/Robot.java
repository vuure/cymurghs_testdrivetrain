//Bu, kontrolcünün XBOX kontrolcü varsayıldığı, sol analoğun y ekseni ile robotun ileri-geri gitmesini, sağ analoğun x ekseni ile sağ-sol yönünü ayarlayan bir programdır

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;


public class Robot extends TimedRobot {

  private final PWMSparkMax frontleft = new PWMSparkMax(0);
  private final PWMSparkMax frontright = new PWMSparkMax(1);
  private final PWMSparkMax backleft = new PWMSparkMax(2);
  private final PWMSparkMax backright = new PWMSparkMax(3);

  private final DifferentialDrive m_robotDrive_first = new DifferentialDrive(frontleft, frontright);
  private final DifferentialDrive m_robotDrive_second = new DifferentialDrive(backleft, backright);

  Joystick controller = new Joystick(0);

  @Override
  public void robotInit() {

  }

  @Override
  public void teleopPeriodic() {
    double leftYaxis = controller.getRawAxis(1);
    double rightXaxis = controller.getRawAxis(4);

    m_robotDrive_first.arcadeDrive(rightXaxis * 1, leftYaxis * 1);
    m_robotDrive_second.arcadeDrive(rightXaxis * 1, leftYaxis * 1);
  }
}
