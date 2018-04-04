import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class TestSimulation {

  @Test
  public void testIsStartString() {
    try {
      Simulation sim = new Simulation(new BufferedReader(new FileReader("TestInput.txt")));
      assertTrue(sim.isStartString("PLACE"));
      assertFalse(sim.isStartString("PLAC"));
      assertFalse(sim.isStartString(""));
      assertFalse(sim.isStartString("MOVE"));
      assertFalse(sim.isStartString("place"));
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testPlaceRobotOnBoard() {
    try {
      Simulation sim = new Simulation(new BufferedReader(new FileReader("TestInput.txt")));
      sim.startSimulation();
      assertEquals(1, sim.getCurrentX());
      assertEquals(2, sim.getCurrentY());
      assertEquals(0, sim.getDirectionFacing());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testDirectionFacing() {
    try {
      Simulation sim = new Simulation(new BufferedReader(new FileReader("TestInput.txt")));
      assertEquals(0, sim.parseDirection("NORTH"));
      assertEquals(1, sim.parseDirection("EAST"));
      assertEquals(2, sim.parseDirection("SOUTH"));
      assertEquals(3, sim.parseDirection("WEST"));
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testTurnRobot() {
    try {
      //In the test file, the robot starts facing north
      Simulation sim = new Simulation(new BufferedReader(new FileReader("TestInput.txt")));
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
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
