package org.example.output;

import org.example.interfaces.OutputWriter;

import java.util.ArrayList;

public class ConsoleWriter implements OutputWriter {
    public void write(ArrayList<Integer> numbers){
      if(numbers.isEmpty()){
          System.out.println("No hay numeros encontrados");
      }
      for(Integer i : numbers){
          System.out.println(i);
      }
    }
}
