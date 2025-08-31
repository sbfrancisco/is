package org.example.input;

import org.example.interfaces.InputReader;
import org.example.interfaces.SolverCousin;

import java.util.Scanner;

public class ConsoleReading implements InputReader {
    Scanner sc;

    public ConsoleReading() {
     this.sc = new Scanner(System.in);
    }

    public int read() {
      int number = 0;
      try {
          System.out.print("Enter a number: ");
          number = sc.nextInt();
          System.out.println("You entered: " + number);
      } catch (Exception e) {
          System.out.println("Invalid input. Please enter a valid integer.");
      } finally {
          sc.close();
      }
        return number;
    }
  }
