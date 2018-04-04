import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSimulation {

  @Test
  public void testisStartString() {
    Simulation sim = new Simulation();
    assertTrue(sim.isStartString("PLACE"));
    assertFalse(sim.isStartString("PLAC"));
    assertFalse(sim.isStartString(""));
    assertFalse(sim.isStartString("MOVE"));
    assertFalse(sim.isStartString("place"));
  }
}
