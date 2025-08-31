package org.example.input;

import org.example.interfaces.InputReader;

import java.io.*;

public class FileReading implements InputReader {
    FileReader fr;
    BufferedReader br;
  public FileReading() throws IOException {

      String path = "input.txt";
      try {
          fr = new FileReader(path);
      } catch (FileNotFoundException e) {

        File f = new File(path);
        if(f.exists()){
            System.out.println("Hola");
        }
        f.createNewFile();
        fr = new FileReader(f);
      }
      br = new BufferedReader(fr);
  }
    public int read() throws IOException {
        if(br.readLine() == null) {
            return 0;
        }
        return Integer.parseInt(br.readLine());
    }
}
