import java.io.*;
import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter the name of the file (must be in the working directory)");
    String fileName = scan.next();

    try {
      BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
      Simulation robotSimuation = new Simulation(fileReader);
      robotSimuation.startSimulation();
      fileReader.close();
    } catch(FileNotFoundException e) {
      System.out.println("File not found: " + fileName);
    } catch(IOException e) {
      System.out.println("Error closing " + fileName);
      e.printStackTrace();
    }
  }
}
