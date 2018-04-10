import java.io.*;

public class Simulation {

  // These integer arrays denote movement in the x and y direction based on the direction currently facing (N,E,S,W)
  private int[] xMovements;
  private int[] yMovements;
  private int directionFacing;
  // These integers will track the robots current x and y position
  private int currentX;
  private int currentY;

  private String[] moveSet;

  public Simulation(String moves) {
    this.moveSet = moves.split("\\r|\\n");
    this.xMovements = new int[]{0,1,0,-1};
    this.yMovements = new int[]{1,0,-1,0};
  }

  public void startSimulation() {
    int startingIndex = getStartCommand();
    placeRobotOnBoard(startingIndex);
    moveRobotOnBoard(startingIndex+1);
  }


  public int getStartCommand() {
    int i = 0;
    while(!this.moveSet[i].split(" ")[0].equals("PLACE")) {i++; if(i >= moveSet.length) break;}
    return i;
  }

  public void placeRobotOnBoard(int index) {
    String[] coordinates = moveSet[index].split("\\s|\\,");
    this.currentX = Integer.parseInt(coordinates[1]);
    this.currentY = Integer.parseInt(coordinates[2]);
    this.directionFacing = parseDirection(coordinates[3]);
  }

  public int parseDirection(String direction) {
    switch (direction) {
      case "NORTH": return 0;
      case "EAST": return 1;
      case "SOUTH": return 2;
      case "WEST": return 3;
    }
    throw new IllegalArgumentException("Invalid Direction");
  }

  public String parseIntDirection() {
    switch (this.directionFacing) {
      case 0: return "NORTH";
      case 1: return "EAST";
      case 2: return "SOUTH";
      case 3: return "WEST";
    }
    throw new IllegalArgumentException("Invalid Direction");
  }

  public void moveRobotOnBoard(int index) {
    while(index < moveSet.length) {
      switch (moveSet[index]) {
        case "MOVE": moveRobot(); break;
        case "LEFT": turnRobotLeft(); break;
        case "RIGHT": turnRobotRight(); break;
        case "REPORT": reportLocation(); break;
      }
      index++;
    }
  }

  // Actual logic for moving the robot on the board
  public void moveRobot() {
    if(!checkMovePossible()) return;
    this.currentX += xMovements[directionFacing];
    this.currentY += yMovements[directionFacing];
  }

  public boolean checkMovePossible() {
    if(this.currentX + xMovements[directionFacing] > 4 || this.currentY + yMovements[directionFacing] > 4) return false;
    if(this.currentX + xMovements[directionFacing] < 0 || this.currentY + yMovements[directionFacing] < 0) return false;
    return true;
  }

  public void turnRobotLeft() {
    this.directionFacing = (this.directionFacing+3)%4;
  }

  public void turnRobotRight() {
    this.directionFacing = (this.directionFacing+1)%4;
  }

  public void reportLocation() {
    System.out.printf("%s,%s,"+parseIntDirection()+"%n", this.currentX, this.currentY);
  }

  //Getters and Setters used for unit testing
  public int getCurrentX() {
    return this.currentX;
  }

  public int getCurrentY() {
    return this.currentY;
  }

  public int getDirectionFacing() {
    return this.directionFacing;
  }

  public void setCurrentX(int x) {
    this.currentX = x;
  }

  public void setCurrentY(int y) {
    this.currentY = y;
  }

  public void setDirectionFacing(int direction) {
    this.directionFacing = direction;
  }
}
