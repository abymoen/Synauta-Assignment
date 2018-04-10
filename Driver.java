import java.io.*;
import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter the name of the file (must be in the working directory)");

    String fileName = scan.next();
    Reader reader = new Reader(fileName);
    String moveset = reader.readFile();

    Simulation robotSimuation = new Simulation(moveset);
    robotSimuation.startSimulation();
  }
}
