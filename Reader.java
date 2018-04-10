import java.io.*;

public class Reader {

  private BufferedReader reader;

  public Reader(String fileName) {
    try {
      this.reader = new BufferedReader(new FileReader(fileName));
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  //Assumes the file fits into memory
  public String readFile() {
    StringBuilder build = new StringBuilder();
    try {
      String temp = reader.readLine();
      while(temp != null) {
        build.append(temp+"\n");
        temp = reader.readLine();
      }
      this.reader.close();
      return build.toString();
    } catch(IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
