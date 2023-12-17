// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleSubsystem;

public class AngleCommand extends CommandBase {
  AngleSubsystem angleSubsystem;
  double angle;
  public AngleCommand(AngleSubsystem angleSubsystem,double angle) {
    this.angleSubsystem=angleSubsystem;
    this.angle=angle;
    addRequirements(angleSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    angleSubsystem.rightMotors.setInverted(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(angle>180){
      angle-=360;
    }
    double angleError = angle-angleSubsystem.gyro.getAngle();
    angleSubsystem.combinedDrive.tankDrive(angleError*angleSubsystem.kP, -angleSubsystem.kP*angleError);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
