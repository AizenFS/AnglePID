// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;



public class AngleSubsystem extends SubsystemBase {

   public CANSparkMax rightMotor1 = new CANSparkMax(1, MotorType.kBrushless);
   public CANSparkMax rightMotor2 = new CANSparkMax(2, MotorType.kBrushless);
   public CANSparkMax leftMotor1 = new CANSparkMax(3, MotorType.kBrushless);
   public CANSparkMax leftMotor2 = new CANSparkMax(4, MotorType.kBrushless);
   public MotorControllerGroup leftMotors = new MotorControllerGroup(rightMotor1,rightMotor2);
   public MotorControllerGroup rightMotors = new MotorControllerGroup(leftMotor1,leftMotor2);
   public double kP = 0.1;
   public AHRS gyro = new AHRS(SPI.Port.kMXP); 
   public DifferentialDrive combinedDrive = new DifferentialDrive(leftMotors, rightMotors);

  public AngleSubsystem() {}
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
