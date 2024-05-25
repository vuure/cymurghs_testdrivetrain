/*Bu, kontrolcünün XBOX kontrolcü varsayıldığı, sol analoğun y ekseni ile robotun ileri-geri gitmesini, sol analoğun x ekseni ile sağ-sola gitmesini, sağ analoğun x ekseni ile 
sağ-sol yönünü ayarlayan bir programdır*/

package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Robot extends TimedRobot {

  ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  private final WPI_VictorSPX backright = new WPI_VictorSPX(23);
  private final WPI_VictorSPX frontright = new WPI_VictorSPX(22);
  private final WPI_TalonSRX frontleft = new WPI_TalonSRX(24);
  private final WPI_VictorSPX backleft = new WPI_VictorSPX(25);

  MecanumDrive m_robotDrive = new MecanumDrive(frontleft, backleft, frontright, backright);

  Joystick controller = new Joystick(0);

  double leftYaxis;
  double rightXaxis;
  double leftXaxis;
  Rotation2d gyroRotation2d;

  @Override
  public void robotInit() {

  }

  @Override
  public void teleopPeriodic() {
    leftYaxis = controller.getRawAxis(1);
    rightXaxis = controller.getRawAxis(0);
    leftXaxis = controller.getRawAxis(4);

    gyroRotation2d = gyro.getRotation2d();

    m_robotDrive.driveCartesian(-leftYaxis, -rightXaxis, leftXaxis, gyroRotation2d.unaryMinus());
  }
}
