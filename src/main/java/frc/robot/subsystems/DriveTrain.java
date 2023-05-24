// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
  private VictorSP m_left;
  private VictorSP m_right;
  private VictorSP m_sideMover;

  private DifferentialDrive m_diffDrive;
  public DriveTrain() {
    m_left = new VictorSP(DriveTrainConstants.kLeftMotorPort);
    m_right = new VictorSP(DriveTrainConstants.kRightMotorPort);
    m_right.setInverted(true);
    m_sideMover = new VictorSP(DriveTrainConstants.kSideMotorPort);
    m_diffDrive= new DifferentialDrive(m_left, m_right);
  }

  public void move(double ySpeed, double xSpeed, double zSpeed){
    m_diffDrive.arcadeDrive(ySpeed, zSpeed);
    m_sideMover.set(xSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
