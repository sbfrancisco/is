package org.example.output;

import org.example.interfaces.OutputWriter;

import java.io.*;
import java.util.ArrayList;

public class FileOutput implements OutputWriter {
    BufferedWriter bw;
    File f;
    public FileOutput() throws IOException {
        String path = "output.txt";
        f = new File(path);
        if(!f.exists()){
            f.createNewFile();
        }
        bw = new BufferedWriter(new FileWriter(f, false));
    }
    public void write(ArrayList<Integer> numbers) throws IOException {
        bw.write("Los numeros primos hasta n que ingresaste son: ");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            String n = numbers.get(i).toString();
            if (i != numbers.size() - 1) {
                sb.append(n).append(", ");
            } else {
                sb.append(n); // último elemento, no poner coma
            }
        }
        sb.append("]");
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
    }

}
