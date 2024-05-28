package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  
  private PWMSparkMax frontleft = new PWMSparkMax(0);
  private PWMSparkMax frontright = new PWMSparkMax(1);
  private PWMSparkMax backleft = new PWMSparkMax(2);
  private PWMSparkMax backright = new PWMSparkMax(3);

  DifferentialDrive leftDrivetrain = new DifferentialDrive(frontleft, frontright);
  DifferentialDrive rightDrivetrain = new DifferentialDrive(backleft, backright);
  
  public DriveSubsystem() {
    frontright.setInverted(true);
    backright.setInverted(true);
  }

  @Override
  public void periodic() {
  }

  public void set(double leftYaxis, double rightXaxis){
    leftDrivetrain.arcadeDrive(rightXaxis, leftYaxis);
    rightDrivetrain.arcadeDrive(rightXaxis, leftYaxis);
  }

  public void stop(){
    leftDrivetrain.arcadeDrive(0, 0);
    rightDrivetrain.arcadeDrive(0, 0);
  }
}
