// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.subsystems.VisionSubsystem;

public class Robot extends TimedRobot {
  
  private WPI_TalonSRX motor1;
  private WPI_TalonSRX motor2;
  private VisionSubsystem camera;

  public Robot() {}


  @Override
  public void robotInit() {
    motor1 = new WPI_TalonSRX(1);
    motor2 = new WPI_TalonSRX(2);
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
    camera.teleopPeriodic();
    if ((camera.targetVisible) && (Math.abs(camera.targetYaw + 8.0) < 0.1 ) && (Math.abs(camera.targetArea) < 3.0)) {
      motor1.set(-1.0);
      motor2.set(1.0);
    }
    else {
      motor1.set(0);
      motor2.set(0);
    }    
  }

  @Override
  public void disabledInit() {
    motor1.set(0);
    motor2.set(0);
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
