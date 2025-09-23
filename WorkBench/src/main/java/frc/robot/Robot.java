// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.subsystems.VisionSubsystem;

public class Robot extends TimedRobot {
  
  private WPI_TalonSRX motor;
  private VisionSubsystem camera;

  public Robot() {}


  @Override
  public void robotInit() {
    motor = new WPI_TalonSRX(1);
    camera = new VisionSubsystem();  
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
    if (camera.targetVisible) {
      motor.set(-1.0);
    }
    else {
      motor.set(0);
    }    
  }

  @Override
  public void disabledInit() {
    motor.set(0);
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
