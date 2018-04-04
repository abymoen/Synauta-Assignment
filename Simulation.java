import java.io.*;

public class Simulation {

  BufferedReader inputReader;
  // These integer arrays denote movement in the x and y direction based on the direction currently facing (N,E,S,W)
  private int[] xMovements;
  private int[] yMovements;
  private int directionFacing;
  // These integers will track the robots current x and y position
  private int currentX;
  private int currentY;

  public Simulation(BufferedReader reader) {
    this.inputReader = reader;
    this.xMovements = new int[]{0,1,0,-1};
    this.yMovements = new int[]{1,0,-1,0};
  }

  public void startSimulation() {
    String[] startingStringArry = getStartCommand();
    placeRobotOnBoard(startingStringArry[1]);
  }


  public String[] getStartCommand() {
    String[] str = new String[0];
    try {
      str = this.inputReader.readLine().split(" ");
      while(!isStartString(str[0])) {
        str = this.inputReader.readLine().split(" ");
      }
    } catch(IOException e) {
      System.out.println("Error reading from file");
      e.printStackTrace();
    }
    return str;
  }

  public boolean isStartString(String eval) {
    if(eval.equals("PLACE")) return true;
    return false;
  }

  public void placeRobotOnBoard(String location) {
    String[] coordinates = location.split(",");
    this.currentX = Integer.parseInt(coordinates[0]);
    this.currentY = Integer.parseInt(coordinates[1]);
    this.directionFacing = parseDirection(coordinates[2]);
  }

  public int parseDirection(String direction) {
    if(direction.equals("NORTH")) return 0;
    if(direction.equals("EAST")) return 1;
    if(direction.equals("SOUTH")) return 2;
    if(direction.equals("WEST")) return 3;
    throw new IllegalArgumentException("Invalid Direction");
  }

  public int getCurrentX() {
    return this.currentX;
  }

  public int getCurrentY() {
    return this.currentY;
  }

  public int getDirectionFacing() {
    return this.directionFacing;
  }
}
