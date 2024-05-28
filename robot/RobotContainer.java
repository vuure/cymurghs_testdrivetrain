package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private Joystick joystick = new Joystick(0);

  private DriveSubsystem driveSubsystem = new DriveSubsystem();
  private DriveCommand driveCommand = new DriveCommand(driveSubsystem, joystick);

  public RobotContainer() {
    configureBindings();
    defaultCommands();
  }

  private void configureBindings() {
  }

  private void defaultCommands(){

    driveSubsystem.setDefaultCommand(driveCommand);

  }

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup();
  }
}
