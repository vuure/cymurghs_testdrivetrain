// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {

  private DriveSubsystem driveSubsystem;
  private Joystick controller;

  double getLeftYAxis;
  double getRightXAxis;

  public DriveCommand(DriveSubsystem drive, Joystick controller) {
    this.driveSubsystem = drive;

    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    getLeftYAxis = 0;
    getRightXAxis = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    getLeftYAxis = controller.getRawAxis(1);
    getRightXAxis = controller.getRawAxis(4);

    driveSubsystem.set(getLeftYAxis, getRightXAxis);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
