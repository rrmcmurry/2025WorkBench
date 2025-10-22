// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
  
  private WPI_TalonSRX motor1;
  private WPI_TalonSRX motor2;
  private XboxController controller;

  public Robot() {}


  @Override
  public void robotInit() {
    motor1 = new WPI_TalonSRX(1);
    motor2 = new WPI_TalonSRX(2);
    controller = new XboxController(0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    
    if (controller.getAButton()) {
      motor1.set(1.0);      
    }
    else {
      motor1.stopMotor();
    }

    if (controller.getBButton()) {
      motor2.set(1.0);      
    }
    else {
      motor2.stopMotor();
    }    
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
