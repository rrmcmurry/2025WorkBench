package frc.robot.subsystems;
import org.photonvision.PhotonCamera;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase{
  // PhotonVision 
  PhotonCamera camera;
  public boolean targetVisible;
  public double targetYaw;  
  public double targetArea;
  

  public VisionSubsystem() {
    camera = new PhotonCamera("FrontLeftCamera"); 
    camera.getLatestResult(); // warm-up  
  }

  
  public void teleopPeriodic(){
    targetVisible = false;
    targetYaw = 0.0;
    targetArea = 0.0;
    var results = camera.getAllUnreadResults();
    if (!results.isEmpty()) {
      var result = results.get(results.size() - 1);
      if (result.hasTargets()){
        for (var target : result.getTargets()) {
          if (target.getFiducialId() == 1) {
            targetVisible = true;
            targetYaw = target.getYaw();
            targetArea = target.getArea();
          }
        }
      }
    }    
  }
}