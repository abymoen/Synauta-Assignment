import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class TestSimulation {

  @Test
  public void testisStartString() {
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
}
