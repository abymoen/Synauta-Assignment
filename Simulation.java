import java.io.*;

public class Simulation {

  BufferedReader inputReader;
  // These integer arrays denote movement in the x and y direction based on the direction currently facing (N,E,S,W)
  private int[] xMovements;
  private int[] yMovements;
  // These integers will track the robots current x and y position
  private int currentX;
  private int currentY;

  public Simulation(BufferedReader reader) {
    this.inputReader = reader;
    this.xMovements = new int[]{0,1,0,-1};
    this.yMovements = new int[]{1,0,-1,0};
  }

  public void startSimulation() {
    clearGarbageInput();
  }

  public void clearGarbageInput() {
    try {
      String[] str = this.inputReader.readLine().split(" ");
      while(!isStartString(str[0])) {
        str = this.inputReader.readLine().split(" ");
      }
    } catch(IOException e) {
      System.out.println("Error reading from file");
      e.printStackTrace();
    }
    return;
  }

  public boolean isStartString(String eval) {
    if(eval.equals("PLACE")) return true;
    return false;
  }
}
