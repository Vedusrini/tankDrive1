// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel; 

public class DriveTrain extends SubsystemBase {
CANSparkMax frontRight; 
CANSparkMax frontLeft; 
CANSparkMax bottomRight; 
CANSparkMax bottomLeft;
MotorControllerGroup rightMotorGroup; 
MotorControllerGroup leftMotorGroup; 
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontRight = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushed);
    frontLeft = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushed);
    bottomRight = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushed); 
    bottomLeft = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushed);
    rightMotorGroup = new MotorControllerGroup(frontRight, bottomRight);
    leftMotorGroup = new MotorControllerGroup(frontLeft, bottomLeft); 
    leftMotorGroup.setInverted(true);
  }

  public void drive(double rightSpeed, double leftSpeed){
   rightMotorGroup.set(rightSpeed);
   leftMotorGroup.set(leftSpeed);
  }


  public void stop(){
    rightMotorGroup.stopMotor();
    leftMotorGroup.stopMotor();  
 }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
