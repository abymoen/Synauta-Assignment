import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class TestSimulation {

  @Test
  public void testPlaceRobotOnBoard() {
    Simulation sim = new Simulation("FAKE\nPLACE 1,2,NORTH");
    sim.startSimulation();
    assertEquals(1, sim.getCurrentX());
    assertEquals(2, sim.getCurrentY());
    assertEquals(0, sim.getDirectionFacing());
  }

  @Test
  public void testDirectionFacing() {
    Simulation sim = new Simulation("PLACE 1,2,NORTH");
    assertEquals(0, sim.parseDirection("NORTH"));
    assertEquals(1, sim.parseDirection("EAST"));
    assertEquals(2, sim.parseDirection("SOUTH"));
    assertEquals(3, sim.parseDirection("WEST"));
  }

  @Test
  public void testTurnRobot() {
    //In the test file, the robot starts facing north
    Simulation sim = new Simulation("PLACE 1,2,NORTH");
    sim.setCurrentX(1);
    sim.setCurrentX(2);
    sim.setDirectionFacing(0);
    assertEquals(0, sim.getDirectionFacing());
    sim.turnRobotLeft();
    assertEquals(3, sim.getDirectionFacing());
    sim.turnRobotRight();
    assertEquals(0, sim.getDirectionFacing());
    sim.turnRobotRight();
    assertEquals(1, sim.getDirectionFacing());
    sim.turnRobotRight();
    assertEquals(2, sim.getDirectionFacing());
    sim.turnRobotRight();
    assertEquals(3, sim.getDirectionFacing());
    sim.turnRobotRight();
    assertEquals(0, sim.getDirectionFacing());
    sim.turnRobotLeft();
    assertEquals(3, sim.getDirectionFacing());
    sim.turnRobotLeft();
    assertEquals(2, sim.getDirectionFacing());
    sim.turnRobotLeft();
    assertEquals(1, sim.getDirectionFacing());
    sim.turnRobotLeft();
    assertEquals(0, sim.getDirectionFacing());
  }
}
