import java.util.Scanner;

public class Simulation {

  private Scanner inputScanner;

  // These integer arrays denote movement in the x and y direction based on the direction currently facing (N,E,S,W)
  private int[] xMovements;
  private int[] yMovements;
  // These integers will track the robots current x and y position
  private int currentX;
  private int currentY;

  public Simulation() {
    this.inputScanner = new Scanner(System.in);
    this.xMovements = new int[]{0,1,0,-1};
    this.yMovements = new int[]{1,0,-1,0};
  }

  public void startSimulation() {
    clearGarbageInput();
  }

  public void clearGarbageInput() {
    String input = this.inputScanner.next();
    while(!isStartString(input)) {
      input = this.inputScanner.next();
    }
  }

  public boolean isStartString(String eval) {
    if(eval == "PLACE") return true;
    return false;
  }
}
